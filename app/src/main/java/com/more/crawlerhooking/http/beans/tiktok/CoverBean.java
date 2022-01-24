package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoverBean {
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
    /**
     * width
     */
    @SerializedName("width")
    private Integer width;
    /**
     * height
     */
    @SerializedName("height")
    private Integer height;

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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
