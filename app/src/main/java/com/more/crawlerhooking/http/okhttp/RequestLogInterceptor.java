package com.more.crawlerhooking.http.okhttp;

import androidx.annotation.NonNull;

import com.more.crawlerhooking.utils.LogUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class RequestLogInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        long startTime = System.currentTimeMillis();
        Request request = chain.request();
        Response response= chain.proceed(request);
        MediaType mediaType = null;
        String responseBody = null;
        String responseCode = null;
        String url = null;
        String requestBody = null;
        try {
            url = request.url().toString();
            requestBody = getRequestBody(request);
            responseBody = getResponseText(response);
            responseCode = String.valueOf(response.code());
            mediaType = Objects.requireNonNull(response.body()).contentType();
            response = response.newBuilder().body(ResponseBody.create(responseBody, mediaType)).build();
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }
        finally {
            long end = System.currentTimeMillis();
            String duration = String.valueOf(end - startTime);
            String logInfo = "http request info: ".concat("\n ")
                    .concat("Request Url-->：")
                    .concat(request.method())
                    .concat(" ")
                    .concat(url != null ? url : "")
                    .concat("\n ")
                    .concat("Request Header-->：")
                    .concat(getRequestHeaders(request))
                    .concat("\n ")
                    .concat("Request Parameters-->：")
                    .concat(requestBody != null ? requestBody : "")
                    .concat("\n ")
                    .concat("Response Time(ms)-->：")
                    .concat(duration)
                    .concat("\n ")
                    .concat("Response Code-->：")
                    .concat(responseCode != null ? responseCode : "")
                    .concat("\n ")
                    .concat("Response Result-->：")
                    .concat(responseBody != null ? responseBody : "");
            Logger.i(logInfo);
            }
        return response;
    }

    private String getResponseText(Response response){
        String responseText = "";
        try {
            ResponseBody body = response.body();
            if (body != null && body.contentLength() != 0){
                BufferedSource source = body.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer = source.buffer();
                MediaType mediaType = body.contentType();
                if (mediaType != null){
                    Charset charset = mediaType.charset(StandardCharsets.UTF_8);
                    if (charset != null){
                        responseText = buffer.clone().readString(charset);
                    }
                }
            }
        } catch (IOException e) {
            Logger.e(e, "get response text error", response.request().url().toString());
        }
        return responseText;
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
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null){
                    Charset charset = mediaType.charset(StandardCharsets.UTF_8);
                    if (charset != null){
                        requestContent = buffer.readString(charset);
                    }
            }
            } catch (IOException e) {
                Logger.e(e, "get request body error", request.url().toString());;
            }
        return requestContent;
    }

    private String getRequestHeaders(Request request){
        Headers headers = request.headers();
        if (headers.size() > 0){
            return headers.toString();
        }else {
            return "";
        }
    }
}
