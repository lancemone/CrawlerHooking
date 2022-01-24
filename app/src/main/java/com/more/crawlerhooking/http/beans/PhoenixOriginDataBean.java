package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;

public class PhoenixOriginDataBean extends AbsOriginDataBean{
    /**
     * vid
     */
    @SerializedName("vid")
    private String vid;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getOptPlayUrl() {
        return optPlayUrl;
    }

    public void setOptPlayUrl(String optPlayUrl) {
        this.optPlayUrl = optPlayUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * title
     */
    @SerializedName("title")
    private String title;
    /**
     * downloadCount
     */
    @SerializedName("download_count")
    private Integer downloadCount;
    /**
     * viewCount
     */
    @SerializedName("view_count")
    private Integer viewCount;
    /**
     * likeCount
     */
    @SerializedName("like_count")
    private Integer likeCount;
    /**
     * commentCount
     */
    @SerializedName("comment_count")
    private Integer commentCount;
    /**
     * playUrl
     */
    @SerializedName("play_url")
    private String playUrl;
    /**
     * optplayUrl
     */
    @SerializedName("opt_play_url")
    private String optPlayUrl;
    /**
     * picUrl
     */
    @SerializedName("pic_url")
    private String picUrl;
    /**
     * publisher
     */
    @SerializedName("publisher")
    private String publisher;
    /**
     * from
     */
    @SerializedName("from")
    private String from;
    /**
     * shareCount
     */
    @SerializedName("share_count")
    private Integer shareCount;
    /**
     * tag
     */
    @SerializedName("tag")
    private String tag;

    public PhoenixOriginDataBean() {
    }

    public PhoenixOriginDataBean(String vid, String title, String playUrl, String optPlayUrl, String picUrl, String publisher, String from, String tag, int downloadCount, int viewCount, int likeCount, int commentCount, int shareCount) {
        this.vid = vid;
        this.title = title;
        this.playUrl = playUrl;
        this.optPlayUrl = optPlayUrl;
        this.picUrl = picUrl;
        this.publisher = publisher;
        this.from = from;
        this.tag = tag;
        this.downloadCount = downloadCount;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
    }
}
