package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "comment": 1,
 *     "profile": 1,
 *     "comment_pro": 1.0000,
 *     "profile_pro": 1.0000,
 *     "comment_thres": 1.0000,
 *     "profile_thres": 1.0000,
 *     "comment_median_time": 1.0000,
 *     "profile_median_time": 1.0000,
 *     "model_v2": 1
 * }
 */
public class PreloadStructV2 {

    /**
     * comment
     */
    @SerializedName("comment")
    private Integer comment;
    /**
     * profile
     */
    @SerializedName("profile")
    private Integer profile;
    /**
     * commentPro
     */
    @SerializedName("comment_pro")
    private Double commentPro;
    /**
     * profilePro
     */
    @SerializedName("profile_pro")
    private Double profilePro;
    /**
     * commentThres
     */
    @SerializedName("comment_thres")
    private Double commentThres;
    /**
     * profileThres
     */
    @SerializedName("profile_thres")
    private Double profileThres;
    /**
     * commentMedianTime
     */
    @SerializedName("comment_median_time")
    private Double commentMedianTime;
    /**
     * profileMedianTime
     */
    @SerializedName("profile_median_time")
    private Double profileMedianTime;
    /**
     * modelV2
     */
    @SerializedName("model_v2")
    private Integer modelV2;

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Double getCommentPro() {
        return commentPro;
    }

    public void setCommentPro(Double commentPro) {
        this.commentPro = commentPro;
    }

    public Double getProfilePro() {
        return profilePro;
    }

    public void setProfilePro(Double profilePro) {
        this.profilePro = profilePro;
    }

    public Double getCommentThres() {
        return commentThres;
    }

    public void setCommentThres(Double commentThres) {
        this.commentThres = commentThres;
    }

    public Double getProfileThres() {
        return profileThres;
    }

    public void setProfileThres(Double profileThres) {
        this.profileThres = profileThres;
    }

    public Double getCommentMedianTime() {
        return commentMedianTime;
    }

    public void setCommentMedianTime(Double commentMedianTime) {
        this.commentMedianTime = commentMedianTime;
    }

    public Double getProfileMedianTime() {
        return profileMedianTime;
    }

    public void setProfileMedianTime(Double profileMedianTime) {
        this.profileMedianTime = profileMedianTime;
    }

    public Integer getModelV2() {
        return modelV2;
    }

    public void setModelV2(Integer modelV2) {
        this.modelV2 = modelV2;
    }
}
