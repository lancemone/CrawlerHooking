package com.more.crawlerhooking.http.okhttp;

public class ResposeDataHandle {
    public ResponseCallback mListener = null;
    public Class<?> mClass = null;

    public ResposeDataHandle(ResponseCallback listener) {
        this.mListener = listener;
    }

    public ResposeDataHandle(ResponseCallback listener, Class<?> clazz) {
        this.mListener = listener;
        this.mClass = clazz;
    }
}
