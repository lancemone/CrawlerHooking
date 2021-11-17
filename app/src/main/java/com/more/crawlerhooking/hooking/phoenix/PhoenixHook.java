package com.more.crawlerhooking.hooking.phoenix;

import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.http.HttpRequest;
import com.more.crawlerhooking.http.beans.PhoenixReportBean;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.StringUtils;
import com.more.crawlerhooking.utils.UrlUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class PhoenixHook {

    private final String device;
    private final String country;
    private final String taskTurn;
    private String lastTitle = "";

    public PhoenixHook(XC_LoadPackage.LoadPackageParam loadPackageParam, XSharedPreferences prefs){
        this.device = prefs.getString(Common.SerialNoKey, "");
        this.country = prefs.getString(Common.PhoenixCountryKey, "");
        this.taskTurn = prefs.getString(Common.TaskTurnKey, "");
        hookQbUrl(loadPackageParam);
//        hookVideoReturn(loadPackageParam);
//        hookFeedsDataManager(loadPackageParam);
//        hookC70m(loadPackageParam);
    }


    private void hookQbUrl(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> classSvG =  XposedHelpers.findClassIfExists("sv.c", loadPackageParam.classLoader);
        if (classSvG != null){
            XposedHelpers.findAndHookMethod(classSvG, "g", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object result = param.getResult();
                    if (result != null){
                        String qbUrl = result.toString();
                        qbUrl = URLDecoder.decode(qbUrl, "utf-8");
//                        LogUtils.i("decode qbUrl: " + qbUrl);
                        Map<String, String> params = UrlUtils.getUrlAllParams(qbUrl);
//                        LogUtils.i("params: " + params.toString());
                        String title = params.get("title");
                        String publisher = params.get("publisher");
                        if (lastTitle.equals(title+publisher)){
                            return;
                        }
                        lastTitle = title + publisher;
                        PhoenixReportBean.ReportDataBean reportData = new PhoenixReportBean.ReportDataBean();
                        reportData.setDeviceId(device);
                        reportData.setDeviceCountry(country);
                        reportData.setTaskTurn(taskTurn);
                        reportData.setVid(params.get("vid"));
                        reportData.setTitle(title);
                        reportData.setPlayUrl(params.get("playUrl"));
                        reportData.setOptPlayUrl(params.get("optPlayUrl"));
                        reportData.setPicUrl(params.get("picUrl"));
                        reportData.setPublisher(publisher);
                        reportData.setFrom(params.get("from"));
                        reportData.setTag(params.get("tag"));
                        reportData.setCommentCount(Integer.parseInt(params.get("commentCount")));
                        reportData.setDownloadCount(Integer.parseInt(params.get("downloadCount")));
                        reportData.setShareCount(Integer.parseInt(params.get("shareCount")));
                        reportData.setLikeCount(Integer.parseInt(params.get("praiseCount")));
                        reportData.setViewCount(Integer.parseInt(params.get("view")));
                        PhoenixReportBean phoenixReport = new PhoenixReportBean(reportData);
                        LogUtils.i("start CrawlerReportRecord");
                        HttpRequest.CrawlerReportRecord(phoenixReport);
                    }
                }
            });
        }
    }

    private void hookVideoReturn(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> classInternalF =  XposedHelpers.findClassIfExists("com.cloudview.tup.internal.f", loadPackageParam.classLoader);
        if (classInternalF != null){
            XposedHelpers.findAndHookMethod(classInternalF, "d", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object result = param.getResult();
                    StringBuilder builder = new StringBuilder();
                    builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
                    builder.append(result).append("\n");
                    builder.append("Dump Stack: ---------------start----------------").append("\n");
                    Throwable ex = new Throwable();
                    StackTraceElement[] stackElements = ex.getStackTrace();
                    if (stackElements != null) {
                        for (int i = 0; i < stackElements.length; i++) {
                            builder.append("Dump Stack").append(i).append(": ");
                            builder.append(stackElements[i].getClassName()).append(".").append(stackElements[i].getMethodName()).append("\n");
                        }
                    }
                    builder.append("Dump Stack: ---------------over----------------").append("\n");
                    builder.append("com.cloudview.tup.internal.f.d result object class: ").append(result.getClass().getName()).append("\n");
                    builder.append("com.cloudview.tup.internal.f.d result: ").append(result.toString()).append("\n");
                    Object a = XposedHelpers.getObjectField(result, "a");
                    builder.append("a: ").append(a.toString()).append("\n");
//                    Object b = XposedHelpers.getObjectField(result, "b");
//                    builder.append("b: " + b.toString());
                    byte[] c = (byte[]) XposedHelpers.getObjectField(result, "c");
                    builder.append("c: ").append(new String(c, StandardCharsets.UTF_8)).append("\n");
//                    builder.append("c Base64String: ").append(StringUtils.byte2Base64String(c)).append("\n");
                    List e = (List) XposedHelpers.getObjectField(result, "e");
                    if (e.size() > 0){
                        for (int i=0; i<e.size(); i++){
                            builder.append("e-").append(i).append(" : ").append(e.get(i).toString()).append("\n");
                        }
                    }
                    Object obj = toObject(c);
                    if (obj != null){
                        builder.append("c toObject: ").append(obj.toString()).append("\n");
                    }else {
                        builder.append("c toObject is null").append("\n");
                    }
                    builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
                    LogUtils.i(builder.toString());
//                    DecodeBytes.decode(param, result);
                }
            });
        }
    }

    private Object toObject(byte[] bytes){
        Object obj = null;
        try {
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
            obj = objectInputStream.readObject();
            arrayInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private void hookFeedsDataManager(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> classFDM =  XposedHelpers.findClassIfExists("com.tencent.mtt.browser.feeds.framework.manager.FeedsDataManager", loadPackageParam.classLoader);
        if (classFDM != null){
            XposedHelpers.findAndHookMethod(classFDM, "h", "zp.f", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object result = param.getResult();
                    Object zpf = param.args[0];
                    StringBuilder builder = new StringBuilder();
                    builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
                    builder.append(result).append("\n");
                    builder.append("Dump Stack: ---------------start----------------").append("\n");
                    Throwable ex = new Throwable();
                    StackTraceElement[] stackElements = ex.getStackTrace();
                    if (stackElements != null) {
                        for (int i = 0; i < stackElements.length; i++) {
                            builder.append("Dump Stack").append(i).append(": ");
                            builder.append(stackElements[i].getClassName()).append(".").append(stackElements[i].getMethodName()).append("\n");
                        }
                    }
                    builder.append("Dump Stack: ---------------over----------------").append("\n");
                    builder.append("com.tencent.mtt.browser.feeds.framework.manager.FeedsDataManager.h result object class: ").append(result.getClass().getName()).append("\n");
                    builder.append("com.tencent.mtt.browser.feeds.framework.manager.FeedsDataManager.h param class: ").append(zpf.getClass().getName()).append("\n");
                    int fa = XposedHelpers.getIntField(zpf, "a");
                    builder.append("zp.f.a: ").append(fa).append("\n");
                    int fc = XposedHelpers.getIntField(zpf, "c");
                    builder.append("zp.f.c: ").append(fc).append("\n");
                    ArrayList<?> fd = (ArrayList<?>) XposedHelpers.getObjectField(zpf, "d");
                    if (fd.size() > 0){
                        for (Object zpj : fd){
                            String clazz = zpj.getClass().getName();
                            builder.append("zp.f.d: ").append(clazz).append("\n");
                            builder.append("-------------------------------").append("\n");
                            Object jbb = XposedHelpers.getObjectField(zpj, "B");
                            if (jbb != null){
                                builder.append(clazz).append(" B: ").append(jbb.toString()).append("\n");
                            }
                            Object jj = XposedHelpers.getObjectField(zpj, "j");
                            if (jj != null){
                                builder.append(clazz).append(" j: ").append(jj.toString()).append("\n");
                            }
                            String ja = (String) XposedHelpers.getObjectField(zpj, "a");
                            builder.append(clazz).append(" a: ").append(ja).append("\n");
                            String jc = (String) XposedHelpers.getObjectField(zpj, "c");
                            builder.append(clazz).append(" c: ").append(jc).append("\n");
                            String jd = (String) XposedHelpers.getObjectField(zpj, "d");
                            builder.append(clazz).append(" d: ").append(jd).append("\n");
                            String je = (String) XposedHelpers.getObjectField(zpj, "e");
                            builder.append(clazz).append(" e: ").append(je).append("\n");
                            int jb = XposedHelpers.getIntField(zpj, "b");
                            builder.append(clazz).append(" b: ").append(jb).append("\n");
                            int jf = XposedHelpers.getIntField(zpj, "f");
                            builder.append(clazz).append(" f: ").append(jf).append("\n");
                            int jg = XposedHelpers.getIntField(zpj, "g");
                            builder.append(clazz).append(" g: ").append(jg).append("\n");
                            int jh = XposedHelpers.getIntField(zpj, "h");
                            builder.append(clazz).append(" h: ").append(jh).append("\n");
                            ArrayList<String> jz = (ArrayList<String>) XposedHelpers.getObjectField(zpj, "z");
                            if (!jz.isEmpty()){
                                for (String z : jz){
                                    builder.append(clazz).append(" z: ").append(z).append("\n");
                                }
                            }
                            ArrayList<?> jk = (ArrayList<?>) XposedHelpers.getObjectField(zpj, "k");
                            if (jk != null && !jk.isEmpty()){
                                for (Object k : jk){
                                    builder.append(clazz).append(" k: ").append(k).append("\n");
                                }
                            }
                            Set<?> jw = (Set<?>) XposedHelpers.getObjectField(zpj, "w");
                            if (!jw.isEmpty()){
                                for (Object w : jw){
                                    builder.append(clazz).append(" w: ").append(w).append("\n");
                                }
                            }
                            builder.append("-------------------------------").append("\n");
                        }
                    }
                    byte fe = XposedHelpers.getByteField(zpf, "e");
                    builder.append("zp.f.e: ").append(fe).append("\n");
                    String ng = (String) XposedHelpers.getObjectField(result, "g");
                    builder.append("result k8.n g: ").append(ng).append("\n");
                    String nh = (String) XposedHelpers.getObjectField(result, "h");
                    builder.append("result k8.n h: ").append(nh).append("\n");
                    String nj = (String) XposedHelpers.getObjectField(result, "j");
                    builder.append("result k8.n j: ").append(nj).append("\n");
                    String nl = (String) XposedHelpers.getObjectField(result, "l");
                    builder.append("result k8.n l: ").append(nl).append("\n");
                    String np = (String) XposedHelpers.getObjectField(result, "p");
                    builder.append("result k8.n p: ").append(np).append("\n");
                    String nq = (String) XposedHelpers.getObjectField(result, "q");
                    builder.append("result k8.n q: ").append(nq).append("\n");
                    Object ni = XposedHelpers.getObjectField(result, "i");
                    builder.append("result k8.n i: ").append(ni).append("\n");
                    Object nk = XposedHelpers.getObjectField(result, "k");
                    if (nk != null){
                        builder.append("result k8.n k: ").append(nk.toString()).append("\n");
                    }
                    Object nm = XposedHelpers.getObjectField(result, "m");
                    builder.append("result k8.n m: ").append(nm).append("\n");
                    Object nr = XposedHelpers.getObjectField(result, "r");
                    builder.append("result k8.n r: ").append(nr).append("\n");
                    Object no = XposedHelpers.getObjectField(result, "o");
                    builder.append("result k8.n o: ").append(no).append("\n");
                    builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
                    LogUtils.i(builder.toString());
                }
            });
        }
    }

    private void hookC70m(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> classFDM =  XposedHelpers.findClassIfExists("c70.m", loadPackageParam.classLoader);
        if (classFDM != null){
            LogUtils.i("findClass " + classFDM.getName());
            XposedHelpers.findAndHookMethod(classFDM, "readFrom", "s8.c", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Object c70m = param.thisObject;
                    StringBuilder builder = new StringBuilder();
                    builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
                    builder.append("c70.m.a: ").append(XposedHelpers.getIntField(c70m, "a")).append("\n");
                    builder.append("c70.m.b: ").append(XposedHelpers.getIntField(c70m, "b")).append("\n");
                    ArrayList<?> mc = (ArrayList<?>) XposedHelpers.getObjectField(c70m, "c");
                    if (mc != null && !(mc.isEmpty() || mc.size() == 0)){
                        for (Object c : mc){
                            builder.append("-------------------------------").append("\n");
                            builder.append("c70.m.c: ").append(c.toString()).append("\n");
                            String c0 = c.getClass().getName();
                            builder.append(c0).append(".a: ").append(XposedHelpers.getObjectField(c, "a")).append("\n");
                            builder.append(c0).append(".b: ").append(XposedHelpers.getIntField(c, "b")).append("\n");
                            builder.append(c0).append(".c: ").append(XposedHelpers.getIntField(c, "c")).append("\n");
                            byte[] c0d = (byte[]) XposedHelpers.getObjectField(c, "d");
                            builder.append(c0).append(".d: ").append(new String(c0d)).append("\n");
                            builder.append(c0).append(".e: ").append(XposedHelpers.getObjectField(c, "e")).append("\n");
                            builder.append(c0).append(".f: ").append(XposedHelpers.getObjectField(c, "f")).append("\n");
                            builder.append(c0).append(".g: ").append(XposedHelpers.getObjectField(c, "g").toString()).append("\n");
                            builder.append(c0).append(".h: ").append(XposedHelpers.getObjectField(c, "h")).append("\n");
                            builder.append(c0).append(".q: ").append(XposedHelpers.getObjectField(c, "q").toString()).append("\n");
                            ArrayList<?> c0r = (ArrayList<?>) XposedHelpers.getObjectField(c, "r");
                            if (c0r != null && !(c0r.isEmpty() || c0r.size() == 0)){
                                for (Object r : c0r){
                                    builder.append(c0).append(".r: ").append(r).append("\n");
                                }
                            }
                            ArrayList<?> c0s = (ArrayList<?>) XposedHelpers.getObjectField(c, "s");
                            if (c0s != null && !(c0s.isEmpty() || c0s.size() == 0)){
                                for (Object s : c0s){
                                    builder.append(c0).append(".r: ").append(s).append("\n");
                                }
                            }
                            builder.append("-------------------------------").append("\n");
                        }
                    }
                    builder.append("c70.m.d: ").append(XposedHelpers.getBooleanField(c70m, "d")).append("\n");
                    ArrayList<?> me = (ArrayList<?>) XposedHelpers.getObjectField(c70m, "e");
                    if (me != null && !(me.isEmpty() || me.size() == 0)){
                        for (Object e : me){
                            builder.append("c70.m.e: ").append(e).append("\n");
                        }
                    }
                    builder.append("c70.m.f: ").append(XposedHelpers.getObjectField(c70m, "f")).append("\n");
                    builder.append("c70.m.g: ").append(XposedHelpers.getObjectField(c70m, "g")).append("\n");
                    ArrayList<?> mq = (ArrayList<?>) XposedHelpers.getObjectField(c70m, "q");
                    if (mq != null && !(mq.isEmpty() || mq.size() == 0)){
                        for (Object q : mq){
                            builder.append("c70.m.q: ").append(q).append("\n");
                        }
                    }
                    builder.append("c70.m.u: ").append(XposedHelpers.getObjectField(c70m, "u").toString()).append("\n");
                    builder.append("c70.m.w: ").append(XposedHelpers.getLongField(c70m, "w")).append("\n");
                    builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
                }
            });
        }
    }
}
