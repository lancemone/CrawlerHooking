package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;

public abstract class BaseReportBean {
    /**
     * source
     */
    @SerializedName("source")
    protected String source;

    public BaseReportBean(){}

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
