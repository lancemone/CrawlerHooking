package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "h5_url": "",
 *     "partner_name": "",
 *     "partner_song_id": "",
 *     "external_song_key": ""
 * }
 */
public class ExternalSongStructV2 {


    /**
     * h5Url
     */
    @SerializedName("h5_url")
    private String h5Url;
    /**
     * partnerName
     */
    @SerializedName("partner_name")
    private String partnerName;
    /**
     * partnerSongId
     */
    @SerializedName("partner_song_id")
    private String partnerSongId;
    /**
     * externalSongKey
     */
    @SerializedName("external_song_key")
    private String externalSongKey;

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerSongId() {
        return partnerSongId;
    }

    public void setPartnerSongId(String partnerSongId) {
        this.partnerSongId = partnerSongId;
    }

    public String getExternalSongKey() {
        return externalSongKey;
    }

    public void setExternalSongKey(String externalSongKey) {
        this.externalSongKey = externalSongKey;
    }
}
