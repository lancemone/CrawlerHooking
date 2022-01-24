package com.more.crawlerhooking.hooking.tiktok.musically;

import com.more.crawlerhooking.utils.LogUtils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookCustomParams {

    private final XC_LoadPackage.LoadPackageParam loadPackageParam;

    public HookCustomParams(XC_LoadPackage.LoadPackageParam loadPackageParam, String serial){
        this.loadPackageParam = loadPackageParam;
    }

    private void hookAddCustomParams(){
        Class<?> NetUtilClass = XposedHelpers.findClass("com.ss.android.common.applog.NetUtil", loadPackageParam.classLoader);
        XposedHelpers.findAndHookMethod(NetUtilClass, "addCustomParams", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                LogUtils.d(param.args[0] + "： " + param.args[1]);
                String key = (String) param.args[0];
//                if (key.equals("mcc_mnc")){
//                    param.args[1] = "";
//                }
            }
        });
    }
}
