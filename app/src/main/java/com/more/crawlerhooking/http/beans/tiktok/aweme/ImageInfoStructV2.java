package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "height": 1,
 *     "width": 2,
 *     "label_large": {},
 *     "label_thumb": {}
 * }
 */
public class ImageInfoStructV2 {

    /**
     * height
     */
    @SerializedName("height")
    private Integer height;
    /**
     * width
     */
    @SerializedName("width")
    private Integer width;
    /**
     * labelLarge
     */
    @SerializedName("label_large")
    private UrlStructV2 labelLarge;
    /**
     * labelThumb
     */
    @SerializedName("label_thumb")
    private UrlStructV2 labelThumb;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public UrlStructV2 getLabelLarge() {
        return labelLarge;
    }

    public void setLabelLarge(UrlStructV2 labelLarge) {
        this.labelLarge = labelLarge;
    }

    public UrlStructV2 getLabelThumb() {
        return labelThumb;
    }

    public void setLabelThumb(UrlStructV2 labelThumb) {
        this.labelThumb = labelThumb;
    }
}
