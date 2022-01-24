package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayAddrBean {
    /**
     * uri
     */
    @SerializedName("uri")
    private String uri;
    /**
     * urlList
     */
    @SerializedName("url_list")
    private List<String> urlList;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
