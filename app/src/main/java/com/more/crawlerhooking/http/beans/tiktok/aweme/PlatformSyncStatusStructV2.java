package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "platform_name": "",
 *     "nickname": "",
 *     "full_synced": true
 * }
 */
public class PlatformSyncStatusStructV2 {
    /**
     * platformName
     */
    @SerializedName("platform_name")
    private String platformName;
    /**
     * nickname
     */
    @SerializedName("nickname")
    private String nickname;
    /**
     * fullSynced
     */
    @SerializedName("full_synced")
    private Boolean fullSynced;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getFullSynced() {
        return fullSynced;
    }

    public void setFullSynced(Boolean fullSynced) {
        this.fullSynced = fullSynced;
    }
}
