package com.more.crawlerhooking.hooking.tiktok;

import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.RegexUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTiktokSsHttpCall {

    private String serial = null;
    private String taskTurn = null;

    public HookTiktokSsHttpCall(XC_LoadPackage.LoadPackageParam loadPackageParam, String serial, String taskTurn){
        this.serial = serial;
        this.taskTurn = taskTurn;
        hookGetResponseWithInterceptorChain(loadPackageParam);
    }

    private void hookGetResponseWithInterceptorChain(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> ssHttpCallClazz = XposedHelpers.findClassIfExists(TiktokConfig.SsHttpCallClass, loadPackageParam.classLoader);
        if (ssHttpCallClazz != null){
            try {
                XposedHelpers.findAndHookMethod(ssHttpCallClazz, TiktokConfig.GetResponseMethod, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object response = param.getResult();
                        if (response == null){
                            return;
                        }
                        Object rawResponse = XposedHelpers.getObjectField(response, "a");
                        if (rawResponse == null){
                            LogUtils.i("rawResponse is null");
                            return;
                        }
                        String requestUlr = (String) XposedHelpers.getObjectField(rawResponse, "a");
                        if (! RegexUtils.urlUnMatchFiler(requestUlr)){
                            return;
                        }
                        StringBuilder builder = new StringBuilder();
                        builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
                        builder.append(TiktokConfig.GetResponseMethod).append(" afterHookedMethod:").append("\n");
                        builder.append("response object Info:").append(response.getClass().getName()).append("\n");
                        builder.append("Request Url:\n").append(requestUlr).append("\n");
                        builder.append("StatusCode: ").append(XposedHelpers.getIntField(rawResponse, "b")).append("\n");
                        builder.append("reason: ").append(XposedHelpers.getObjectField(rawResponse, "c")).append("\n");
                        List<?> headers = (List<?>) XposedHelpers.callMethod(response, "b");
                        if (headers != null || !headers.isEmpty()){
                            builder.append("Headers:\n");
                            for (Object bb : headers){
                                builder.append("\t").append(bb.toString()).append("\n");
                            }
                        }
                        Object rawTypedInput = XposedHelpers.getObjectField(rawResponse, "e");
                        if (rawTypedInput != null){
                            String mimeType = (String) XposedHelpers.callMethod(rawTypedInput, "mimeType");
                            builder.append("rawResponse TypedInput mimeType:").append(mimeType).append("\n");
//                            InputStream inputStream = (InputStream) XposedHelpers.callMethod(rawTypedInput, "in");
//                            if (inputStream != null){
//                                StringBuilder sb = new StringBuilder();
//                                String line;
//                                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                                while ((line = reader.readLine()) != null){
//                                    sb.append(line);
//                                }
//                                builder.append("rawResponse TypedInput InputStream to String:").append("\n");
//                                builder.append(sb.toString()).append("\n");
//                            }
                            Field bytesField = XposedHelpers.findFieldIfExists(rawTypedInput.getClass(), "bytes");
                            if (bytesField != null){
                                byte[] bytes = (byte[]) XposedHelpers.callMethod(rawTypedInput, "getBytes");
                                builder.append("rawResponse TypedInput bytes to String:").append("\n");
                                builder.append(new String(bytes, StandardCharsets.UTF_8).substring(0, 200)).append("\n");
                            }
                            String fakeFileName = (String) XposedHelpers.callMethod(rawTypedInput, "fileName");
                            builder.append("rawResponse TypedInput fakeFileName:").append(mimeType).append("\n");
                        }
                        builder.append("rawResponse Object f:").append(XposedHelpers.getObjectField(rawResponse, "f")).append("\n");
                        Object body = XposedHelpers.getObjectField(response, "c");
                        if (body != null){
                            builder.append("Response body:\n").append(body).append("\n");
                        }else {
                            builder.append("Response body(c) is null").append("\n");
                        }
                        Object T = XposedHelpers.getObjectField(response, "b");
                        if (T != null){
                            builder.append("Response T:\n").append(T.getClass().getName()).append(": ").append(T.toString()).append("\n");
                        }
                        Object qObj = XposedHelpers.getObjectField(response, "d");
                        if (qObj != null){
                            builder.append("Response q:\n").append(qObj).append("\n");
                            builder.append("Response q.a:\n").append(XposedHelpers.callMethod(qObj, "a")).append("\n");
                            Object jsonObjectE = XposedHelpers.callMethod(qObj, "e");
                            builder.append("jsonObject e").append(jsonObjectE.toString()).append("\n");
                        }
                        builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
                        LogUtils.i(builder.toString());
                    }
                });
            }catch (Exception e){
                LogUtils.e(e);
            }
        }
    }
}
