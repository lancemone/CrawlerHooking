package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "show_mask": true,
 *     "mask_type": 1,
 *     "status": 1,
 *     "title": "",
 *     "content": "",
 *     "cancel_mask_label": "",
 * }
 */
public class MaskStructV2 {
    /**
     * showMask
     */
    @SerializedName("show_mask")
    private Boolean showMask;
    /**
     * maskType
     */
    @SerializedName("mask_type")
    private Integer maskType;
    /**
     * status
     */
    @SerializedName("status")
    private Integer status;
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
    /**
     * cancelMaskLabel
     */
    @SerializedName("cancel_mask_label")
    private String cancelMaskLabel;

    public Boolean getShowMask() {
        return showMask;
    }

    public void setShowMask(Boolean showMask) {
        this.showMask = showMask;
    }

    public Integer getMaskType() {
        return maskType;
    }

    public void setMaskType(Integer maskType) {
        this.maskType = maskType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public String getCancelMaskLabel() {
        return cancelMaskLabel;
    }

    public void setCancelMaskLabel(String cancelMaskLabel) {
        this.cancelMaskLabel = cancelMaskLabel;
    }
}
