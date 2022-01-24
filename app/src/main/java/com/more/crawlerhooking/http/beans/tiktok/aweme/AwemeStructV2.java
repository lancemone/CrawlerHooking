package com.more.crawlerhooking.http.beans.tiktok.aweme;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AwemeStructV2 {

    /**
     * allowGift
     */
    @SerializedName("allow_gift")
    private Boolean allowGift;
    /**
     * anchors
     */
    @SerializedName("anchors")
    private List<AnchorCommonStructV2> anchors;
    /**
     * anchorsExtras
     */
    @SerializedName("anchors_extras")
    private String anchorsExtras;
    /**
     * author
     */
    @SerializedName("author")
    private UserStructV2 author;
    /**
     * awemeAcl
     */
    @SerializedName("aweme_acl")
    private AwemeACLStructV2 awemeAcl;
    /**
     * awemeId
     */
    @SerializedName("aweme_id")
    private String awemeId;
    /**
     * awemeType
     */
    @SerializedName("aweme_type")
    private Integer awemeType;
    /**
     * bodydanceScore
     */
    @SerializedName("bodydance_score")
    private Integer bodydanceScore;
    /**
     * chaList
     */
    @SerializedName("cha_list")
    private List<ChallengeStructV2> chaList;
    /**
     * cmtSwt
     */
    @SerializedName("cmt_swt")
    private Boolean cmtSwt;
    /**
     * collectStat
     */
    @SerializedName("collect_stat")
    private Integer collectStat;
    /**
     * commerceConfigData
     */
    @SerializedName("commerce_config_data")
    private List<CommerceConfigDataV2> commerceConfigData;
    /**
     * commerceInfo
     */
    @SerializedName("commerce_info")
    private AwemeCommerceStructV2 commerceInfo;
    /**
     * createTime
     */
    @SerializedName("create_time")
    private Integer createTime;
    /**
     * desc
     */
    @SerializedName("desc")
    private String desc;
    /**
     * descLanguage
     */
    @SerializedName("desc_language")
    private String descLanguage;
    /**
     * distance
     */
    @SerializedName("distance")
    private String distance;
    /**
     * distributeType
     */
    @SerializedName("distribute_type")
    private Integer distributeType;
    /**
     * geofencingRegions
     */
    @SerializedName("geofencing_regions")
    private List<String> geofencingRegions;
    /**
     * groupId
     */
    @SerializedName("group_id")
    private String groupId;
    /**
     * hasVsEntry
     */
    @SerializedName("has_vs_entry")
    private Boolean hasVsEntry;
    /**
     * hybridLabel
     */
    @SerializedName("hybrid_label")
    private List<HybridLabelStructV2> hybridLabel;
    /**
     * imageInfos
     */
    @SerializedName("image_infos")
    private List<ImageInfoStructV2> imageInfos;
    /**
     * interactionStickers
     */
    @SerializedName("interaction_stickers")
    private List<InteractionStickerStructV2> interactionStickers;
    /**
     * isAds
     */
    @SerializedName("is_ads")
    private Boolean isAds;
    /**
     * isHashTag
     */
    @SerializedName("is_hash_tag")
    private Integer isHashTag;
    /**
     * isPgcshow
     */
    @SerializedName("is_pgcshow")
    private Boolean isPgcshow;
    /**
     * isRelieve
     */
    @SerializedName("is_relieve")
    private Boolean isRelieve;
    /**
     * isTop
     */
    @SerializedName("is_top")
    private Integer isTop;
    /**
     * isVr
     */
    @SerializedName("is_vr")
    private Boolean isVr;
    /**
     * itemCommentSettings
     */
    @SerializedName("item_comment_settings")
    private Integer itemCommentSettings;
    /**
     * itemDuet
     */
    @SerializedName("item_duet")
    private Integer itemDuet;
    /**
     * itemReact
     */
    @SerializedName("item_react")
    private Integer itemReact;
    /**
     * itemStitch
     */
    @SerializedName("item_stitch")
    private Integer itemStitch;
    /**
     * labelTop
     */
    @SerializedName("label_top")
    private UrlStructV2 labelTop;
    /**
     * labelTopText
     */
    @SerializedName("label_top_text")
    private List<VideoTextStructV2> labelTopText;
    /**
     * longVideo
     */
    @SerializedName("long_video")
    private List<LongVideoStructV2> longVideo;
    /**
     * maskInfos
     */
    @SerializedName("mask_infos")
    private List<MaskStructV2> maskInfos;
    /**
     * miscInfo
     */
    @SerializedName("misc_info")
    private String miscInfo;
    /**
     * music
     */
    @SerializedName("music")
    private MusicStructV2 music;
    /**
     * needVsEntry
     */
    @SerializedName("need_vs_entry")
    private Boolean needVsEntry;
    /**
     * nicknamePosition
     */
    @SerializedName("nickname_position")
    private List<PositionStructV2> nicknamePosition;
    /**
     * originCommentIds
     */
    @SerializedName("origin_comment_ids")
    private List<String> originCommentIds;
    /**
     * position
     */
    @SerializedName("position")
    private List<PositionStructV2> position;
    /**
     * preload
     */
    @SerializedName("preload")
    private PreloadStructV2 preload;
    /**
     * preventDownload
     */
    @SerializedName("prevent_download")
    private Boolean preventDownload;
    /**
     * rate
     */
    @SerializedName("rate")
    private Integer rate;
    /**
     * region
     */
    @SerializedName("region")
    private String region;
    /**
     * riskInfos
     */
    @SerializedName("risk_infos")
    private AwemeRiskStructV2 riskInfos;
    /**
     * shareInfo
     */
    @SerializedName("share_info")
    private ShareStructV2 shareInfo;
    /**
     * shareUrl
     */
    @SerializedName("share_url")
    private String shareUrl;
    /**
     * sortLabel
     */
    @SerializedName("sort_label")
    private String sortLabel;
    /**
     * statistics
     */
    @SerializedName("statistics")
    private AwemeStatisticsStructV2 statistics;
    /**
     * status
     */
    @SerializedName("status")
    private AwemeStatusStructV2 status;
    /**
     * textExtra
     */
    @SerializedName("text_extra")
    private List<TextExtraStructV2> textExtra;
    /**
     * uniqidPosition
     */
    @SerializedName("uniqid_position")
    private List<PositionStructV2> uniqidPosition;
    /**
     * userDigged
     */
    @SerializedName("user_digged")
    private Integer userDigged;
    /**
     * video
     */
    @SerializedName("video")
    private VideoStructV2 video;
    /**
     * videoControl
     */
    @SerializedName("video_control")
    private VideoControlStructV2 videoControl;
    /**
     * videoLabels
     */
    @SerializedName("video_labels")
    private List<AwemeLabelStructV2> videoLabels;
    /**
     * videoText
     */
    @SerializedName("video_text")
    private List<VideoTextStructV2> videoText;
    /**
     * withPromotionalMusic
     */
    @SerializedName("with_promotional_music")
    private Boolean withPromotionalMusic;
    /**
     * withSurvey
     */
    @SerializedName("with_survey")
    private Boolean withSurvey;

    public Boolean getAllowGift() {
        return allowGift;
    }

    public void setAllowGift(Boolean allowGift) {
        this.allowGift = allowGift;
    }

    public List<AnchorCommonStructV2> getAnchors() {
        return anchors;
    }

    public void setAnchors(List<AnchorCommonStructV2> anchors) {
        this.anchors = anchors;
    }

    public String getAnchorsExtras() {
        return anchorsExtras;
    }

    public void setAnchorsExtras(String anchorsExtras) {
        this.anchorsExtras = anchorsExtras;
    }

    public UserStructV2 getAuthor() {
        return author;
    }

    public void setAuthor(UserStructV2 author) {
        this.author = author;
    }

    public AwemeACLStructV2 getAwemeAcl() {
        return awemeAcl;
    }

    public void setAwemeAcl(AwemeACLStructV2 awemeAcl) {
        this.awemeAcl = awemeAcl;
    }

    public String getAwemeId() {
        return awemeId;
    }

    public void setAwemeId(String awemeId) {
        this.awemeId = awemeId;
    }

    public Integer getAwemeType() {
        return awemeType;
    }

    public void setAwemeType(Integer awemeType) {
        this.awemeType = awemeType;
    }

    public Integer getBodydanceScore() {
        return bodydanceScore;
    }

    public void setBodydanceScore(Integer bodydanceScore) {
        this.bodydanceScore = bodydanceScore;
    }

    public List<ChallengeStructV2> getChaList() {
        return chaList;
    }

    public void setChaList(List<ChallengeStructV2> chaList) {
        this.chaList = chaList;
    }

    public Boolean getCmtSwt() {
        return cmtSwt;
    }

    public void setCmtSwt(Boolean cmtSwt) {
        this.cmtSwt = cmtSwt;
    }

    public Integer getCollectStat() {
        return collectStat;
    }

    public void setCollectStat(Integer collectStat) {
        this.collectStat = collectStat;
    }

    public List<CommerceConfigDataV2> getCommerceConfigData() {
        return commerceConfigData;
    }

    public void setCommerceConfigData(List<CommerceConfigDataV2> commerceConfigData) {
        this.commerceConfigData = commerceConfigData;
    }

    public AwemeCommerceStructV2 getCommerceInfo() {
        return commerceInfo;
    }

    public void setCommerceInfo(AwemeCommerceStructV2 commerceInfo) {
        this.commerceInfo = commerceInfo;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescLanguage() {
        return descLanguage;
    }

    public void setDescLanguage(String descLanguage) {
        this.descLanguage = descLanguage;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getDistributeType() {
        return distributeType;
    }

    public void setDistributeType(Integer distributeType) {
        this.distributeType = distributeType;
    }

    public List<String> getGeofencingRegions() {
        return geofencingRegions;
    }

    public void setGeofencingRegions(List<String> geofencingRegions) {
        this.geofencingRegions = geofencingRegions;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getHasVsEntry() {
        return hasVsEntry;
    }

    public void setHasVsEntry(Boolean hasVsEntry) {
        this.hasVsEntry = hasVsEntry;
    }

    public List<HybridLabelStructV2> getHybridLabel() {
        return hybridLabel;
    }

    public void setHybridLabel(List<HybridLabelStructV2> hybridLabel) {
        this.hybridLabel = hybridLabel;
    }

    public List<ImageInfoStructV2> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfoStructV2> imageInfos) {
        this.imageInfos = imageInfos;
    }

    public List<InteractionStickerStructV2> getInteractionStickers() {
        return interactionStickers;
    }

    public void setInteractionStickers(List<InteractionStickerStructV2> interactionStickers) {
        this.interactionStickers = interactionStickers;
    }

    public Boolean getAds() {
        return isAds;
    }

    public void setAds(Boolean ads) {
        isAds = ads;
    }

    public Integer getIsHashTag() {
        return isHashTag;
    }

    public void setIsHashTag(Integer isHashTag) {
        this.isHashTag = isHashTag;
    }

    public Boolean getPgcshow() {
        return isPgcshow;
    }

    public void setPgcshow(Boolean pgcshow) {
        isPgcshow = pgcshow;
    }

    public Boolean getRelieve() {
        return isRelieve;
    }

    public void setRelieve(Boolean relieve) {
        isRelieve = relieve;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Boolean getVr() {
        return isVr;
    }

    public void setVr(Boolean vr) {
        isVr = vr;
    }

    public Integer getItemCommentSettings() {
        return itemCommentSettings;
    }

    public void setItemCommentSettings(Integer itemCommentSettings) {
        this.itemCommentSettings = itemCommentSettings;
    }

    public Integer getItemDuet() {
        return itemDuet;
    }

    public void setItemDuet(Integer itemDuet) {
        this.itemDuet = itemDuet;
    }

    public Integer getItemReact() {
        return itemReact;
    }

    public void setItemReact(Integer itemReact) {
        this.itemReact = itemReact;
    }

    public Integer getItemStitch() {
        return itemStitch;
    }

    public void setItemStitch(Integer itemStitch) {
        this.itemStitch = itemStitch;
    }

    public UrlStructV2 getLabelTop() {
        return labelTop;
    }

    public void setLabelTop(UrlStructV2 labelTop) {
        this.labelTop = labelTop;
    }

    public List<VideoTextStructV2> getLabelTopText() {
        return labelTopText;
    }

    public void setLabelTopText(List<VideoTextStructV2> labelTopText) {
        this.labelTopText = labelTopText;
    }

    public List<LongVideoStructV2> getLongVideo() {
        return longVideo;
    }

    public void setLongVideo(List<LongVideoStructV2> longVideo) {
        this.longVideo = longVideo;
    }

    public List<MaskStructV2> getMaskInfos() {
        return maskInfos;
    }

    public void setMaskInfos(List<MaskStructV2> maskInfos) {
        this.maskInfos = maskInfos;
    }

    public String getMiscInfo() {
        return miscInfo;
    }

    public void setMiscInfo(String miscInfo) {
        this.miscInfo = miscInfo;
    }

    public MusicStructV2 getMusic() {
        return music;
    }

    public void setMusic(MusicStructV2 music) {
        this.music = music;
    }

    public Boolean getNeedVsEntry() {
        return needVsEntry;
    }

    public void setNeedVsEntry(Boolean needVsEntry) {
        this.needVsEntry = needVsEntry;
    }

    public List<PositionStructV2> getNicknamePosition() {
        return nicknamePosition;
    }

    public void setNicknamePosition(List<PositionStructV2> nicknamePosition) {
        this.nicknamePosition = nicknamePosition;
    }

    public List<String> getOriginCommentIds() {
        return originCommentIds;
    }

    public void setOriginCommentIds(List<String> originCommentIds) {
        this.originCommentIds = originCommentIds;
    }

    public List<PositionStructV2> getPosition() {
        return position;
    }

    public void setPosition(List<PositionStructV2> position) {
        this.position = position;
    }

    public PreloadStructV2 getPreload() {
        return preload;
    }

    public void setPreload(PreloadStructV2 preload) {
        this.preload = preload;
    }

    public Boolean getPreventDownload() {
        return preventDownload;
    }

    public void setPreventDownload(Boolean preventDownload) {
        this.preventDownload = preventDownload;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public AwemeRiskStructV2 getRiskInfos() {
        return riskInfos;
    }

    public void setRiskInfos(AwemeRiskStructV2 riskInfos) {
        this.riskInfos = riskInfos;
    }

    public ShareStructV2 getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(ShareStructV2 shareInfo) {
        this.shareInfo = shareInfo;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getSortLabel() {
        return sortLabel;
    }

    public void setSortLabel(String sortLabel) {
        this.sortLabel = sortLabel;
    }

    public AwemeStatisticsStructV2 getStatistics() {
        return statistics;
    }

    public void setStatistics(AwemeStatisticsStructV2 statistics) {
        this.statistics = statistics;
    }

    public AwemeStatusStructV2 getStatus() {
        return status;
    }

    public void setStatus(AwemeStatusStructV2 status) {
        this.status = status;
    }

    public List<TextExtraStructV2> getTextExtra() {
        return textExtra;
    }

    public void setTextExtra(List<TextExtraStructV2> textExtra) {
        this.textExtra = textExtra;
    }

    public List<PositionStructV2> getUniqidPosition() {
        return uniqidPosition;
    }

    public void setUniqidPosition(List<PositionStructV2> uniqidPosition) {
        this.uniqidPosition = uniqidPosition;
    }

    public Integer getUserDigged() {
        return userDigged;
    }

    public void setUserDigged(Integer userDigged) {
        this.userDigged = userDigged;
    }

    public VideoStructV2 getVideo() {
        return video;
    }

    public void setVideo(VideoStructV2 video) {
        this.video = video;
    }

    public VideoControlStructV2 getVideoControl() {
        return videoControl;
    }

    public void setVideoControl(VideoControlStructV2 videoControl) {
        this.videoControl = videoControl;
    }

    public List<AwemeLabelStructV2> getVideoLabels() {
        return videoLabels;
    }

    public void setVideoLabels(List<AwemeLabelStructV2> videoLabels) {
        this.videoLabels = videoLabels;
    }

    public List<VideoTextStructV2> getVideoText() {
        return videoText;
    }

    public void setVideoText(List<VideoTextStructV2> videoText) {
        this.videoText = videoText;
    }

    public Boolean getWithPromotionalMusic() {
        return withPromotionalMusic;
    }

    public void setWithPromotionalMusic(Boolean withPromotionalMusic) {
        this.withPromotionalMusic = withPromotionalMusic;
    }

    public Boolean getWithSurvey() {
        return withSurvey;
    }

    public void setWithSurvey(Boolean withSurvey) {
        this.withSurvey = withSurvey;
    }
}
