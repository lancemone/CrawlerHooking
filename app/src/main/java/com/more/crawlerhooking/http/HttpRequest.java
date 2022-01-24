package com.more.crawlerhooking.http;

import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.BuildConfig;
import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.http.beans.CrawlerReportDataBean;
import com.more.crawlerhooking.http.beans.tiktok.ResponseBean;
import com.more.crawlerhooking.http.okhttp.OkHttpException;
import com.more.crawlerhooking.http.okhttp.RequestMode;
import com.more.crawlerhooking.http.okhttp.ResponseCallback;
import com.more.crawlerhooking.utils.LogUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpRequest {

    public static void CrawlerReportRecord(CrawlerReportDataBean reportBean){
        String jsonString = new GsonBuilder().serializeNulls().create().toJson(reportBean);
        CrawlerReportRecord(jsonString);
    }

    public static void CrawlerReportRecord(String jsonBody){
        String url = Constants.CrawlerReportHost + Constants.ApiReportRecords;
//        Logger.i("url: " + url);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("version", BuildConfig.VERSION_NAME);
        RequestMode.postRequestWithJson(url, jsonBody, headers, new ResponseCallback() {
            @Override
            public void onSuccess(Object response) {

                if (response != null){
                    ResponseBean responseBean = (ResponseBean) response;
                    if (responseBean.getCode() == 10000){
                        Logger.i("CrawlerReportRecord onSuccess");
                    }else {
                        Logger.e("CrawlerReportRecord fail: " + responseBean.getMsg() + " : error: " + responseBean.getError());
                    }
                }
            }

            @Override
            public void onFailure(OkHttpException fail) {
                Logger.e(fail.getMsg());
            }
        }, ResponseBean.class);
    }

    public static void AwemeFeedResponseProtobufReport(byte[] bytes){
        String url = Constants.CrawlerReportHost + "/api/v1/aweme/feed";
        RequestBody requestBody = RequestBody.create(bytes, MediaType.parse("application/x-protobuf"));
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("version", BuildConfig.VERSION_NAME);
        RequestMode.postRequest(url, requestBody, headers, new ResponseCallback() {
            @Override
            public void onSuccess(Object response) {
                Logger.i("AwemeFeedResponseProtobufReport: " + response.toString());
            }

            @Override
            public void onFailure(OkHttpException fail) {
            }
        }, null);
    }
}
