package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

public class AuthorBean {
    /**
     * uid
     */
    @SerializedName("uid")
    private String uid;
    /**
     * uniqueId
     */
    @SerializedName("unique_id")
    private String uniqueId;
    /**
     * secUid
     */
    @SerializedName("sec_uid")
    private String secUid;
    /**
     * language
     */
    @SerializedName("language")
    private String language;
    /**
     * region
     */
    @SerializedName("region")
    private String region;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getSecUid() {
        return secUid;
    }

    public void setSecUid(String secUid) {
        this.secUid = secUid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
