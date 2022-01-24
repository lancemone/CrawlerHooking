package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoStructV2 {

    /**
     * bigThumbs
     */
    @SerializedName("big_thumbs")
    private List<BigThumbV2> bigThumbs;
    /**
     * bitRate
     */
    @SerializedName("bit_rate")
    private List<BitRateStructV2> bitRate;
    /**
     * cdnUrlExpired
     */
    @SerializedName("cdn_url_expired")
    private Integer cdnUrlExpired;
    /**
     * cover
     */
    @SerializedName("cover")
    private UrlStructV2 cover;
    /**
     * downloadAddr
     */
    @SerializedName("download_addr")
    private UrlStructV2 downloadAddr;
    /**
     * duration
     */
    @SerializedName("duration")
    private Integer duration;
    /**
     * dynamicCover
     */
    @SerializedName("dynamic_cover")
    private UrlStructV2 dynamicCover;
    /**
     * hasWatermark
     */
    @SerializedName("has_watermark")
    private Boolean hasWatermark;
    /**
     * height
     */
    @SerializedName("height")
    private Integer height;
    /**
     * isBytevc1
     */
    @SerializedName("is_bytevc1")
    private Integer isBytevc1;
    /**
     * meta
     */
    @SerializedName("meta")
    private String meta;
    /**
     * needSetToken
     */
    @SerializedName("need_set_token")
    private Boolean needSetToken;
    /**
     * originCover
     */
    @SerializedName("origin_cover")
    private UrlStructV2 originCover;
    /**
     * playAddr
     */
    @SerializedName("play_addr")
    private UrlStructV2 playAddr;
    /**
     * playAddrBytevc1
     */
    @SerializedName("play_addr_bytevc1")
    private UrlStructV2 playAddrBytevc1;
    /**
     * playAddrH264
     */
    @SerializedName("play_addr_h264")
    private UrlStructV2 playAddrH264;
    /**
     * ratio
     */
    @SerializedName("ratio")
    private String ratio;
    /**
     * width
     */
    @SerializedName("width")
    private Integer width;

    public List<BigThumbV2> getBigThumbs() {
        return bigThumbs;
    }

    public void setBigThumbs(List<BigThumbV2> bigThumbs) {
        this.bigThumbs = bigThumbs;
    }

    public List<BitRateStructV2> getBitRate() {
        return bitRate;
    }

    public void setBitRate(List<BitRateStructV2> bitRate) {
        this.bitRate = bitRate;
    }

    public Integer getCdnUrlExpired() {
        return cdnUrlExpired;
    }

    public void setCdnUrlExpired(Integer cdnUrlExpired) {
        this.cdnUrlExpired = cdnUrlExpired;
    }

    public UrlStructV2 getCover() {
        return cover;
    }

    public void setCover(UrlStructV2 cover) {
        this.cover = cover;
    }

    public UrlStructV2 getDownloadAddr() {
        return downloadAddr;
    }

    public void setDownloadAddr(UrlStructV2 downloadAddr) {
        this.downloadAddr = downloadAddr;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public UrlStructV2 getDynamicCover() {
        return dynamicCover;
    }

    public void setDynamicCover(UrlStructV2 dynamicCover) {
        this.dynamicCover = dynamicCover;
    }

    public Boolean getHasWatermark() {
        return hasWatermark;
    }

    public void setHasWatermark(Boolean hasWatermark) {
        this.hasWatermark = hasWatermark;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getIsBytevc1() {
        return isBytevc1;
    }

    public void setIsBytevc1(Integer isBytevc1) {
        this.isBytevc1 = isBytevc1;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Boolean getNeedSetToken() {
        return needSetToken;
    }

    public void setNeedSetToken(Boolean needSetToken) {
        this.needSetToken = needSetToken;
    }

    public UrlStructV2 getOriginCover() {
        return originCover;
    }

    public void setOriginCover(UrlStructV2 originCover) {
        this.originCover = originCover;
    }

    public UrlStructV2 getPlayAddr() {
        return playAddr;
    }

    public void setPlayAddr(UrlStructV2 playAddr) {
        this.playAddr = playAddr;
    }

    public UrlStructV2 getPlayAddrBytevc1() {
        return playAddrBytevc1;
    }

    public void setPlayAddrBytevc1(UrlStructV2 playAddrBytevc1) {
        this.playAddrBytevc1 = playAddrBytevc1;
    }

    public UrlStructV2 getPlayAddrH264() {
        return playAddrH264;
    }

    public void setPlayAddrH264(UrlStructV2 playAddrH264) {
        this.playAddrH264 = playAddrH264;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
