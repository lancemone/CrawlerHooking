package com.more.crawlerhooking.http.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RequestMode {

    /**
     * GET请求
     * @param url URL请求地址
     * @param params 入参
     * @param callback 回调接口
     * @param clazz 需要解析的实体类
     */
    public static void getRequest(String url, RequestParams params,
                                  ResponseCallback callback, Class<?> clazz) {
        HttpClientHelper.get(CommonRequestHelper.createGetRequest(url, params),
                new ResposeDataHandle(callback, clazz));
    }

    /**
     * POST请求
     * @param url URL请求地址
     * @param params 入参
     * @param callback 回调接口
     * @param clazz 需要解析的实体类
     */
    public static void postRequest(String url, RequestParams params,
                                   ResponseCallback callback, Class<?> clazz) {
        HttpClientHelper.post(CommonRequestHelper.createPostRequest(url, params),
                new ResposeDataHandle(callback, clazz));
    }

    public static void postRequestWithJson(String url, Object obj, ResponseCallback responseCallback, Class<?> result){
        String json = new GsonBuilder().serializeNulls().create().toJson(obj);
        postRequestWithJson(url, json, responseCallback, result);
    }

    public static void postRequestWithJson(String url, String jsonBody, ResponseCallback responseCallback,  Class<?> result){
        HttpClientHelper.post(CommonRequestHelper.createPostRequestWithJson(url, jsonBody), new ResposeDataHandle(responseCallback, result));
    }
}
