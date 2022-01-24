package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "is_mute": true,
 *     "mute_desc": ""
 * }
 */
public class VideoMuteStructV2 {

    /**
     * isMute
     */
    @SerializedName("is_mute")
    private Boolean isMute;
    /**
     * muteDesc
     */
    @SerializedName("mute_desc")
    private String muteDesc;

    public Boolean getIsMute() {
        return isMute;
    }

    public void setIsMute(Boolean isMute) {
        this.isMute = isMute;
    }

    public String getMuteDesc() {
        return muteDesc;
    }

    public void setMuteDesc(String muteDesc) {
        this.muteDesc = muteDesc;
    }
}
