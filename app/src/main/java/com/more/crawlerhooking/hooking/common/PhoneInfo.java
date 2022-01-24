package com.more.crawlerhooking.hooking.common;


import com.more.crawlerhooking.conf.HookingConfig;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.utils.LogUtils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class PhoneInfo {

    private final String serial;

    public PhoneInfo(XC_LoadPackage.LoadPackageParam loadPackageParam, String serial){
        this.serial = serial;
        Telephony(loadPackageParam);
    }

    public void Telephony(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        LogUtils.i("device serial number: " + this.serial);
        String region = null;
        String operatorCode = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            region = TiktokConfig.SerialToRegion.getOrDefault(serial, "NG");
            operatorCode = TiktokConfig.RegionToCarrierCode.getOrDefault(region, "62120");
        }
        HookingTelephone(HookingConfig.TelephonyManagerClass, loadPackageParam, HookingConfig.NetworkOperatorMethod, operatorCode);
        HookingTelephone(HookingConfig.TelephonyManagerClass, loadPackageParam, HookingConfig.NetworkCountryIsoMethod, region);
    }

    public void changeWifiIp(){

    }

    private void HookingTelephone(String hookClass, XC_LoadPackage.LoadPackageParam loadPkgParam,
                                  String funcName, final String value) {
        LogUtils.i("HookingTelephone: " + funcName + "->" + value);
        try {
            XposedHelpers.findAndHookMethod(hookClass,
                    loadPkgParam.classLoader, funcName, new XC_MethodHook() {

                        @Override
                        protected void afterHookedMethod(MethodHookParam param)
                                throws Throwable {
                            // TODO Auto-generated method stub
                            super.afterHookedMethod(param);
                            LogUtils.d("HookingTelephone result: " + funcName + "->" + value);
                            param.setResult(value);
                        }

                    });
        } catch (Exception e) {
            LogUtils.e(e);
            e.printStackTrace();
        }
    }
}
