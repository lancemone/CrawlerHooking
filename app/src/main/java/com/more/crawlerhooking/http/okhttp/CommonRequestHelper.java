package com.more.crawlerhooking.http.okhttp;

import java.util.Map;

import okhttp3.FormBody;
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
    public static Request createPostRequest(String url, RequestParams params) {
        FormBody.Builder mFromBodyBuilder = new FormBody.Builder();

        //将请求参数逐一遍历添加到我们的请求构建类中
        for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
            mFromBodyBuilder.add(entry.getKey(), entry.getValue());
        }

        //通过请求构建类的build方法获取到真正的请求体对象
        FormBody mFormBody = mFromBodyBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(mFormBody)
                .build();

        return request;
    }

    public static Request createPostRequestWithJson(String url, String jsonBody){
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return request;
    }
}
