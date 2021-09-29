package com.more.crawlerhooking;

import android.os.Build;
import android.os.Environment;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import com.more.crawlerhooking.hooking.common.PhoneInfo;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.hooking.tiktok.FeedVideo;

import java.io.File;


public class Main implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    private final String TAG = "CrawlerMain";
    private static XSharedPreferences prefs;

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        if (prefs == null){
            if (XposedBridge.getXposedVersion() < 93){
                XposedBridge.log("getLegacyModulePrefs");
                prefs = getLegacyModulePrefs();
            }else {
                XposedBridge.log("getModulePrefs");
                prefs = getModulePrefs();
            }
            XposedBridge.log("prefs is makeWorldReadable: " + prefs.makeWorldReadable());
            XposedBridge.log("prefs files: " + prefs.getFile().getAbsolutePath());
        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (prefs == null){
            Log.i(TAG, "prefs is null");
            return;
        }else {
            prefs.reload();
        }
        try {
            Log.i(TAG, "handleLoadPackage package: " + lpparam.packageName);
            if (lpparam.packageName.equals(TiktokConfig.TikTokPn)) {
                String serial = prefs.getString(Common.SerialNoKey, null);
                Log.i(TAG, "serial: " + serial);
                new PhoneInfo(lpparam, serial);
                Log.i(TAG, "hooking Tiktok");
                new FeedVideo(lpparam, serial);
            }
        }catch (XposedHelpers.InvocationTargetError error) {
            Log.w(TAG, error.toString());
        }
    }

    public static XSharedPreferences getModulePrefs() {
        XSharedPreferences pref = new XSharedPreferences(BuildConfig.APPLICATION_ID);
        XposedBridge.log("getModulePrefs pref file path: " + pref.getFile().getAbsolutePath());
        XposedBridge.log("pref file canRead: " + pref.getFile().canRead());
        return pref.getFile().canRead() ? pref : null;
    }

    private XSharedPreferences getLegacyModulePrefs() {
        String dataDir = "data/";
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            dataDir = "user_de/0/";
        }
        File f = new File(Environment.getDataDirectory(), dataDir + BuildConfig.APPLICATION_ID + "/shared_prefs/" + BuildConfig.APPLICATION_ID + "_preferences.xml");
        return new XSharedPreferences(f);
    }
}