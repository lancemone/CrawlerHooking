package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "content": "",
 *     "notice": true,
 *     "risk_sink": false,
 *     "type": 0,
 *     "url": "",
 *     "vote": false,
 *     "warn": false
 * }
 */
public class AwemeRiskStructV2 {
    /**
     * content
     */
    @SerializedName("content")
    private String content;
    /**
     * notice
     */
    @SerializedName("notice")
    private Boolean notice;
    /**
     * riskSink
     */
    @SerializedName("risk_sink")
    private Boolean riskSink;
    /**
     * type
     */
    @SerializedName("type")
    private Integer type;
    /**
     * url
     */
    @SerializedName("url")
    private String url;
    /**
     * vote
     */
    @SerializedName("vote")
    private Boolean vote;
    /**
     * warn
     */
    @SerializedName("warn")
    private Boolean warn;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getNotice() {
        return notice;
    }

    public void setNotice(Boolean notice) {
        this.notice = notice;
    }

    public Boolean getRiskSink() {
        return riskSink;
    }

    public void setRiskSink(Boolean riskSink) {
        this.riskSink = riskSink;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public Boolean getWarn() {
        return warn;
    }

    public void setWarn(Boolean warn) {
        this.warn = warn;
    }
}
