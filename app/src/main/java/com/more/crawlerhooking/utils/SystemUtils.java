package com.more.crawlerhooking.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.os.Build;
import android.util.Log;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SystemUtils {

    private static final String TAG = "SystemUtils";

    public static String getDeviceSerial(XC_LoadPackage.LoadPackageParam loadPackageParam){
        final Class<?> build = XposedHelpers.findClass("android.os.Build", loadPackageParam.classLoader);
        String serial = null;
        try {
            serial = (String) XposedHelpers.callStaticMethod(build, "getSerial");
//            serial = (String) XposedHelpers.getStaticObjectField(build, "SERIAL");
        }catch (Exception e) {
//            XposedBridge.log(e);
            Log.w(TAG, e.getMessage());
        }
        return serial;
    }
}
