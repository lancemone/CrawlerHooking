package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

public class BitRateStructV2 {
    /**
     * bitRate
     */
    @SerializedName("bit_rate")
    private Integer bitRate;
    /**
     * gearName
     */
    @SerializedName("gear_name")
    private String gearName;
    /**
     * isBytevc1
     */
    @SerializedName("is_bytevc1")
    private Integer isBytevc1;
    /**
     * playAddr
     */
    @SerializedName("play_addr")
    private UrlStructV2 playAddr;
    /**
     * playAddr265
     */
    @SerializedName("play_addr_265")
    private UrlStructV2 playAddr265;
    /**
     * playAddrBytevc1
     */
    @SerializedName("play_addr_bytevc1")
    private UrlStructV2 playAddrBytevc1;
    /**
     * qualityType
     */
    @SerializedName("quality_type")
    private Integer qualityType;

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public String getGearName() {
        return gearName;
    }

    public void setGearName(String gearName) {
        this.gearName = gearName;
    }

    public Integer getIsBytevc1() {
        return isBytevc1;
    }

    public void setIsBytevc1(Integer isBytevc1) {
        this.isBytevc1 = isBytevc1;
    }

    public UrlStructV2 getPlayAddr() {
        return playAddr;
    }

    public void setPlayAddr(UrlStructV2 playAddr) {
        this.playAddr = playAddr;
    }

    public Integer getQualityType() {
        return qualityType;
    }

    public void setQualityType(Integer qualityType) {
        this.qualityType = qualityType;
    }

    public UrlStructV2 getPlayAddr265() {
        return playAddr265;
    }

    public void setPlayAddr265(UrlStructV2 playAddr265) {
        this.playAddr265 = playAddr265;
    }

    public UrlStructV2 getPlayAddrBytevc1() {
        return playAddrBytevc1;
    }

    public void setPlayAddrBytevc1(UrlStructV2 playAddrBytevc1) {
        this.playAddrBytevc1 = playAddrBytevc1;
    }
}
