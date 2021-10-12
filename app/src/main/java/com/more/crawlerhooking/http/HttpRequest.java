package com.more.crawlerhooking.http;

import android.os.Build;

import com.more.crawlerhooking.BuildConfig;
import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.http.beans.tiktok.AwemeReportBean;
import com.more.crawlerhooking.http.okhttp.OkHttpException;
import com.more.crawlerhooking.http.okhttp.RequestMode;
import com.more.crawlerhooking.http.okhttp.ResponseCallback;
import com.more.crawlerhooking.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    public static void CrawlerReportRecord(Object reportBean){
        if (!(reportBean instanceof AwemeReportBean)){
            return;
        }
        String url = Common.CrawlerReportHost + Common.ApiReportRecords;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("version", BuildConfig.VERSION_NAME);
        RequestMode.postRequestWithJson(url, reportBean, headers, new ResponseCallback() {
            @Override
            public void onSuccess(Object response) {
                LogUtils.i("CrawlerReportRecord onSuccess: ");
                LogUtils.i(response);
            }

            @Override
            public void onFailure(OkHttpException fail) {
                LogUtils.e(fail);
            }
        }, null);
    }
}
