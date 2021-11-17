package com.more.crawlerhooking.http.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

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
    public static void postRequest(String url, RequestParams params, Map<String, String> headers,
                                   ResponseCallback callback, Class<?> clazz) {
        HttpClientHelper.post(CommonRequestHelper.createPostRequest(url, params, headers),
                new ResposeDataHandle(callback, clazz));
    }

    public static void postRequestWithJson(String url, Object obj, Map<String, String> headers, ResponseCallback responseCallback, Class<?> result){
        String json = new GsonBuilder().create().toJson(obj);
        postRequestWithJson(url, json, headers, responseCallback, result);
    }

    public static void postRequestWithJson(String url, String jsonBody, Map<String, String> headers, ResponseCallback responseCallback,  Class<?> result){
        HttpClientHelper.post(CommonRequestHelper.createPostRequestWithJson(url, jsonBody, headers), new ResposeDataHandle(responseCallback, result));
    }
}
