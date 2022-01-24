package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "name": "1",
 *     "icon": "2",
 *     "fans_count": 3,
 *     "open_url": "4",
 *     "apple_id": "5",
 *     "download_url": "6",
 *     "package_name": "7",
 *     "app_name": "8"
 * }
 */
public class FollowersDetailV2 {

    /**
     * name
     */
    @SerializedName("name")
    private String name;
    /**
     * icon
     */
    @SerializedName("icon")
    private String icon;
    /**
     * fansCount
     */
    @SerializedName("fans_count")
    private Integer fansCount;
    /**
     * openUrl
     */
    @SerializedName("open_url")
    private String openUrl;
    /**
     * appleId
     */
    @SerializedName("apple_id")
    private String appleId;
    /**
     * downloadUrl
     */
    @SerializedName("download_url")
    private String downloadUrl;
    /**
     * packageName
     */
    @SerializedName("package_name")
    private String packageName;
    /**
     * appName
     */
    @SerializedName("app_name")
    private String appName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    public String getAppleId() {
        return appleId;
    }

    public void setAppleId(String appleId) {
        this.appleId = appleId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
