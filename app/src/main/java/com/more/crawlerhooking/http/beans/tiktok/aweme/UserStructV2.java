package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {
 *         "ad_cover_url": [],
 *         "authority_status": 0,
 *         "avatar_168x168": {
 *             "height": 720,
 *             "uri": "tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982",
 *             "url_list": [
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_168x168.webp?x-expires=1641448800&x-signature=1IUU2HTIskAYn9gJHVQh9vRfRd4%3D",
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_168x168.jpeg?x-expires=1641448800&x-signature=w4pZl6ksw%2Fd1Dt5etdY4yyekV5w%3D"
 *             ],
 *             "width": 720
 *         },
 *         "avatar_300x300": {
 *             "height": 720,
 *             "uri": "tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982",
 *             "url_list": [
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_300x300.webp?x-expires=1641448800&x-signature=i3L2SFIKMubzveqHwt3bYUZz4FM%3D",
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_300x300.jpeg?x-expires=1641448800&x-signature=D7YFw%2FtFn89l%2BoYytEzUFl6u2i4%3D"
 *             ],
 *             "width": 720
 *         },
 *         "avatar_medium": {
 *             "height": 720,
 *             "uri": "tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982",
 *             "url_list": [
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.webp?x-expires=1641448800&x-signature=%2Bx5eNBfduVFh6soBcomjU1SnccU%3D",
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_720x720.jpeg?x-expires=1641448800&x-signature=LeXf0J3iILFx7JrLrcJxuT3uzwo%3D"
 *             ],
 *             "width": 720
 *         },
 *         "avatar_thumb": {
 *             "height": 720,
 *             "uri": "tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982",
 *             "url_list": [
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.webp?x-expires=1641448800&x-signature=dWRCdGMA9f4RsaB%2BjLyRaKgwDSE%3D",
 *                 "https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/89497e4eff2a81200d0309ef252b9982~c5_100x100.jpeg?x-expires=1641448800&x-signature=TV9hVUkovYkIuXb9zIlflkNozrs%3D"
 *             ],
 *             "width": 720
 *         },
 *         "cha_list": [],
 *         "comment_filter_status": 0,
 *         "comment_setting": 0,
 *         "commerce_user_level": 0,
 *         "cover_url": [{
 *             "height": 720,
 *             "uri": "tiktok-obj/1613727517271041",
 *             "url_list": ["https://p16-sg.tiktokcdn.com/obj/tiktok-obj/1613727517271041"],
 *             "width": 720
 *         }],
 *         "custom_verify": "",
 *         "download_setting": 0,
 *         "duet_setting": 0,
 *         "follow_status": 0,
 *         "follower_status": 0,
 *         "followers_detail": [],
 *         "is_ad_fake": false,
 *         "is_block": false,
 *         "is_discipline_member": false,
 *         "is_star": false,
 *         "item_list": [],
 *         "language": "en",
 *         "nickname": "Beautiful earth 🌍",
 *         "platform_sync_info": [],
 *         "prevent_download": false,
 *         "region": "US",
 *         "relative_users": [],
 *         "room_id": 0,
 *         "sec_uid": "MS4wLjABAAAAKPzCmXcAuIN2YPy4zrld3H2CSI4HZDU9Pa3fMP85Rya5U8NjktFu9NPJWaOP_4MZ",
 *         "secret": 0,
 *         "share_info": {
 *             "share_desc": "",
 *             "share_desc_info": "",
 *             "share_qrcode_url": {
 *                 "height": 720,
 *                 "uri": "",
 *                 "url_list": [],
 *                 "width": 720
 *             },
 *             "share_title": "",
 *             "share_title_myself": "",
 *             "share_title_other": "",
 *             "share_url": ""
 *         },
 *         "short_id": "0",
 *         "signature": "🎶Thank you for your attention🎶\n🥰Enjoy the beauty of nature with you🥰",
 *         "type_label": [],
 *         "uid": "6938933427820430341",
 *         "unique_id": "zyb231024",
 *         "verification_type": 1,
 *         "verify_info": "",
 *         "video_icon": {
 *             "height": 720,
 *             "uri": "",
 *             "url_list": [],
 *             "width": 720
 *         },
 *         "with_commerce_entry": false
 *     }
 */
public class UserStructV2 {

