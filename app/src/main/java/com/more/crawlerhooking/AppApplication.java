package com.more.crawlerhooking;

import android.app.Application;

import com.more.crawlerhooking.app.broadcast.CrawlerAppReceiver;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class AppApplication extends Application {

    public static final String TAG = "AppCrawler";
    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
        SPUtils.getInstance().init(this.getApplicationContext());
        CrawlerAppReceiver.registerReceiver(this);
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(1)
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        FormatStrategy csvFormatStrategy = CsvFormatStrategy.newBuilder()
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new DiskLogAdapter(csvFormatStrategy));
        Logger.d("initLogger successful");
    }
}
