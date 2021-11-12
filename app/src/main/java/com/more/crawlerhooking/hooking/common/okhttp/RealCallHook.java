package com.more.crawlerhooking.hooking.common.okhttp;

import android.util.Log;

import com.more.crawlerhooking.Main;
import com.more.crawlerhooking.conf.OKHttpConfig;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class RealCallHook {
    private final OKHttpConfig okHttpConfig;
    private final Class<?> realCallClass;
    private XC_LoadPackage.LoadPackageParam loadPackageParam;
    private final String pattern = "(http|https)://(alitup.bangcdn.net)(.*[^.webp|.jgp])";

//    public RealCallHook(XC_LoadPackage.LoadPackageParam loadPackageParam, OKHttpConfig okHttpConfig, String realCallClassName){
//        this.loadPackageParam = loadPackageParam;
//        this.okHttpConfig = okHttpConfig;
//        this.realCallClass = XposedHelpers.findClassIfExists(realCallClassName, loadPackageParam.classLoader);
//    }

    public RealCallHook(OKHttpConfig okHttpConfig, Class<?> realCallClass){
        LogUtils.d("RealCallHook Class New");
        this.okHttpConfig = okHttpConfig;
        this.realCallClass = realCallClass;
        hookingEnqueue();
        hookingExecute();
    }

    private void hookingEnqueue(){
        XposedHelpers.findAndHookMethod(realCallClass, okHttpConfig.getM_Call_enqueue(), okHttpConfig.getCls_CallBack(),
                new XC_MethodHook() {

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        LogUtils.i("success hooking Call Enqueue");
                          Object realCallBack = param.args[0];
                        if (realCallBack != null){
                            String realCallBackName = realCallBack.getClass().getName();
                            LogUtils.i("enqueue request callback is " + realCallBackName);
                        }else {
                            LogUtils.i("enqueue request callback is null");
                        }
                        super.afterHookedMethod(param);
                    }
                });
    }

    // 同步请求
    private void hookingExecute(){
        XposedHelpers.findAndHookMethod(realCallClass, okHttpConfig.getM_Call_execute(), new XC_MethodHook() {

            boolean isMatch = false;

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                LogUtils.i("success hooking Call Execute");
                Object request = XposedHelpers.callMethod(param.thisObject, okHttpConfig.getM_Call_request());
                String url = findUrlFromRequest(request);
                LogUtils.i("execute request url: " + url);
                isMatch = Pattern.matches(pattern, url);
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (isMatch){
                    Object response = param.getResult();
                    dealWithResponse(response);
                }else {
                    LogUtils.i("Url Not Match Hooking Reg");
                }
                super.afterHookedMethod(param);
            }
        });
    }

//    private Object buildNewResponse(Object response){
//
//    }

    private void dealWithResponse(Object responseObject){
        Map<String, Object> responseInfo = new HashMap<String, Object>();
        Object request = findRequestObjectFromResponse(responseObject);
        if (request != null){
            responseInfo.put("URL", findUrlFromRequest(request));
            responseInfo.put("Method", findHttpMethodFromRequest(request));
            Object headers = findRequestHeadersObject(request);
            if (headers != null){
                responseInfo.put("Request Headers", headers.toString());
            }else {
                responseInfo.put("Request Headers", "");
            }
            String requestContent = findRequestBodyContent(request);
            responseInfo.put("Request Body", requestContent);
        }else {
            LogUtils.w("Response not find request object");
        }
        if (!responseInfo.isEmpty()){
            LogUtils.json(responseInfo);
        }
    }

    private Object findRequestObjectFromResponse(Object responseObject){

        Object request = null;
        if (responseObject != null){
            request = XposedHelpers.getObjectField(responseObject, okHttpConfig.getF_rsp_request());
            LogUtils.d("findRequestObjectFromResponse: " + request.toString());
        }
        return request;
    }

    private String findHttpMethodFromRequest(Object requestObject){
        String method = "";
        if (requestObject != null){
            method = (String) XposedHelpers.getObjectField(requestObject, okHttpConfig.getF_req_method());
        }
        return method;
    }

    private String findUrlFromRequest(Object requestObject){
        String url = "";
        if (requestObject != null){
            url = XposedHelpers.getObjectField(requestObject, okHttpConfig.getF_req_url()).toString();
        }
        return url;
    }

    private Object findRequestHeadersObject(Object requestObject){
        Object headers = null;
        if (requestObject != null){
            headers = XposedHelpers.getObjectField(requestObject, okHttpConfig.getF_req_headers());
        }
        return headers;
    }

    private String getValueFromHeadersObject(Object headers, String key){
        String value = "";
        if (headers != null){
            value = (String) XposedHelpers.callMethod(headers, "get", java.lang.String.class, key);
        }
        return value;
    }

    private String findRequestBodyContent(Object requestObject){
        String requestContent = "";
        if (requestObject != null){
            Object requestBody = XposedHelpers.getObjectField(requestObject, okHttpConfig.getF_req_body());
            if (requestBody != null){
                if (!requestBody.getClass().getName().equals(okHttpConfig.getCls_RequestBody())){
                    return requestContent;
                }
                Object mediaType = XposedHelpers.callMethod(requestBody, okHttpConfig.getM_req_body_contentType());
                LogUtils.i("mediaType: " + mediaType.toString());
                long contentLength = (long) XposedHelpers.callMethod(requestBody, okHttpConfig.getM_req_body_contentLength());
                byte[] content = (byte[]) XposedHelpers.getObjectField(requestBody, "c");
                requestContent = StringUtils.byte2Base64String(content);
            }
        }
        return requestContent;
    }
}
