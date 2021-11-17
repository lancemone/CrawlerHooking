package com.more.crawlerhooking.http.okhttp;

import okhttp3.Response;

public interface ResponseCallback {

    //请求成功回调事件处理
    void onSuccess(Object response);

    //请求失败回调事件处理
    void onFailure(OkHttpException fail);
}
