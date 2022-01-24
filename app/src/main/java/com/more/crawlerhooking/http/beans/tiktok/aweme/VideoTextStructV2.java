package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "text": "",
 *     "color": "",
 *     "color_text": "",
 *     "type": 1
 * }
 */
public class VideoTextStructV2 {

    /**
     * text
     */
    @SerializedName("text")
    private String text;
    /**
     * color
     */
    @SerializedName("color")
    private String color;
    /**
     * colorText
     */
    @SerializedName("color_text")
    private String colorText;
    /**
     * type
     */
    @SerializedName("type")
    private Integer type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
