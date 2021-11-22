package com.more.crawlerhooking.http;

import com.more.crawlerhooking.BuildConfig;
import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.http.beans.AwemeReportBean;
import com.more.crawlerhooking.http.beans.BaseReportBean;
import com.more.crawlerhooking.http.beans.ResponseBean;
import com.more.crawlerhooking.http.okhttp.OkHttpException;
import com.more.crawlerhooking.http.okhttp.RequestMode;
import com.more.crawlerhooking.http.okhttp.ResponseCallback;
import com.more.crawlerhooking.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequest {

    public static void CrawlerReportRecord(Object reportBean){
        if (!(reportBean instanceof BaseReportBean)){
            return;
        }
        String url = Common.CrawlerReportHost + Common.ApiReportRecords;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("version", BuildConfig.VERSION_NAME);
        RequestMode.postRequestWithJson(url, reportBean, headers, new ResponseCallback() {
            @Override
            public void onSuccess(Object response) {

                if (response != null){
                    ResponseBean responseBean = (ResponseBean) response;
                    if (responseBean.getCode() == 10000){
                        LogUtils.i("CrawlerReportRecord onSuccess");
                    }else {
                        LogUtils.i("CrawlerReportRecord fail: " + responseBean.getMsg() + " : error: " + responseBean.getError());
                    }
                }
            }

            @Override
            public void onFailure(OkHttpException fail) {
                LogUtils.e(fail);
            }
        }, ResponseBean.class);
    }

    public static void AwemeFeedResponseProtobufReport(byte[] bytes){
        String url = Common.CrawlerReportHost + "/api/v1/aweme/feed";
        RequestBody requestBody = RequestBody.create(bytes, MediaType.parse("application/x-protobuf"));
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("version", BuildConfig.VERSION_NAME);
        RequestMode.postRequest(url, requestBody, headers, new ResponseCallback() {
            @Override
            public void onSuccess(Object response) {
                LogUtils.i("AwemeFeedResponseProtobufReport: " + response.toString());
            }

            @Override
            public void onFailure(OkHttpException fail) {
            }
        }, null);
    }
}