    /**
     * adCoverUrl
     */
    @SerializedName("ad_cover_url")
    private List<UrlStructV2> adCoverUrl;
    /**
     * authorityStatus
     */
    @SerializedName("authority_status")
    private Integer authorityStatus;
    /**
     * avatar168x168
     */
    @SerializedName("avatar_168x168")
    private UrlStructV2 avatar168x168;
    /**
     * avatar300x300
     */
    @SerializedName("avatar_300x300")
    private UrlStructV2 avatar300x300;
    /**
     * avatarMedium
     */
    @SerializedName("avatar_medium")
    private UrlStructV2 avatarMedium;
    /**
     * avatarThumb
     */
    @SerializedName("avatar_thumb")
    private UrlStructV2 avatarThumb;
    /**
     * chaList
     */
    @SerializedName("cha_list")
    private List<ChallengeStructV2> chaList;
    /**
     * commentFilterStatus
     */
    @SerializedName("comment_filter_status")
    private Integer commentFilterStatus;
    /**
     * commentSetting
     */
    @SerializedName("comment_setting")
    private Integer commentSetting;
    /**
     * commerceUserLevel
     */
    @SerializedName("commerce_user_level")
    private Integer commerceUserLevel;
    /**
     * coverUrl
     */
    @SerializedName("cover_url")
    private List<UrlStructV2> coverUrl;
    /**
     * customVerify
     */
    @SerializedName("custom_verify")
    private String customVerify;
    /**
     * downloadSetting
     */
    @SerializedName("download_setting")
    private Integer downloadSetting;
    /**
     * duetSetting
     */
    @SerializedName("duet_setting")
    private Integer duetSetting;
    /**
     * followStatus
     */
    @SerializedName("follow_status")
    private Integer followStatus;
    /**
     * followerStatus
     */
    @SerializedName("follower_status")
    private Integer followerStatus;
    /**
     * followersDetail
     */
    @SerializedName("followers_detail")
    private List<FollowersDetailV2> followersDetail;
    /**
     * isAdFake
     */
    @SerializedName("is_ad_fake")
    private Boolean isAdFake;
    /**
     * isBlock
     */
    @SerializedName("is_block")
    private Boolean isBlock;
    /**
     * isDisciplineMember
     */
    @SerializedName("is_discipline_member")
    private Boolean isDisciplineMember;
    /**
     * isStar
     */
    @SerializedName("is_star")
    private Boolean isStar;
    /**
     * itemList
     */
    @SerializedName("item_list")
    private List<RecommendItemStructV2> itemList;
    /**
     * language
     */
    @SerializedName("language")
    private String language;
    /**
     * nickname
     */
    @SerializedName("nickname")
    private String nickname;
    /**
     * platformSyncInfo
     */
    @SerializedName("platform_sync_info")
    private List<PlatformSyncStatusStructV2> platformSyncInfo;
    /**
     * preventDownload
     */
    @SerializedName("prevent_download")
    private Boolean preventDownload;
    /**
     * region
     */
    @SerializedName("region")
    private String region;
    /**
     * relativeUsers
     */
    @SerializedName("relative_users")
    private List<RelativeUserStructV2> relativeUsers;
    /**
     * roomId
     */
    @SerializedName("room_id")
    private double roomId;
    /**
     * secUid
     */
    @SerializedName("sec_uid")
    private String secUid;
    /**
     * secret
     */
    @SerializedName("secret")
    private Integer secret;
    /**
     * shareInfo
     */
    @SerializedName("share_info")
    private ShareStructV2 shareInfo;
    /**
     * shortId
     */
    @SerializedName("short_id")
    private String shortId;
    /**
     * signature
     */
    @SerializedName("signature")
    private String signature;
    /**
     * typeLabel
     */
    @SerializedName("type_label")
    private List<Integer> typeLabel;
    /**
     * uid
     */
    @SerializedName("uid")
    private String uid;
    /**
     * uniqueId
     */
    @SerializedName("unique_id")
    private String uniqueId;
    /**
     * verificationType
     */
    @SerializedName("verification_type")
    private Integer verificationType;
    /**
     * verifyInfo
     */
    @SerializedName("verify_info")
    private String verifyInfo;
    /**
     * videoIcon
     */
    @SerializedName("video_icon")
    private UrlStructV2 videoIcon;
    /**
     * withCommerceEntry
     */
    @SerializedName("with_commerce_entry")
    private Boolean withCommerceEntry;

    public List<UrlStructV2> getAdCoverUrl() {
        return adCoverUrl;
    }

    public void setAdCoverUrl(List<UrlStructV2> adCoverUrl) {
        this.adCoverUrl = adCoverUrl;
    }

    public Integer getAuthorityStatus() {
        return authorityStatus;
    }

