package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AwemeV2FeedResponse {

    /**
     * debugInfo
     */
    @SerializedName("DebugInfo")
    private String debugInfo;
    /**
     * awemeList
     */
    @SerializedName("aweme_list")
    private List<AwemeStructV2> awemeList;
    /**
     * extra
     */
    @SerializedName("extra")
    private ExtraStructV2 extra;
    /**
     * hasMore
     */
    @SerializedName("has_more")
    private Integer hasMore;
    /**
     * homeModel
     */
    @SerializedName("home_model")
    private Integer homeModel;
    /**
     * logPb
     */
    @SerializedName("log_pb")
    private LogPbStructV2 logPb;
    /**
     * maxCursor
     */
    @SerializedName("max_cursor")
    private Integer maxCursor;
    /**
     * minCursor
     */
    @SerializedName("min_cursor")
    private Integer minCursor;
    /**
     * preloadAds
     */
    @SerializedName("preload_ads")
    private List<AwemeStructV2> preloadAds;
    /**
     * preloadAwemes
     */
    @SerializedName("preload_awemes")
    private List<AwemeStructV2> preloadAwemes;
    /**
     * refreshClear
     */
    @SerializedName("refresh_clear")
    private Integer refreshClear;
    /**
     * statusCode
     */
    @SerializedName("status_code")
    private Integer statusCode;

    public Object getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
    }

    public List<AwemeStructV2> getAwemeList() {
        return awemeList;
    }

    public void setAwemeList(List<AwemeStructV2> awemeList) {
        this.awemeList = awemeList;
    }

    public ExtraStructV2 getExtra() {
        return extra;
    }

    public void setExtra(ExtraStructV2 extra) {
        this.extra = extra;
    }

    public Integer getHasMore() {
        return hasMore;
    }

    public void setHasMore(Integer hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getHomeModel() {
        return homeModel;
    }

    public void setHomeModel(Integer homeModel) {
        this.homeModel = homeModel;
    }

    public LogPbStructV2 getLogPb() {
        return logPb;
    }

    public void setLogPb(LogPbStructV2 logPb) {
        this.logPb = logPb;
    }

    public Integer getMaxCursor() {
        return maxCursor;
    }

    public void setMaxCursor(Integer maxCursor) {
        this.maxCursor = maxCursor;
    }

    public Integer getMinCursor() {
        return minCursor;
    }

    public void setMinCursor(Integer minCursor) {
        this.minCursor = minCursor;
    }

    public List<?> getPreloadAds() {
        return preloadAds;
    }

    public void setPreloadAds(List<AwemeStructV2> preloadAds) {
        this.preloadAds = preloadAds;
    }

    public List<?> getPreloadAwemes() {
        return preloadAwemes;
    }

    public void setPreloadAwemes(List<AwemeStructV2> preloadAwemes) {
        this.preloadAwemes = preloadAwemes;
    }

    public Integer getRefreshClear() {
        return refreshClear;
    }

    public void setRefreshClear(Integer refreshClear) {
        this.refreshClear = refreshClear;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
