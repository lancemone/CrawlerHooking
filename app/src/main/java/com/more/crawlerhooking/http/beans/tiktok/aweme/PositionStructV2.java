package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "begin": 1,
 *     "end": 1
 * }
 */
public class PositionStructV2 {
    /**
     * begin
     */
    @SerializedName("begin")
    private Integer begin;
    /**
     * end
     */
    @SerializedName("end")
    private Integer end;

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
