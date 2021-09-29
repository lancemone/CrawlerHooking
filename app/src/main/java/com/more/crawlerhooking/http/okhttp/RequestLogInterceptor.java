package com.more.crawlerhooking.http.okhttp;

import androidx.annotation.NonNull;

import com.more.crawlerhooking.utils.LogUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class RequestLogInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        long startTime = System.currentTimeMillis();
        Response response=null;
        String responseBody = null;
        String responseCode = null;
        String url = null;
        String requestBody = null;
        try {
            Request request = chain.request();
            url = request.url().toString();
            requestBody = getRequestBody(request);
            response = chain.proceed(request);
            responseBody = Objects.requireNonNull(response.body()).string();
            responseCode = String.valueOf(response.code());
            MediaType mediaType = Objects.requireNonNull(response.body()).contentType();
            response = response.newBuilder().body(ResponseBody.create(responseBody, mediaType)).build();
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }
        finally {
            long end = System.currentTimeMillis();
            String duration = String.valueOf(end - startTime);
            LogUtils.i(String.format("responseTime= %s, requestUrl= %s, params=%s, responseCode= %s, result= %s",
                    duration, url,requestBody,responseCode,responseBody));
            }
        if (response != null) {
            return response;
        }
        return chain.proceed(chain.request());
    }

    private String getRequestBody(Request request) {
        String requestContent = "";
        if (request == null) {
            return requestContent;
        }
        RequestBody requestBody = request.body();
        if (requestBody == null) {
                return requestContent;
            }
        try {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                Charset charset = StandardCharsets.UTF_8;
                requestContent = buffer.readString(charset);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return requestContent;
    }
}
