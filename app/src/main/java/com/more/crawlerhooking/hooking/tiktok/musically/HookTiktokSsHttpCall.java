package com.more.crawlerhooking.hooking.tiktok.musically;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.RegexUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTiktokSsHttpCall {

    private String serial = null;
    private String taskTurn = null;
    private final XC_LoadPackage.LoadPackageParam loadPackageParam;

    public HookTiktokSsHttpCall(XC_LoadPackage.LoadPackageParam loadPackageParam, String serial, String taskTurn) {
        this.serial = serial;
        this.taskTurn = taskTurn;
        this.loadPackageParam = loadPackageParam;
        hookGetResponseWithInterceptorChain(loadPackageParam);
        hookBaseSsInterceptor();
        hookSystemRegion();
    }

    // 获取网络请求结果
    private void hookGetResponseWithInterceptorChain(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        Class<?> ssHttpCallClazz = XposedHelpers.findClassIfExists(TiktokConfig.SsHttpCallClass, loadPackageParam.classLoader);
        if (ssHttpCallClazz != null) {
            try {
                XposedHelpers.findAndHookMethod(ssHttpCallClazz, TiktokConfig.GetResponseMethod, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object response = param.getResult();
                        if (response == null) {
                            return;
                        }
                        Object rawResponse = XposedHelpers.getObjectField(response, TiktokConfig.RetrofitResponseRawResponseField);
                        if (rawResponse == null) {
                            LogUtils.i("rawResponse is null");
                            return;
                        }
                        String requestUlr = (String) XposedHelpers.getObjectField(rawResponse, "a");
                        if (!RegexUtils.urlMatchFiler(requestUlr)) {
                            serial.toLowerCase().contains("region");
                            return;
                        }
                        StringBuilder builder = new StringBuilder();
                        builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
                        builder.append(TiktokConfig.GetResponseMethod).append(" afterHookedMethod:").append("\n");
                        Object originalRequest = XposedHelpers.callMethod(param.thisObject, "request");
                        builder.append("Request Url:\n").append(XposedHelpers.callMethod(originalRequest, TiktokConfig.RetrofitRequestGetUrlMethod)).append("\n");
                        builder.append("Request Url: ").append(XposedHelpers.callMethod(originalRequest, TiktokConfig.RetrofitRequestGetMethodMethod)).append("\n");
                        builder.append("Request Headers: \n").append(XposedHelpers.callMethod(originalRequest, TiktokConfig.RetrofitRequestGetHeadersMethod)).append("\n");
                        builder.append("Request ServiceType: ").append(XposedHelpers.callMethod(originalRequest, TiktokConfig.RetrofitRequestGetServiceTypeMethod)).append("\n");
                        builder.append("Request Body: ").append(XposedHelpers.callMethod(originalRequest, TiktokConfig.RetrofitRequestGetBodyMethod)).append("\n");
                        builder.append("response object Info:").append(response.getClass().getName()).append("\n");
                        builder.append("StatusCode: ").append(XposedHelpers.getIntField(rawResponse, "b")).append("\n");
                        builder.append("reason: ").append(XposedHelpers.getObjectField(rawResponse, "c")).append("\n");
                        List<?> headers = (List<?>) XposedHelpers.callMethod(response, TiktokConfig.RetrofitResponseHeadersMethod);
                        if (headers != null || !headers.isEmpty()) {
                            builder.append("Headers:\n");
                            for (Object bb : headers) {
                                builder.append("\t").append(bb.toString()).append("\n");
                            }
                        }
                        Object rawTypedInput = XposedHelpers.getObjectField(rawResponse, "e");
                        if (rawTypedInput != null) {
                            String mimeType = (String) XposedHelpers.callMethod(rawTypedInput, "mimeType");
                            builder.append("rawResponse TypedInput mimeType:").append(mimeType).append("\n");
                            if (mimeType.equals("application/x-protobuf; charset=utf-8")) {
                                Field bytesField = XposedHelpers.findFieldIfExists(rawTypedInput.getClass(), "bytes");
                                if (bytesField != null) {
                                    byte[] bytes = (byte[]) XposedHelpers.callMethod(rawTypedInput, "getBytes");
                                    LogUtils.i("start AwemeFeedResponseProtobufReport");
//                                    HttpRequest.AwemeFeedResponseProtobufReport(bytes);
                                }
                            }
                            String fakeFileName = (String) XposedHelpers.callMethod(rawTypedInput, "fileName");
                            builder.append("rawResponse TypedInput fakeFileName:").append(fakeFileName).append("\n");
                        }
                        builder.append("rawResponse Object f:").append(XposedHelpers.getObjectField(rawResponse, "f")).append("\n");
                        Object body = XposedHelpers.getObjectField(response, "c");
                        if (body != null) {
                            builder.append("Response body:\n").append(body).append("\n");
                        } else {
                            builder.append("Response body(c) is null").append("\n");
                        }
                        Object T = XposedHelpers.getObjectField(response, "b");
                        if (T != null) {
                            Gson gson = new GsonBuilder().create();
                            String jsonString = gson.toJson(T);
                            builder.append("Response T:\n").append(T.getClass().getName()).append(": ").append(jsonString).append("\n");
                        }
                        Object qObj = XposedHelpers.getObjectField(response, "d");
                        if (qObj != null) {
                            builder.append("Response q:\n").append(qObj).append("\n");
                            builder.append("Response q.a:\n").append(XposedHelpers.callMethod(qObj, "a")).append("\n");
                            Object jsonObjectE = XposedHelpers.callMethod(qObj, "e");
                            builder.append("jsonObject e").append(jsonObjectE.toString()).append("\n");
                        }
                        builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
                        LogUtils.i(builder.toString());
                    }
                });
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }

    private void hookBaseSsInterceptor(){
//        Class<?> requestClazz = XposedHelpers.findClass("com.bytedance.retrofit2.b.c", loadPackageParam.classLoader);
        Class<?> requestClazz = XposedHelpers.findClass("com.bytedance.retrofit2.client.Request", loadPackageParam.classLoader);
        Class<?> baseSsInterceptor = XposedHelpers.findClass("com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor", this.loadPackageParam.classLoader);
        if (baseSsInterceptor != null){
            XposedHelpers.findAndHookMethod(baseSsInterceptor, "a", requestClazz, new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Object request = param.args[0];
//                    Object headers = XposedHelpers.getObjectField(request, "c");
                    Object headers = XposedHelpers.getObjectField(request, TiktokConfig.RetrofitRequestHeadersField);
                    if (headers instanceof List){
                        List<Object> newHeaders = new ArrayList<>((Collection<?>) headers);
                        newHeaders.add(bytedanceRetrofitBObject("X-Forwarded-For", "105.235.119.203"));
                        XposedHelpers.setObjectField(request, TiktokConfig.RetrofitRequestHeadersField, newHeaders);
                        LogUtils.i("X-Forwarded-For add success");
                    }
                }

//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Object request = param.getResult();
//                    List<Object> headers = (List<Object>) XposedHelpers.getObjectField(request, "c");
//                }
            });
        }
    }

    private void hookSystemRegion(){
        Class<?> settingServiceImplClass = XposedHelpers.findClass("com.ss.android.ugc.aweme.setting.services.SettingServiceImpl", loadPackageParam.classLoader);
        if (settingServiceImplClass != null){
            XposedHelpers.findAndHookMethod(settingServiceImplClass, "i", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    param.setResult(TiktokConfig.SerialToRegion.get(serial));
                }
            });
            XposedHelpers.findAndHookMethod(settingServiceImplClass, "j", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    param.setResult(TiktokConfig.SerialToRegion.get(serial));
                }
            });
        }
    }

    private Object bytedanceRetrofitBObject(String str1, String str2){
//        String className = "com.bytedance.retrofit2.b.b";
        String className = "com.bytedance.retrofit2.client.b";
        Class<?> retrofit2BClazz = XposedHelpers.findClass(className, this.loadPackageParam.classLoader);
        return XposedHelpers.newInstance(retrofit2BClazz, str1, str2);
    }
}