    public void setAuthorityStatus(Integer authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

    public UrlStructV2 getAvatar168x168() {
        return avatar168x168;
    }

    public void setAvatar168x168(UrlStructV2 avatar168x168) {
        this.avatar168x168 = avatar168x168;
    }

    public UrlStructV2 getAvatar300x300() {
        return avatar300x300;
    }

    public void setAvatar300x300(UrlStructV2 avatar300x300) {
        this.avatar300x300 = avatar300x300;
    }

    public UrlStructV2 getAvatarMedium() {
        return avatarMedium;
    }

    public void setAvatarMedium(UrlStructV2 avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public UrlStructV2 getAvatarThumb() {
        return avatarThumb;
    }

    public void setAvatarThumb(UrlStructV2 avatarThumb) {
        this.avatarThumb = avatarThumb;
    }

    public List<ChallengeStructV2> getChaList() {
        return chaList;
    }

    public void setChaList(List<ChallengeStructV2> chaList) {
        this.chaList = chaList;
    }

    public Integer getCommentFilterStatus() {
        return commentFilterStatus;
    }

    public void setCommentFilterStatus(Integer commentFilterStatus) {
        this.commentFilterStatus = commentFilterStatus;
    }

    public Integer getCommentSetting() {
        return commentSetting;
    }

    public void setCommentSetting(Integer commentSetting) {
        this.commentSetting = commentSetting;
    }

    public Integer getCommerceUserLevel() {
        return commerceUserLevel;
    }

    public void setCommerceUserLevel(Integer commerceUserLevel) {
        this.commerceUserLevel = commerceUserLevel;
    }

    public List<UrlStructV2> getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(List<UrlStructV2> coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCustomVerify() {
        return customVerify;
    }

    public void setCustomVerify(String customVerify) {
        this.customVerify = customVerify;
    }

    public Integer getDownloadSetting() {
        return downloadSetting;
    }

    public void setDownloadSetting(Integer downloadSetting) {
        this.downloadSetting = downloadSetting;
    }

    public Integer getDuetSetting() {
        return duetSetting;
    }

    public void setDuetSetting(Integer duetSetting) {
        this.duetSetting = duetSetting;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    public Integer getFollowerStatus() {
        return followerStatus;
    }

    public void setFollowerStatus(Integer followerStatus) {
        this.followerStatus = followerStatus;
    }

    public List<FollowersDetailV2> getFollowersDetail() {
        return followersDetail;
    }

    public void setFollowersDetail(List<FollowersDetailV2> followersDetail) {
        this.followersDetail = followersDetail;
    }

    public Boolean getAdFake() {
        return isAdFake;
    }

    public void setAdFake(Boolean adFake) {
        isAdFake = adFake;
    }

    public Boolean getBlock() {
        return isBlock;
    }

    public void setBlock(Boolean block) {
        isBlock = block;
    }

    public Boolean getDisciplineMember() {
        return isDisciplineMember;
    }

    public void setDisciplineMember(Boolean disciplineMember) {
        isDisciplineMember = disciplineMember;
    }

    public Boolean getStar() {
        return isStar;
    }

    public void setStar(Boolean star) {
        isStar = star;
    }

    public List<RecommendItemStructV2> getItemList() {
        return itemList;
    }

    public void setItemList(List<RecommendItemStructV2> itemList) {
        this.itemList = itemList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<PlatformSyncStatusStructV2> getPlatformSyncInfo() {
        return platformSyncInfo;
    }

    public void setPlatformSyncInfo(List<PlatformSyncStatusStructV2> platformSyncInfo) {
        this.platformSyncInfo = platformSyncInfo;
    }

    public Boolean getPreventDownload() {
        return preventDownload;
    }

    public void setPreventDownload(Boolean preventDownload) {
        this.preventDownload = preventDownload;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<RelativeUserStructV2> getRelativeUsers() {
        return relativeUsers;
    }

    public void setRelativeUsers(List<RelativeUserStructV2> relativeUsers) {
        this.relativeUsers = relativeUsers;
    }

    public double getRoomId() {
        return roomId;
    }

    public void setRoomId(double roomId) {
        this.roomId = roomId;
    }

    public String getSecUid() {
        return secUid;
    }

    public void setSecUid(String secUid) {
        this.secUid = secUid;
    }

    public Integer getSecret() {
        return secret;
    }

    public void setSecret(Integer secret) {
        this.secret = secret;
    }

    public ShareStructV2 getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(ShareStructV2 shareInfo) {
        this.shareInfo = shareInfo;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<Integer> getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(List<Integer> typeLabel) {
        this.typeLabel = typeLabel;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(Integer verificationType) {
        this.verificationType = verificationType;
    }

    public String getVerifyInfo() {
        return verifyInfo;
    }

    public void setVerifyInfo(String verifyInfo) {
        this.verifyInfo = verifyInfo;
    }

    public UrlStructV2 getVideoIcon() {
        return videoIcon;
    }

    public void setVideoIcon(UrlStructV2 videoIcon) {
        this.videoIcon = videoIcon;
    }

    public Boolean getWithCommerceEntry() {
        return withCommerceEntry;
    }

    public void setWithCommerceEntry(Boolean withCommerceEntry) {
        this.withCommerceEntry = withCommerceEntry;
    }
}
