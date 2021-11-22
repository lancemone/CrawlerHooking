package com.more.crawlerhooking.http.okhttp;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class CommonRequestHelper {

    /**
     * 创建Get请求的Request
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");

        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }

        return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get().build();
    }

    /**
     * 创建Post请求的Request
     *
     * @return 返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url, RequestParams params, Map<String, String> headers) {
        FormBody.Builder mFromBodyBuilder = new FormBody.Builder();
        Headers.Builder mHeadersBuilder = new Headers.Builder();

        //将请求参数逐一遍历添加到我们的请求构建类中
        for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
            mFromBodyBuilder.add(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            mHeadersBuilder.add(entry.getKey(), entry.getValue());
        }

        //通过请求构建类的build方法获取到真正的请求体对象
        FormBody mFormBody = mFromBodyBuilder.build();
        Headers mHeaders = mHeadersBuilder.build();

        return new Request.Builder()
                .url(url)
                .headers(mHeaders)
                .post(mFormBody)
                .build();
    }

    public static Request createPostRequest(String url, RequestBody body, Map<String, String> headers){
        Headers.Builder mHeadersBuilder = new Headers.Builder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            mHeadersBuilder.add(entry.getKey(), entry.getValue());
        }
        Headers mHeaders = mHeadersBuilder.build();
        return new Request.Builder()
                .url(url)
                .headers(mHeaders)
                .post(body)
                .build();
    }

    public static Request createPostRequestWithJson(String url, String jsonBody, Map<String, String> headers){
        Headers.Builder mHeadersBuilder = new Headers.Builder();
        if (headers.isEmpty())
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            mHeadersBuilder.add(entry.getKey(), entry.getValue());
        }
        Headers mHeaders = mHeadersBuilder.build();
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json"));
        return new Request.Builder()
                .url(url)
                .headers(mHeaders)
                .post(requestBody).build();
    }
}
