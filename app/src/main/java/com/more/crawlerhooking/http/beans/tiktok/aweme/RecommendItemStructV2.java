package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "aweme_id": "",
 *     "cover": {},
 *     "dynamic_cover": {},
 *     "media_type": 4
 * }
 */
public class RecommendItemStructV2 {

    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * cover
     */
    @SerializedName("cover")
    private UrlStructV2 cover;
    /**
     * dynamicCover
     */
    @SerializedName("dynamic_cover")
    private UrlStructV2 dynamicCover;
    /**
     * mediaType
     */
    @SerializedName("media_type")
    private Integer mediaType;

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public UrlStructV2 getCover() {
        return cover;
    }

    public void setCover(UrlStructV2 cover) {
        this.cover = cover;
    }

    public UrlStructV2 getDynamicCover() {
        return dynamicCover;
    }

    public void setDynamicCover(UrlStructV2 dynamicCover) {
        this.dynamicCover = dynamicCover;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }
}
