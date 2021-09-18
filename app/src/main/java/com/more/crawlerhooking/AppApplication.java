package com.more.crawlerhooking;

import android.app.Application;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class AppApplication  extends Application {

    private final String TAG = "CrawlerApplication";
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "start application");
        instance = this;
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(5)
                .tag("CrawlerHooking")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static Application getInstance() {
        return instance;
    }
}
