package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

public class StatisticsBean {
    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * commentCount
     */
    @SerializedName("comment_count")
    private Integer commentCount;
    /**
     * diggCount
     */
    @SerializedName("digg_count")
    private Integer diggCount;
    /**
     * downloadCount
     */
    @SerializedName("download_count")
    private Integer downloadCount;
    /**
     * playCount
     */
    @SerializedName("play_count")
    private Integer playCount;
    /**
     * shareCount
     */
    @SerializedName("share_count")
    private Integer shareCount;
    /**
     * forwardCount
     */
    @SerializedName("forward_count")
    private Integer forwardCount;
    /**
     * loseCount
     */
    @SerializedName("lose_count")
    private Integer loseCount;
    /**
     * loseCommentCount
     */
    @SerializedName("lose_comment_count")
    private Integer loseCommentCount;
    /**
     * whatsappShareCount
     */
    @SerializedName("whatsapp_share_count")
    private Integer whatsappShareCount;

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(Integer diggCount) {
        this.diggCount = diggCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    public Integer getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(Integer loseCount) {
        this.loseCount = loseCount;
    }

    public Integer getLoseCommentCount() {
        return loseCommentCount;
    }

    public void setLoseCommentCount(Integer loseCommentCount) {
        this.loseCommentCount = loseCommentCount;
    }

    public Integer getWhatsappShareCount() {
        return whatsappShareCount;
    }

    public void setWhatsappShareCount(Integer whatsappShareCount) {
        this.whatsappShareCount = whatsappShareCount;
    }
}
