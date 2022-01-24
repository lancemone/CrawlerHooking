package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *         "allow_download": true,
 *         "allow_duet": true,
 *         "allow_dynamic_wallpaper": true,
 *         "allow_music": true,
 *         "allow_react": true,
 *         "allow_stitch": true,
 *         "draft_progress_bar": 0,
 *         "prevent_download_type": 0,
 *         "share_type": 1,
 *         "show_progress_bar": 0,
 *         "timer_status": 1
 *     }
 */
public class VideoControlStructV2 {
    /**
     * allowDownload
     */
    @SerializedName("allow_download")
    private Boolean allowDownload;
    /**
     * allowDuet
     */
    @SerializedName("allow_duet")
    private Boolean allowDuet;
    /**
     * allowDynamicWallpaper
     */
    @SerializedName("allow_dynamic_wallpaper")
    private Boolean allowDynamicWallpaper;
    /**
     * allowMusic
     */
    @SerializedName("allow_music")
    private Boolean allowMusic;
    /**
     * allowReact
     */
    @SerializedName("allow_react")
    private Boolean allowReact;
    /**
     * allowStitch
     */
    @SerializedName("allow_stitch")
    private Boolean allowStitch;
    /**
     * draftProgressBar
     */
    @SerializedName("draft_progress_bar")
    private Integer draftProgressBar;
    /**
     * preventDownloadType
     */
    @SerializedName("prevent_download_type")
    private Integer preventDownloadType;
    /**
     * shareType
     */
    @SerializedName("share_type")
    private Integer shareType;
    /**
     * showProgressBar
     */
    @SerializedName("show_progress_bar")
    private Integer showProgressBar;
    /**
     * timerStatus
     */
    @SerializedName("timer_status")
    private Integer timerStatus;

    public Boolean getAllowDownload() {
        return allowDownload;
    }

    public void setAllowDownload(Boolean allowDownload) {
        this.allowDownload = allowDownload;
    }

    public Boolean getAllowDuet() {
        return allowDuet;
    }

    public void setAllowDuet(Boolean allowDuet) {
        this.allowDuet = allowDuet;
    }

    public Boolean getAllowDynamicWallpaper() {
        return allowDynamicWallpaper;
    }

    public void setAllowDynamicWallpaper(Boolean allowDynamicWallpaper) {
        this.allowDynamicWallpaper = allowDynamicWallpaper;
    }

    public Boolean getAllowMusic() {
        return allowMusic;
    }

    public void setAllowMusic(Boolean allowMusic) {
        this.allowMusic = allowMusic;
    }

    public Boolean getAllowReact() {
        return allowReact;
    }

    public void setAllowReact(Boolean allowReact) {
        this.allowReact = allowReact;
    }

    public Boolean getAllowStitch() {
        return allowStitch;
    }

    public void setAllowStitch(Boolean allowStitch) {
        this.allowStitch = allowStitch;
    }

    public Integer getDraftProgressBar() {
        return draftProgressBar;
    }

    public void setDraftProgressBar(Integer draftProgressBar) {
        this.draftProgressBar = draftProgressBar;
    }

    public Integer getPreventDownloadType() {
        return preventDownloadType;
    }

    public void setPreventDownloadType(Integer preventDownloadType) {
        this.preventDownloadType = preventDownloadType;
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public Integer getShowProgressBar() {
        return showProgressBar;
    }

    public void setShowProgressBar(Integer showProgressBar) {
        this.showProgressBar = showProgressBar;
    }

    public Integer getTimerStatus() {
        return timerStatus;
    }

    public void setTimerStatus(Integer timerStatus) {
        this.timerStatus = timerStatus;
    }
}
