package com.more.crawlerhooking.hooking;

import android.content.Context;
import android.content.Intent;

import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.http.beans.CrawlerReportDataBean;
import com.more.crawlerhooking.utils.LogUtils;

import java.util.Arrays;

public class XpBroadcast {

    public static void sendCrawlerReportData(Context context, CrawlerReportDataBean crawlerReportDataBean){
        if (context == null){
            LogUtils.w("sendCrawlerReportData Context param must not null");
            return;
        }
        if (crawlerReportDataBean == null){
            LogUtils.w("sendCrawlerReportData CrawlerReportDataBean param must not null");
            return;
        }
        LogUtils.d("sendCrawlerReportData Context param: " + context);
        Intent intent = new Intent(Constants.ACTION_REPORT);
        String reportData = new GsonBuilder().serializeNulls().create().toJson(crawlerReportDataBean);
        intent.putExtra(Constants.EXTRA_NAME_CRAWLER_DATA_REPORT, reportData);
        context.sendBroadcast(intent);
    }

    public static void sendErrorMsg(Context context, String ...msg){
        if (context == null){
            LogUtils.w("sendErrorMsg Context param must not null");
            return;
        }
        if (msg == null || msg.length == 0){
            return;
        }
        try {
            Intent intent = new Intent(Constants.ACTION_ERROR);
            String errorInfo = Arrays.toString(msg);
            intent.putExtra(Constants.EXTRA_NAME_ERROR_MESSAGE, errorInfo);
            context.sendBroadcast(intent);
        }catch (Exception e){
            LogUtils.e(e);
        }
    }
}
