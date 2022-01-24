package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "uid": 1,
 *     "avatar": {},
 *     "nickname": "",
 *     "remark_name": "",
 *     "avatar_larger": {},
 *     "avatar_thumb": {},
 *     "follow_status": 7,
 *     "sec_uid": ""
 * }
 */
public class RelativeUserStructV2 {

    /**
     * uid
     */
    @SerializedName("uid")
    private Integer uid;
    /**
     * avatar
     */
    @SerializedName("avatar")
    private UrlStructV2 avatar;
    /**
     * nickname
     */
    @SerializedName("nickname")
    private String nickname;
    /**
     * remarkName
     */
    @SerializedName("remark_name")
    private String remarkName;
    /**
     * avatarLarger
     */
    @SerializedName("avatar_larger")
    private UrlStructV2 avatarLarger;
    /**
     * avatarThumb
     */
    @SerializedName("avatar_thumb")
    private UrlStructV2 avatarThumb;
    /**
     * followStatus
     */
    @SerializedName("follow_status")
    private Integer followStatus;
    /**
     * secUid
     */
    @SerializedName("sec_uid")
    private String secUid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public UrlStructV2 getAvatar() {
        return avatar;
    }

    public void setAvatar(UrlStructV2 avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public UrlStructV2 getAvatarLarger() {
        return avatarLarger;
    }

    public void setAvatarLarger(UrlStructV2 avatarLarger) {
        this.avatarLarger = avatarLarger;
    }

    public UrlStructV2 getAvatarThumb() {
        return avatarThumb;
    }

    public void setAvatarThumb(UrlStructV2 avatarThumb) {
        this.avatarThumb = avatarThumb;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    public String getSecUid() {
        return secUid;
    }

    public void setSecUid(String secUid) {
        this.secUid = secUid;
    }
}
