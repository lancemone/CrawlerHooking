package com.more.crawlerhooking.http.okhttp;

public class OkHttpException extends Exception{

    private static final long serialVersionUID = 1L;

    private int code; //错误码
    private String msg; //错误消息

    public OkHttpException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
