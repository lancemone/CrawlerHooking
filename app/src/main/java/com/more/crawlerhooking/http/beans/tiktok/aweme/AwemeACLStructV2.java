package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {
 *     "download_general": {},
 *     "download_mask_panel": {},
 *     "platform_list": [],
 *     "share_general": {},
 *     "share_list_status": 0
 * }
 */
public class AwemeACLStructV2 {

    /**
     * downloadGeneral
     */
    @SerializedName("download_general")
    private ACLCommonStructV2 downloadGeneral;
    /**
     * downloadMaskPanel
     */
    @SerializedName("download_mask_panel")
    private ACLCommonStructV2 downloadMaskPanel;
    /**
     * platformList
     */
    @SerializedName("platform_list")
    private List<ACLCommonStructV2> platformList;
    /**
     * shareGeneral
     */
    @SerializedName("share_general")
    private ACLCommonStructV2 shareGeneral;
    /**
     * shareListStatus
     */
    @SerializedName("share_list_status")
    private Integer shareListStatus;

    public ACLCommonStructV2 getDownloadGeneral() {
        return downloadGeneral;
    }

    public void setDownloadGeneral(ACLCommonStructV2 downloadGeneral) {
        this.downloadGeneral = downloadGeneral;
    }

    public ACLCommonStructV2 getDownloadMaskPanel() {
        return downloadMaskPanel;
    }

    public void setDownloadMaskPanel(ACLCommonStructV2 downloadMaskPanel) {
        this.downloadMaskPanel = downloadMaskPanel;
    }

    public List<ACLCommonStructV2> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<ACLCommonStructV2> platformList) {
        this.platformList = platformList;
    }

    public ACLCommonStructV2 getShareGeneral() {
        return shareGeneral;
    }

    public void setShareGeneral(ACLCommonStructV2 shareGeneral) {
        this.shareGeneral = shareGeneral;
    }

    public Integer getShareListStatus() {
        return shareListStatus;
    }

    public void setShareListStatus(Integer shareListStatus) {
        this.shareListStatus = shareListStatus;
    }
}
