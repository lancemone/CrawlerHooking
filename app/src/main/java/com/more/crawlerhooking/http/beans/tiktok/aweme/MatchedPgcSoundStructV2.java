package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

public class MatchedPgcSoundStructV2 {
    /**
     * author
     */
    @SerializedName("author")
    private String author;
    /**
     * mixedAuthor
     */
    @SerializedName("mixed_author")
    private String mixedAuthor;
    /**
     * mixedTitle
     */
    @SerializedName("mixed_title")
    private String mixedTitle;
    /**
     * title
     */
    @SerializedName("title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMixedAuthor() {
        return mixedAuthor;
    }

    public void setMixedAuthor(String mixedAuthor) {
        this.mixedAuthor = mixedAuthor;
    }

    public String getMixedTitle() {
        return mixedTitle;
    }

    public void setMixedTitle(String mixedTitle) {
        this.mixedTitle = mixedTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
