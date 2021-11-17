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

import com.more.crawlerhooking.conf.GeneralConfig;
import com.more.crawlerhooking.conf.PhoenixOKHttpConfig;
import com.more.crawlerhooking.hooking.common.PhoneInfo;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.hooking.common.okhttp.OkHttpClientHook;
import com.more.crawlerhooking.hooking.phoenix.PhoenixHook;
import com.more.crawlerhooking.hooking.tiktok.FeedVideo;
import com.more.crawlerhooking.hooking.tiktok.HookTiktokSsHttpCall;
import com.more.crawlerhooking.utils.LogUtils;

import java.io.File;
import java.util.Objects;


public class Main implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    private static XSharedPreferences prefs;

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        try {
            if (prefs == null){
                if (XposedBridge.getXposedVersion() < 93){
                    XposedBridge.log("getLegacyModulePrefs");
                    prefs = getLegacyModulePrefs();
                }else {
                    XposedBridge.log("getModulePrefs");
                    prefs = getModulePrefs();
                }
                prefs.makeWorldReadable();
                LogUtils.i("prefs files: " + prefs.getFile().getAbsolutePath());
            }
        }catch (NullPointerException nullPointerException){
            prefs = loadPrefs();
        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (prefs == null){
            LogUtils.i("prefs is null");
            return;
        }else {
            prefs.reload();
        }
        try {
            LogUtils.i("handleLoadPackage package: " + lpparam.packageName);
            if (lpparam.packageName.equals(TiktokConfig.TikTokPn)) {
                String serial = prefs.getString(Common.SerialNoKey, null);
                String taskTurn = prefs.getString(Common.TaskTurnKey, null);
                LogUtils.i("serial: " + serial);
                new PhoneInfo(lpparam, serial);
                LogUtils.i("hooking Tiktok");
//                new FeedVideo(lpparam, serial, taskTurn);
                new HookTiktokSsHttpCall(lpparam, serial, taskTurn);
            }
            if (lpparam.packageName.equals(GeneralConfig.PN_Phoenix_Browser)){
                String serial = prefs.getString(Common.SerialNoKey, null);
                new PhoenixHook(lpparam, prefs);
            }
        }catch (XposedHelpers.InvocationTargetError error) {
            LogUtils.w(error.toString());
        }
    }

    public static XSharedPreferences getModulePrefs() {
        XSharedPreferences pref = new XSharedPreferences(BuildConfig.APPLICATION_ID);
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

    private XSharedPreferences loadPrefs(){
        XSharedPreferences sPrefs = new XSharedPreferences(Objects.requireNonNull(Main.class.getPackage()).getName());
        sPrefs.makeWorldReadable();
        return sPrefs;
    }
}