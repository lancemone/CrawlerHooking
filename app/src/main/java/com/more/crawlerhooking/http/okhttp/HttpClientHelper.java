package com.more.crawlerhooking.http.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpClientHelper {

    private static final int TIME_OUT = 60;

    private static final OkHttpClient mOkHttpClient;

    /**
     * 为我们的Client配置参数，使用静态语句块来配置
     * 只执行一次，运行一开始就开辟了内存，内存放在全局
     */
    static {
        //创建Client对象的构建者
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new RequestLogInterceptor())
                .addNetworkInterceptor(new ParamsInterceptor())
                .followRedirects(true);
        mOkHttpClient = builder.build();
    }

    /**
     * 异步发送具体的HTTP以及Https请求
     */
    public static Call requestAsyn(Request request, CommonJsonCallback jsonCallback){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(jsonCallback);
        return call;
    }

    /**
     * GET请求
     */
    public static Call get(Request request, ResposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    /**
     * POST请求
     */
    public static Call post(Request request, ResposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }
}
