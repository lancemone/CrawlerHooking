package com.more.crawlerhooking;

import android.util.Log;
import android.widget.TextView;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import com.more.crawlerhooking.conf.HookingConfig;
import com.more.crawlerhooking.hooking.common.PhoneInfo;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.hooking.tiktok.FeedVideo;


public class Main implements IXposedHookLoadPackage {
    private final String TAG = "CrawlerMain";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        try {
            new PhoneInfo(lpparam);
            if (lpparam.packageName.equals(TiktokConfig.TikTokPn)) {
                new FeedVideo(lpparam);
            }
        }catch (XposedHelpers.InvocationTargetError error) {
            Log.w(TAG, error.toString());
        }
    }
}