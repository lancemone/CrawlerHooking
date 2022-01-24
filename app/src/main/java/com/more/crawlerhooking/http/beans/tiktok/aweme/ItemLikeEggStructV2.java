package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "material_url": "",
 *     "file_type": ""
 * }
 */
public class ItemLikeEggStructV2 {

    /**
     * materialUrl
     */
    @SerializedName("material_url")
    private String materialUrl;
    /**
     * fileType
     */
    @SerializedName("file_type")
    private String fileType;

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
