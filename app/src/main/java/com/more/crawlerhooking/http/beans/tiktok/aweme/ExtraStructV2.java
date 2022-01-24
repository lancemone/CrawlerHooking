package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {
 *     "now": 1,
 *     "logid": "",
 *     "fatal_item_ids": [""]
 * }
 */
public class ExtraStructV2 {

    /**
     * now
     */
    @SerializedName("now")
    private Long now;
    /**
     * logid
     */
    @SerializedName("logid")
    private String logid;
    /**
     * fatalItemIds
     */
    @SerializedName("fatal_item_ids")
    private List<String> fatalItemIds;

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public List<String> getFatalItemIds() {
        return fatalItemIds;
    }

    public void setFatalItemIds(List<String> fatalItemIds) {
        this.fatalItemIds = fatalItemIds;
    }
}
