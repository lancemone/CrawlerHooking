package com.more.crawlerhooking.http.okhttp;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CommonJsonCallback implements Callback {

    private ResponseCallback mListener;
    private Class<?> mClass;

    public CommonJsonCallback(ResposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
//        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
    }

    /**
     * 请求成功的处理
     * 回调在主线程
     */
    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        mListener.onSuccess(response);
    }
}
