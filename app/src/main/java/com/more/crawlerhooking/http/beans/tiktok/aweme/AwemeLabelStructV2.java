package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "label_url": {},
 *     "label_type": 1
 * }
 */
public class AwemeLabelStructV2 {

    /**
     * labelUrl
     */
    @SerializedName("label_url")
    private UrlStructV2 labelUrl;
    /**
     * labelType
     */
    @SerializedName("label_type")
    private Integer labelType;

    public UrlStructV2 getLabelUrl() {
        return labelUrl;
    }

    public void setLabelUrl(UrlStructV2 labelUrl) {
        this.labelUrl = labelUrl;
    }

    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }
}
