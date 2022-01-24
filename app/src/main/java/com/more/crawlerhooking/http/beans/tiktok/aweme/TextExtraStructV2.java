package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "end": 8,
 *     "user_id": "",
 *     "hashTagNameFirst": "",
 *     "hashtag_id": "29533",
 *     "hashtag_name": "scenery",
 *     "is_commerce": false,
 *     "start": 0,
 *     "type": 1,
 *     "sec_uid": "",
 *     "aweme_id": "",
 *     "sub_type": 0
 * }
 */
public class TextExtraStructV2 {
    /**
     * end
     */
    @SerializedName("end")
    private Integer end;
    /**
     * userId
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * hashTagNameFirst
     */
    @SerializedName("hashTagNameFirst")
    private String hashTagNameFirst;
    /**
     * hashtagId
     */
    @SerializedName("hashtag_id")
    private String hashtagId;
    /**
     * hashtagName
     */
    @SerializedName("hashtag_name")
    private String hashtagName;
    /**
     * isCommerce
     */
    @SerializedName("is_commerce")
    private Boolean isCommerce;
    /**
     * start
     */
    @SerializedName("start")
    private Integer start;
    /**
     * type
     */
    @SerializedName("type")
    private Integer type;
    /**
     * secUid
     */
    @SerializedName("sec_uid")
    private String secUid;
    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * subType
     */
    @SerializedName("sub_type")
    private Integer subType;

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHashTagNameFirst() {
        return hashTagNameFirst;
    }

    public void setHashTagNameFirst(String hashTagNameFirst) {
        this.hashTagNameFirst = hashTagNameFirst;
    }

    public String getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(String hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Boolean getIsCommerce() {
        return isCommerce;
    }

    public void setIsCommerce(Boolean isCommerce) {
        this.isCommerce = isCommerce;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSecUid() {
        return secUid;
    }

    public void setSecUid(String secUid) {
        this.secUid = secUid;
    }

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }
}
