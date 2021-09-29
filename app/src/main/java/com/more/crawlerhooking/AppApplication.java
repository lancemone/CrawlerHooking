package com.more.crawlerhooking;

import android.app.Application;
import android.util.Log;

import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class AppApplication  extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i("start application");
        instance = this;
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(5)
                .tag("CrawlerHooking")
                .build();
        LogUtils.i("Application init Logger sucessed");
        SPUtils.getInstance().init(this.getApplicationContext());
    }

    public static Application getInstance() {
        return instance;
    }
}
