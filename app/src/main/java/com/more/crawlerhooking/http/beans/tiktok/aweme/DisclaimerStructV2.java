package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "title": "",
 *     "content": ""
 * }
 */
public class DisclaimerStructV2 {

    /**
     * title
     */
    @SerializedName("title")
    private String title;
    /**
     * content
     */
    @SerializedName("content")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
