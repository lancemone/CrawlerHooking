package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {"impr_id": ""}
 */
public class LogPbStructV2 {
    /**
     * imprId
     */
    @SerializedName("impr_id")
    private String imprId;

    public String getImprId() {
        return imprId;
    }

    public void setImprId(String imprId) {
        this.imprId = imprId;
    }
}
