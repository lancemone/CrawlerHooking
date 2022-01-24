package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;
import com.more.crawlerhooking.http.beans.tiktok.aweme.AwemeStatisticsStructV2;
import com.more.crawlerhooking.http.beans.tiktok.aweme.UserStructV2;
import com.more.crawlerhooking.http.beans.tiktok.aweme.VideoStructV2;

public class TiktokOriginDataBean extends AbsOriginDataBean{
    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * desc
     */
    @SerializedName("desc")
    private String desc;
    /**
     * createTime
     */
    @SerializedName("create_time")
    private Integer createTime;
    /**
     * author
     */
    @SerializedName("author")
    private UserStructV2 author;
    /**
     * video
     */
    @SerializedName("video")
    private VideoStructV2 video;
    /**
     * statistics
     */
    @SerializedName("statistics")
    private AwemeStatisticsStructV2 statistics;
    /**
     * descLanguage
     */
    @SerializedName("desc_language")
    private String descLanguage;
    /**
     * region
     */
    @SerializedName("region")
    private String region;

    public TiktokOriginDataBean(){}

    public TiktokOriginDataBean(String awemeId, String desc, Integer createTime, UserStructV2 author, VideoStructV2 video, AwemeStatisticsStructV2 statistics, String descLanguage, String region) {
        this.awemeId = awemeId;
        this.desc = desc;
        this.createTime = createTime;
        this.author = author;
        this.video = video;
        this.statistics = statistics;
        this.descLanguage = descLanguage;
        this.region = region;
    }

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public UserStructV2 getAuthor() {
        return author;
    }

    public void setAuthor(UserStructV2 author) {
        this.author = author;
    }

    public VideoStructV2 getVideo() {
        return video;
    }

    public void setVideo(VideoStructV2 video) {
        this.video = video;
    }

    public AwemeStatisticsStructV2 getStatistics() {
        return statistics;
    }

    public void setStatistics(AwemeStatisticsStructV2 statistics) {
        this.statistics = statistics;
    }

    public String getDescLanguage() {
        return descLanguage;
    }

    public void setDescLanguage(String descLanguage) {
        this.descLanguage = descLanguage;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
