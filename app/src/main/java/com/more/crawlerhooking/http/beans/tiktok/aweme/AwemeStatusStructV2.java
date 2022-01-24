package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "allow_comment": true,
 *     "allow_share": true,
 *     "aweme_id": "7041789688750968111",
 *     "download_status": 0,
 *     "dont_share_status": 0,
 *     "video_hide_search": 1,
 *     "in_reviewing": false,
 *     "is_delete": false,
 *     "is_prohibited": false,
 *     "private_status": 0,
 *     "reviewed": 1,
 *     "self_see": false,
 *     "video_mute": {}
 * }
 */
public class AwemeStatusStructV2 {

    /**
     * allowComment
     */
    @SerializedName("allow_comment")
    private Boolean allowComment;
    /**
     * allowShare
     */
    @SerializedName("allow_share")
    private Boolean allowShare;
    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * downloadStatus
     */
    @SerializedName("download_status")
    private Integer downloadStatus;
    /**
     * dontShareStatus
     */
    @SerializedName("dont_share_status")
    private Integer dontShareStatus;
    /**
     * videoHideSearch
     */
    @SerializedName("video_hide_search")
    private Integer videoHideSearch;
    /**
     * inReviewing
     */
    @SerializedName("in_reviewing")
    private Boolean inReviewing;
    /**
     * isDelete
     */
    @SerializedName("is_delete")
    private Boolean isDelete;
    /**
     * isProhibited
     */
    @SerializedName("is_prohibited")
    private Boolean isProhibited;
    /**
     * privateStatus
     */
    @SerializedName("private_status")
    private Integer privateStatus;
    /**
     * reviewed
     */
    @SerializedName("reviewed")
    private Integer reviewed;
    /**
     * selfSee
     */
    @SerializedName("self_see")
    private Boolean selfSee;
    /**
     * videoMute
     */
    @SerializedName("video_mute")
    private VideoMuteStructV2 videoMute;

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Boolean getAllowShare() {
        return allowShare;
    }

    public void setAllowShare(Boolean allowShare) {
        this.allowShare = allowShare;
    }

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public Integer getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(Integer downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public Integer getDontShareStatus() {
        return dontShareStatus;
    }

    public void setDontShareStatus(Integer dontShareStatus) {
        this.dontShareStatus = dontShareStatus;
    }

    public Integer getVideoHideSearch() {
        return videoHideSearch;
    }

    public void setVideoHideSearch(Integer videoHideSearch) {
        this.videoHideSearch = videoHideSearch;
    }

    public Boolean getInReviewing() {
        return inReviewing;
    }

    public void setInReviewing(Boolean inReviewing) {
        this.inReviewing = inReviewing;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsProhibited() {
        return isProhibited;
    }

    public void setIsProhibited(Boolean isProhibited) {
        this.isProhibited = isProhibited;
    }

    public Integer getPrivateStatus() {
        return privateStatus;
    }

    public void setPrivateStatus(Integer privateStatus) {
        this.privateStatus = privateStatus;
    }

    public Integer getReviewed() {
        return reviewed;
    }

    public void setReviewed(Integer reviewed) {
        this.reviewed = reviewed;
    }

    public Boolean getSelfSee() {
        return selfSee;
    }

    public void setSelfSee(Boolean selfSee) {
        this.selfSee = selfSee;
    }

    public VideoMuteStructV2 getVideoMute() {
        return videoMute;
    }

    public void setVideoMute(VideoMuteStructV2 videoMute) {
        this.videoMute = videoMute;
    }
}
