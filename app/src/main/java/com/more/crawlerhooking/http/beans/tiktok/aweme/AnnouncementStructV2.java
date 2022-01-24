package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "title": "",
 *     "body": ""
 * }
 */
public class AnnouncementStructV2 {

    /**
     * title
     */
    @SerializedName("title")
    private String title;
    /**
     * body
     */
    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
