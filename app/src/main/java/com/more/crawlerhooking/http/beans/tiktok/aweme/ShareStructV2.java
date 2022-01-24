package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "bool_persist": 0,
 *     "share_desc": "Check out Beautiful earth 🌍's video! #TikTok",
 *     "share_desc_info": "TikTok: Make Every Second CountCheck out Beautiful earth 🌍\u2019s video! #TikTok > ",
 *     "share_link_desc": "",
 *     "share_quote": "",
 *     "share_qrcode_url": {},
 *     "manage_goods_url": "",
 *     "share_image_url": {},
 *     "share_signature_desc": "",
 *     "share_signature_url": "",
 *     "share_title": "Check out Beautiful earth 🌍\u2019s video! #TikTok > ",
 *     "share_title_myself": "",
 *     "share_title_other": "",
 *     "share_url": "https://m.tiktok.com/v/7041789688750968111.html?u_code=dk9548a7kcaf26&preview_pb=0&language=fr&_d=dlmke57320dfch&share_item_id=7041789688750968111&source=h5_m",
 *     "whatsapp_desc": "Download TikTok and watch more fun videos:"
 * }
 */
public class ShareStructV2 {

    /**
     * boolPersist
     */
    @SerializedName("bool_persist")
    private Integer boolPersist;
    /**
     * shareDesc
     */
    @SerializedName("share_desc")
    private String shareDesc;
    /**
     * shareDescInfo
     */
    @SerializedName("share_desc_info")
    private String shareDescInfo;
    /**
     * shareLinkDesc
     */
    @SerializedName("share_link_desc")
    private String shareLinkDesc;
    /**
     * shareQuote
     */
    @SerializedName("share_quote")
    private String shareQuote;
    /**
     * shareQrcodeUrl
     */
    @SerializedName("share_qrcode_url")
    private UrlStructV2 shareQrcodeUrl;
    /**
     * manageGoodsUrl
     */
    @SerializedName("manage_goods_url")
    private String manageGoodsUrl;
    /**
     * shareImageUrl
     */
    @SerializedName("share_image_url")
    private UrlStructV2 shareImageUrl;
    /**
     * shareSignatureDesc
     */
    @SerializedName("share_signature_desc")
    private String shareSignatureDesc;
    /**
     * shareSignatureUrl
     */
    @SerializedName("share_signature_url")
    private String shareSignatureUrl;
    /**
     * shareTitle
     */
    @SerializedName("share_title")
    private String shareTitle;
    /**
     * shareTitleMyself
     */
    @SerializedName("share_title_myself")
    private String shareTitleMyself;
    /**
     * shareTitleOther
     */
    @SerializedName("share_title_other")
    private String shareTitleOther;
    /**
     * shareUrl
     */
    @SerializedName("share_url")
    private String shareUrl;
    /**
     * whatsappDesc
     */
    @SerializedName("whatsapp_desc")
    private String whatsappDesc;

    public Integer getBoolPersist() {
        return boolPersist;
    }

    public void setBoolPersist(Integer boolPersist) {
        this.boolPersist = boolPersist;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    public String getShareDescInfo() {
        return shareDescInfo;
    }

    public void setShareDescInfo(String shareDescInfo) {
        this.shareDescInfo = shareDescInfo;
    }

    public String getShareLinkDesc() {
        return shareLinkDesc;
    }

    public void setShareLinkDesc(String shareLinkDesc) {
        this.shareLinkDesc = shareLinkDesc;
    }

    public String getShareQuote() {
        return shareQuote;
    }

    public void setShareQuote(String shareQuote) {
        this.shareQuote = shareQuote;
    }

    public UrlStructV2 getShareQrcodeUrl() {
        return shareQrcodeUrl;
    }

    public void setShareQrcodeUrl(UrlStructV2 shareQrcodeUrl) {
        this.shareQrcodeUrl = shareQrcodeUrl;
    }

    public String getManageGoodsUrl() {
        return manageGoodsUrl;
    }

    public void setManageGoodsUrl(String manageGoodsUrl) {
        this.manageGoodsUrl = manageGoodsUrl;
    }

    public UrlStructV2 getShareImageUrl() {
        return shareImageUrl;
    }

    public void setShareImageUrl(UrlStructV2 shareImageUrl) {
        this.shareImageUrl = shareImageUrl;
    }

    public String getShareSignatureDesc() {
        return shareSignatureDesc;
    }

    public void setShareSignatureDesc(String shareSignatureDesc) {
        this.shareSignatureDesc = shareSignatureDesc;
    }

    public String getShareSignatureUrl() {
        return shareSignatureUrl;
    }

    public void setShareSignatureUrl(String shareSignatureUrl) {
        this.shareSignatureUrl = shareSignatureUrl;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareTitleMyself() {
        return shareTitleMyself;
    }

    public void setShareTitleMyself(String shareTitleMyself) {
        this.shareTitleMyself = shareTitleMyself;
    }

    public String getShareTitleOther() {
        return shareTitleOther;
    }

    public void setShareTitleOther(String shareTitleOther) {
        this.shareTitleOther = shareTitleOther;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getWhatsappDesc() {
        return whatsappDesc;
    }

    public void setWhatsappDesc(String whatsappDesc) {
        this.whatsappDesc = whatsappDesc;
    }
}
