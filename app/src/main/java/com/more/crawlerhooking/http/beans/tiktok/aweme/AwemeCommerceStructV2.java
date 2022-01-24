package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "ad_auth_status": 1,
 *     "ad_source": 2,
 *     "avoid_global_pendant": true,
 *     "with_comment_filter_words": 4,
 *     "ad_style": 5,
 *     "prevent_share": true
 * }
 */
public class AwemeCommerceStructV2 {

    /**
     * adAuthStatus
     */
    @SerializedName("ad_auth_status")
    private Integer adAuthStatus;
    /**
     * adSource
     */
    @SerializedName("ad_source")
    private Integer adSource;
    /**
     * avoidGlobalPendant
     */
    @SerializedName("avoid_global_pendant")
    private Boolean avoidGlobalPendant;
    /**
     * withCommentFilterWords
     */
    @SerializedName("with_comment_filter_words")
    private Boolean withCommentFilterWords;
    /**
     * adStyle
     */
    @SerializedName("ad_style")
    private Integer adStyle;
    /**
     * preventShare
     */
    @SerializedName("prevent_share")
    private Boolean preventShare;

    public Integer getAdAuthStatus() {
        return adAuthStatus;
    }

    public void setAdAuthStatus(Integer adAuthStatus) {
        this.adAuthStatus = adAuthStatus;
    }

    public Integer getAdSource() {
        return adSource;
    }

    public void setAdSource(Integer adSource) {
        this.adSource = adSource;
    }

    public Boolean getAvoidGlobalPendant() {
        return avoidGlobalPendant;
    }

    public void setAvoidGlobalPendant(Boolean avoidGlobalPendant) {
        this.avoidGlobalPendant = avoidGlobalPendant;
    }

    public Boolean getWithCommentFilterWords() {
        return withCommentFilterWords;
    }

    public void setWithCommentFilterWords(Boolean withCommentFilterWords) {
        this.withCommentFilterWords = withCommentFilterWords;
    }

    public Integer getAdStyle() {
        return adStyle;
    }

    public void setAdStyle(Integer adStyle) {
        this.adStyle = adStyle;
    }

    public Boolean getPreventShare() {
        return preventShare;
    }

    public void setPreventShare(Boolean preventShare) {
        this.preventShare = preventShare;
    }
}
