package com.more.crawlerhooking.hooking.common.okhttp;

import com.more.crawlerhooking.conf.okhttp.OKHttpConfig;
import com.more.crawlerhooking.utils.LogUtils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class OkHttpClientHook {

    private final OKHttpConfig okHttpConfig;

    private String realCallClassName = "";

    private RealCallHook realCallHook;

    private final String pattern = "(http|https)://(alitup.bangcdn.net)(.*[^.webp|.jgp])";

    public OkHttpClientHook(XC_LoadPackage.LoadPackageParam loadPackageParam, OKHttpConfig okHttpConfig){
        this.okHttpConfig = okHttpConfig;
        hookingClient(loadPackageParam);
    }

    private void hookingClient(XC_LoadPackage.LoadPackageParam loadPackageParam){
        LogUtils.d("Cls_OkHttpClient: " + this.okHttpConfig.getCls_OkHttpClient());
        Class<?> OkHttpClientWapper = XposedHelpers.findClassIfExists(this.okHttpConfig.getCls_OkHttpClient(), loadPackageParam.classLoader);
        if (OkHttpClientWapper != null){
            LogUtils.d("M_Client_newCall: " + this.okHttpConfig.getM_Client_newCall());
            LogUtils.d("Cls_Request: " + this.okHttpConfig.getCls_Request());
            XposedHelpers.findAndHookMethod(OkHttpClientWapper, this.okHttpConfig.getM_Client_newCall(),
                    this.okHttpConfig.getCls_Request(), new XC_MethodHook() {

//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            final Object request = param.args[0];
//                            final Object httpUrl = XposedHelpers.getObjectField(request, okHttpConfig.getF_req_url());
//                            String url = (String) XposedHelpers.callMethod(httpUrl, "toString");
//                            LogUtils.i("hooking url: " + url);
//                            urlMatch = Pattern.matches(pattern, url);
//                            super.beforeHookedMethod(param);
//                        }

                        @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            final Object call = param.getResult();
                            String callClassName = call.getClass().getName();
                            if (!callClassName.equals(realCallClassName)){
                                LogUtils.i("RealCall Class Name: " + callClassName);
                                realCallClassName = callClassName;
                                Class<?> callClass = XposedHelpers.findClassIfExists(callClassName, loadPackageParam.classLoader);
                                if (callClass != null){
                                    LogUtils.i("Find Class CallClass Package: " + callClass.getPackage().getName());
                                    LogUtils.i(" ...........  hookRealCall  : " + callClassName);
                                    if (realCallHook == null){
                                        LogUtils.d("realCallHook is null");
                                        new RealCallHook(okHttpConfig, callClass);
                                    }
                                }else {
                                    LogUtils.w("not find class RealCall");
                                }
                            }
                            super.afterHookedMethod(param);
                        }
            });
        }else {
            LogUtils.w("not find class OkHttpClient!");
        }
    }
}
