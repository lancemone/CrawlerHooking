package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "background_color": "",
 *     "text": "",
 *     "text_color": "",
 *     "image": {},
 *     "ref_url": ""
 * }
 */
public class HybridLabelStructV2 {

    /**
     * backgroundColor
     */
    @SerializedName("background_color")
    private String backgroundColor;
    /**
     * text
     */
    @SerializedName("text")
    private String text;
    /**
     * textColor
     */
    @SerializedName("text_color")
    private String textColor;
    /**
     * image
     */
    @SerializedName("image")
    private UrlStructV2 image;
    /**
     * refUrl
     */
    @SerializedName("ref_url")
    private String refUrl;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public UrlStructV2 getImage() {
        return image;
    }

    public void setImage(UrlStructV2 image) {
        this.image = image;
    }

    public String getRefUrl() {
        return refUrl;
    }

    public void setRefUrl(String refUrl) {
        this.refUrl = refUrl;
    }
}
