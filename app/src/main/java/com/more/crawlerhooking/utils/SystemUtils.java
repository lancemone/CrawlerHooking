package com.more.crawlerhooking.utils;

import android.app.AndroidAppHelper;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.interfaces.SystemUtilsInterface;
import com.orhanobut.logger.Logger;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SystemUtils {

    private static final String TAG = "SystemUtils";
//    private Context applicationContext;
//    private ContentResolver contentResolver;
    private XC_LoadPackage.LoadPackageParam loadPackageParam;
    public SystemUtils(XC_LoadPackage.LoadPackageParam loadPackageParam){
        this.loadPackageParam = loadPackageParam;
    }


    public void getApplicationContext(SystemUtilsInterface systemUtilsInterface) {
        try {
            Class<?> ContextClass = XposedHelpers.findClass("android.content.ContextWrapper", loadPackageParam.classLoader);
            XposedHelpers.findAndHookMethod(ContextClass, "getApplicationContext", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    XposedBridge.log("param.thisObject: " + param.thisObject.toString());
                    XposedBridge.log("param.getResult: " + param.getResult());
                    Context applicationContext = (Context) param.getResult();
                    XposedBridge.log("applicationContext: " + applicationContext);
                    systemUtilsInterface.applicationContext(applicationContext);
                }
            });
        }catch (Throwable t){
            XposedBridge.log(t);
        }
    }

    public void getContentResolver(SystemUtilsInterface systemUtilsInterface) {
        try {
            Class<?> ContextClass = XposedHelpers.findClass("android.content.ContextWrapper", loadPackageParam.classLoader);
            XposedHelpers.findAndHookMethod(ContextClass, "getContentResolver", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    XposedBridge.log("getContentResolver param.getResult: " + param.getResult());
                    ContentResolver contentResolver = (ContentResolver) param.getResult();
                    systemUtilsInterface.contextResolver(contentResolver);
                    String androidId = Settings.System.getString(contentResolver, Settings.System.ANDROID_ID);
                    Log.i(TAG, "android id: " + androidId);
                    systemUtilsInterface.androidId(androidId);
                }
            });
        }catch (Throwable t){
            XposedBridge.log(t);
        }
    }

    public String androidId(XC_LoadPackage.LoadPackageParam loadPackageParam){
        String androidId = "";
        XposedBridge.log("android id: " + androidId);
        Logger.i("android id: " + androidId);
        return androidId;
    }

    public String getDeviceSerial(XC_LoadPackage.LoadPackageParam loadPackageParam){
        String androidId = androidId(loadPackageParam);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return TiktokConfig.AndroidIdToSerial.getOrDefault(androidId, null);
        }else {
            String serial = null;
            serial = TiktokConfig.AndroidIdToSerial.get(androidId);
            return serial;
        }
    }
}
