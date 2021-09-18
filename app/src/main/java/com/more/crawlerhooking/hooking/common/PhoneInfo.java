package com.more.crawlerhooking.hooking.common;


import android.os.Build;
import android.util.Log;

import com.more.crawlerhooking.conf.HookingConfig;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.utils.PropertiesUtils;
import com.more.crawlerhooking.utils.SystemUtils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class PhoneInfo {

    private static final String TAG = "PhoneInfo";

    public PhoneInfo(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Telephony(loadPackageParam);
    }

    public void Telephony(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String serial = SystemUtils.getDeviceSerial(loadPackageParam);
        Log.i(TAG, "device serial number: " + serial);
        String region = null;
        String operatorCode = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            region = TiktokConfig.SerialToRegion.getOrDefault(serial, "NG");
            operatorCode = TiktokConfig.RegionToCarrierCode.getOrDefault(region, "62120");
        }
        HookingTelephone(HookingConfig.TelephonyManagerClass, loadPackageParam, HookingConfig.NetworkOperatorMethod, operatorCode);
        HookingTelephone(HookingConfig.TelephonyManagerClass, loadPackageParam, HookingConfig.NetworkCountryIsoMethod, region);
    }

    private void HookingTelephone(String hookClass, XC_LoadPackage.LoadPackageParam loadPkgParam,
                                  String funcName, final String value) {
        try {
            XposedHelpers.findAndHookMethod(hookClass,
                    loadPkgParam.classLoader, funcName, new XC_MethodHook() {

                        @Override
                        protected void afterHookedMethod(MethodHookParam param)
                                throws Throwable {
                            // TODO Auto-generated method stub
                            super.afterHookedMethod(param);
                            param.setResult(value);
                        }

                    });
        } catch (Exception e) {
            XposedBridge.log(e);
            e.printStackTrace();
        }
    }
}
