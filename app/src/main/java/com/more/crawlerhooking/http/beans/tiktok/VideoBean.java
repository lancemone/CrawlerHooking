package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

public class VideoBean {
    /**
     * duration
     */
    @SerializedName("duration")
    private Integer duration;
    /**
     * height
     */
    @SerializedName("height")
    private Integer height;
    /**
     * width
     */
    @SerializedName("width")
    private Integer width;
    /**
     * playAddr
     */
    @SerializedName("play_addr")
    private PlayAddrBean playAddr;
    /**
     * cover
     */
    @SerializedName("cover")
    private CoverBean cover;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public PlayAddrBean getPlayAddr() {
        return playAddr;
    }

    public void setPlayAddr(PlayAddrBean playAddr) {
        this.playAddr = playAddr;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }
}
