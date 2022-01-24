package com.more.crawlerhooking;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import com.more.crawlerhooking.conf.GeneralConfig;
import com.more.crawlerhooking.conf.tiktok.TrillConfig;
import com.more.crawlerhooking.hooking.phoenix.PhoenixHook;
import com.more.crawlerhooking.hooking.tiktok.trill.HookTrillSsHttpCall;
import com.more.crawlerhooking.utils.LogUtils;

import java.io.File;
import java.util.Objects;


public class Main implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    private static XSharedPreferences prefs;
    private Context context;

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
//                prefs.makeWorldReadable();
                XposedBridge.log("prefs files: " + prefs.getFile().getAbsolutePath());
            }
        }catch (NullPointerException nullPointerException){
            prefs = loadPrefs();
        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (prefs == null){
            XposedBridge.log("prefs is null");
            return;
        }else {
            prefs.reload();
        }
        try {
            XposedBridge.log("handleLoadPackage package: " + lpparam.packageName);
//            if (lpparam.packageName.equals(BuildConfig.APPLICATION_ID)){
//                getApplicationContext();
//                LogUtils.d(lpparam.packageName + " context: " + context);
//            }
            if (lpparam.packageName.equals(TrillConfig.packageName)) {
//                new PhoneInfo(lpparam, serial);
                LogUtils.i("hooking Tiktok");
                HookTrillSsHttpCall ssHttpCall = new HookTrillSsHttpCall(lpparam, prefs);
                ssHttpCall.getContext();
                ssHttpCall.hookAddCustomParams();
                ssHttpCall.getResponseWithInterceptorChain();
//                HookDeviceRegister deviceRegister = new HookDeviceRegister(lpparam);
//                deviceRegister.hookSendEncryptLog();
            }
//            if (lpparam.packageName.equals("com.zhiliaoapp.musically")){
//                String serial = prefs.getString(Common.SerialNoKey, null);
//                String taskTurn = prefs.getString(Common.TaskTurnKey, null);
//                LogUtils.i("serial: " + serial);
//                new PhoneInfo(lpparam, serial);
//                LogUtils.i("hooking Tiktok");
////                new FeedVideo(lpparam, serial, taskTurn);
//                new HookTiktokSsHttpCall(lpparam, serial, taskTurn);
//            }
            if (lpparam.packageName.equals(GeneralConfig.PN_Phoenix_Browser)){
                String serial = prefs.getString(Constants.SerialNoKey, null);
                new PhoenixHook(lpparam, prefs);
            }
        }catch (XposedHelpers.InvocationTargetError error) {
            LogUtils.w(error.toString());
        }
    }

    private void getApplicationContext(){
        try {
            XposedHelpers.findAndHookMethod(Application.class, "onCreate",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            Application application = (Application) param.thisObject;
                            LogUtils.d("Application: " + application.toString());
                            context = application.getApplicationContext();
                            LogUtils.d("ApplicationContext: " + context);
                        }
                    });
        }catch (Exception e){
            LogUtils.e(e);
        }
    }

    public static XSharedPreferences getModulePrefs() {
        XSharedPreferences pref = new XSharedPreferences(BuildConfig.APPLICATION_ID);
        pref.makeWorldReadable();
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