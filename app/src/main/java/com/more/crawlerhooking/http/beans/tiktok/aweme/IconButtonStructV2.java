package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "text": "",
 *     "icon": {},
 *     "action": ""
 * }
 */
public class IconButtonStructV2 {

    /**
     * text
     */
    @SerializedName("text")
    private String text;
    /**
     * icon
     */
    @SerializedName("icon")
    private UrlStructV2 icon;
    /**
     * action
     */
    @SerializedName("action")
    private String action;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UrlStructV2 getIcon() {
        return icon;
    }

    public void setIcon(UrlStructV2 icon) {
        this.icon = icon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
