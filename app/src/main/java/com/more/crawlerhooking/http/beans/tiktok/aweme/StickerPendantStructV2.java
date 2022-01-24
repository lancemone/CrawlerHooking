package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "sticker_type": 1,
 *     "link": "",
 *     "title": "",
 *     "sticker_id": "",
 *     "icon_url": {},
 *     "open_url": ""
 * }
 */
public class StickerPendantStructV2 {

    /**
     * stickerType
     */
    @SerializedName("sticker_type")
    private Integer stickerType;
    /**
     * link
     */
    @SerializedName("link")
    private String link;
    /**
     * title
     */
    @SerializedName("title")
    private String title;
    /**
     * stickerId
     */
    @SerializedName("sticker_id")
    private String stickerId;
    /**
     * iconUrl
     */
    @SerializedName("icon_url")
    private UrlStructV2 iconUrl;
    /**
     * openUrl
     */
    @SerializedName("open_url")
    private String openUrl;

    public Integer getStickerType() {
        return stickerType;
    }

    public void setStickerType(Integer stickerType) {
        this.stickerType = stickerType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStickerId() {
        return stickerId;
    }

    public void setStickerId(String stickerId) {
        this.stickerId = stickerId;
    }

    public UrlStructV2 getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(UrlStructV2 iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }
}
