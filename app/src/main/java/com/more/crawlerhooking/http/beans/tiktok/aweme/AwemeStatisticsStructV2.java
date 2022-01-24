package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *         "aweme_id": "7041789688750968111",
 *         "comment_count": 232,
 *         "digg_count": 40773,
 *         "download_count": 8043,
 *         "forward_count": 0,
 *         "lose_comment_count": 0,
 *         "lose_count": 0,
 *         "play_count": 528206,
 *         "share_count": 4586,
 *         "whatsapp_share_count": 902
 *     }
 */
public class AwemeStatisticsStructV2 {

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
     * forwardCount
     */
    @SerializedName("forward_count")
    private Integer forwardCount;
    /**
     * loseCommentCount
     */
    @SerializedName("lose_comment_count")
    private Integer loseCommentCount;
    /**
     * loseCount
     */
    @SerializedName("lose_count")
    private Integer loseCount;
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

    public Integer getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    public Integer getLoseCommentCount() {
        return loseCommentCount;
    }

    public void setLoseCommentCount(Integer loseCommentCount) {
        this.loseCommentCount = loseCommentCount;
    }

    public Integer getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(Integer loseCount) {
        this.loseCount = loseCount;
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

    public Integer getWhatsappShareCount() {
        return whatsappShareCount;
    }

    public void setWhatsappShareCount(Integer whatsappShareCount) {
        this.whatsappShareCount = whatsappShareCount;
    }
}
