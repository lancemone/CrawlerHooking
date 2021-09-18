package com.more.crawlerhooking.hooking.tiktok;

import android.util.Log;

import com.more.crawlerhooking.conf.TiktokConfig;
import com.orhanobut.logger.Logger;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class FeedVideo {

    private final String TAG = "FeedVideo";

    public FeedVideo(XC_LoadPackage.LoadPackageParam loadPackageParam){
        AwemeHooking(loadPackageParam);
    }

    public void AwemeHooking(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        try {
            XposedHelpers.findAndHookMethod(TiktokConfig.AwemeClass, loadPackageParam.classLoader, TiktokConfig.GetRegionMethod, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    XposedBridge.log("before GetRegionMethod");
                    Log.i(TAG, "before GetRegionMethod");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    XposedBridge.log(String.format("param.thisObject: %s", param.thisObject.toString()));
                    XposedBridge.log(String.format("param.getResult(): %s", param.getResultOrThrowable().toString()));
                    Log.i(TAG, String.format("param.thisObject: %s", param.thisObject.toString()));
                    Log.i(TAG, String.format("param.getResult(): %s", param.getResultOrThrowable().toString()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAwemeInfo() {

    }

    private String getSerialFromDeviceId(XC_LoadPackage.LoadPackageParam loadPackageParam){
        String serial = "";
        try {
            final Class<?> deviceRegisterManager = XposedHelpers.findClass(TiktokConfig.DeviceRegisterManagerClass, loadPackageParam.classLoader);
            String deviceId = (String) XposedHelpers.callStaticMethod(deviceRegisterManager, TiktokConfig.GetDeviceIdMethod);
            if(deviceId != null) serial = TiktokConfig.DeviceIdToSerial.get(deviceId);
        }catch (Exception e) {
            Logger.e(e.toString());
        }
        return serial;
    }
}
