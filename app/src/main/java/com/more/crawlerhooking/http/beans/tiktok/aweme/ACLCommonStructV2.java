package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;


/**
 * {
 *     "code": 1,
 *     "show_type": 2,
 *     "toast_msg": "",
 *     "extra": "",
 *     "transcode": 1,
 *     "mute": true,
 *     "popup_msg": "",
 *     "platform_id": ""
 * }
 */
public class ACLCommonStructV2 {

    /**
     * code
     */
    @SerializedName("code")
    private Integer code;
    /**
     * showType
     */
    @SerializedName("show_type")
    private Integer showType;
    /**
     * toastMsg
     */
    @SerializedName("toast_msg")
    private String toastMsg;
    /**
     * extra
     */
    @SerializedName("extra")
    private String extra;
    /**
     * transcode
     */
    @SerializedName("transcode")
    private Integer transcode;
    /**
     * mute
     */
    @SerializedName("mute")
    private Boolean mute;
    /**
     * popupMsg
     */
    @SerializedName("popup_msg")
    private String popupMsg;
    /**
     * platformId
     */
    @SerializedName("platform_id")
    private String platformId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getToastMsg() {
        return toastMsg;
    }

    public void setToastMsg(String toastMsg) {
        this.toastMsg = toastMsg;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Integer getTranscode() {
        return transcode;
    }

    public void setTranscode(Integer transcode) {
        this.transcode = transcode;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    public String getPopupMsg() {
        return popupMsg;
    }

    public void setPopupMsg(String popupMsg) {
        this.popupMsg = popupMsg;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
}
