package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;
import com.more.crawlerhooking.http.beans.AbsOriginDataBean;

public class TiktokOriginDataBeanBack extends AbsOriginDataBean {


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
    private AuthorBean author;
    /**
     * video
     */
    @SerializedName("video")
    private VideoBean video;
    /**
     * statistics
     */
    @SerializedName("statistics")
    private StatisticsBean statistics;
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

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public StatisticsBean getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsBean statistics) {
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
