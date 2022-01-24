package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChallengeStructV2 {

    /**
     * cid
     */
    @SerializedName("cid")
    private String cid;
    /**
     * chaName
     */
    @SerializedName("cha_name")
    private String chaName;
    /**
     * desc
     */
    @SerializedName("desc")
    private String desc;
    /**
     * schema
     */
    @SerializedName("schema")
    private String schema;
    /**
     * author
     */
    @SerializedName("author")
    private UserStructV2 author;
    /**
     * userCount
     */
    @SerializedName("user_count")
    private Integer userCount;
    /**
     * shareInfo
     */
    @SerializedName("share_info")
    private ShareStructV2 shareInfo;
    /**
     * connectMusic
     */
    @SerializedName("connect_music")
    private List<MusicStructV2> connectMusic;
    /**
     * type
     */
    @SerializedName("type")
    private Integer type;
    /**
     * subType
     */
    @SerializedName("sub_type")
    private Integer subType;
    /**
     * backgroundImageUrl
     */
    @SerializedName("background_image_url")
    private UrlStructV2 backgroundImageUrl;
    /**
     * stickerId
     */
    @SerializedName("sticker_id")
    private String stickerId;
    /**
     * linkText
     */
    @SerializedName("link_text")
    private String linkText;
    /**
     * linkAction
     */
    @SerializedName("link_action")
    private String linkAction;
    /**
     * isPgcshow
     */
    @SerializedName("is_pgcshow")
    private Boolean isPgcshow;
    /**
     * collectStat
     */
    @SerializedName("collect_stat")
    private Integer collectStat;
    /**
     * coverItem
     */
    @SerializedName("cover_item")
    private UrlStructV2 coverItem;
    /**
     * isChallenge
     */
    @SerializedName("is_challenge")
    private Integer isChallenge;
    /**
     * viewCount
     */
    @SerializedName("view_count")
    private Integer viewCount;
    /**
     * disclaimer
     */
    @SerializedName("disclaimer")
    private DisclaimerStructV2 disclaimer;
    /**
     * allowUploadCover
     */
    @SerializedName("allow_upload_cover")
    private Boolean allowUploadCover;
    /**
     * isCommerce
     */
    @SerializedName("is_commerce")
    private Boolean isCommerce;
    /**
     * hashtagProfile
     */
    @SerializedName("hashtag_profile")
    private String hashtagProfile;
    /**
     * coverPhoto
     */
    @SerializedName("cover_photo")
    private String coverPhoto;
    /**
     * isHotSearch
     */
    @SerializedName("is_hot_search")
    private Integer isHotSearch;
    /**
     * linkType
     */
    @SerializedName("link_type")
    private Integer linkType;
    /**
     * announcementInfo
     */
    @SerializedName("announcement_info")
    private AnnouncementStructV2 announcementInfo;
    /**
     * moduleType
     */
    @SerializedName("module_type")
    private Integer moduleType;
    /**
     * profileTag
     */
    @SerializedName("profile_tag")
    private String profileTag;
    /**
     * chaAttrs
     */
    @SerializedName("cha_attrs")
    private List<String> chaAttrs;
    /**
     * button
     */
    @SerializedName("button")
    private IconButtonStructV2 button;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getChaName() {
        return chaName;
    }

    public void setChaName(String chaName) {
        this.chaName = chaName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public UserStructV2 getAuthor() {
        return author;
    }

    public void setAuthor(UserStructV2 author) {
        this.author = author;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public ShareStructV2 getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(ShareStructV2 shareInfo) {
        this.shareInfo = shareInfo;
    }

    public List<MusicStructV2> getConnectMusic() {
        return connectMusic;
    }

    public void setConnectMusic(List<MusicStructV2> connectMusic) {
        this.connectMusic = connectMusic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public UrlStructV2 getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(UrlStructV2 backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public String getStickerId() {
        return stickerId;
    }

    public void setStickerId(String stickerId) {
        this.stickerId = stickerId;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkAction() {
        return linkAction;
    }

    public void setLinkAction(String linkAction) {
        this.linkAction = linkAction;
    }

    public Boolean getIsPgcshow() {
        return isPgcshow;
    }

    public void setIsPgcshow(Boolean isPgcshow) {
        this.isPgcshow = isPgcshow;
    }

    public Integer getCollectStat() {
        return collectStat;
    }

    public void setCollectStat(Integer collectStat) {
        this.collectStat = collectStat;
    }

    public UrlStructV2 getCoverItem() {
        return coverItem;
    }

    public void setCoverItem(UrlStructV2 coverItem) {
        this.coverItem = coverItem;
    }

    public Integer getIsChallenge() {
        return isChallenge;
    }

    public void setIsChallenge(Integer isChallenge) {
        this.isChallenge = isChallenge;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public DisclaimerStructV2 getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(DisclaimerStructV2 disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Boolean getAllowUploadCover() {
        return allowUploadCover;
    }

    public void setAllowUploadCover(Boolean allowUploadCover) {
        this.allowUploadCover = allowUploadCover;
    }

    public Boolean getIsCommerce() {
        return isCommerce;
    }

    public void setIsCommerce(Boolean isCommerce) {
        this.isCommerce = isCommerce;
    }

    public String getHashtagProfile() {
        return hashtagProfile;
    }

    public void setHashtagProfile(String hashtagProfile) {
        this.hashtagProfile = hashtagProfile;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Integer getIsHotSearch() {
        return isHotSearch;
    }

    public void setIsHotSearch(Integer isHotSearch) {
        this.isHotSearch = isHotSearch;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public AnnouncementStructV2 getAnnouncementInfo() {
        return announcementInfo;
    }

    public void setAnnouncementInfo(AnnouncementStructV2 announcementInfo) {
        this.announcementInfo = announcementInfo;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getProfileTag() {
        return profileTag;
    }

    public void setProfileTag(String profileTag) {
        this.profileTag = profileTag;
    }

    public List<String> getChaAttrs() {
        return chaAttrs;
    }

    public void setChaAttrs(List<String> chaAttrs) {
        this.chaAttrs = chaAttrs;
    }

    public IconButtonStructV2 getButton() {
        return button;
    }

    public void setButton(IconButtonStructV2 button) {
        this.button = button;
    }
}
