package com.more.crawlerhooking.http.okhttp;

import androidx.annotation.NonNull;

import com.more.crawlerhooking.utils.LogUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ParamsInterceptor implements Interceptor {

    public ParamsInterceptor() {
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        LogUtils.d("ParamsInterceptor add Headers");
        Request request = chain.request().newBuilder()
                .addHeader("Connection", "close")
                .build();
        return chain.proceed(request);
    }
}
