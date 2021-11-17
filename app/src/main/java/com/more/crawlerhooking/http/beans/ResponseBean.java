package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;

import okhttp3.Response;

public class ResponseBean {

    /**
     * code
     */
    @SerializedName("code")
    private Integer code;
    /**
     * msg
     */
    @SerializedName("msg")
    private String msg;
    /**
     * error
     */
    @SerializedName("error")
    private String error;

    public ResponseBean(){}

    public ResponseBean(Integer code, String msg){
        new ResponseBean(code, msg, null);
    }

    public ResponseBean(Integer code, String msg, String error){
        this.code = code;
        this.msg = msg;
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
