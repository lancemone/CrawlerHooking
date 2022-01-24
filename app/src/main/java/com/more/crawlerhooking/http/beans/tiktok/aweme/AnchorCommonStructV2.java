package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {
 *     "keyword": "1",
 *     "url": "2",
 *     "language": "3",
 *     "schema": "4",
 *     "id": "5",
 *     "type": 6,
 *     "icon": {},
 *     "extra": "8",
 *     "deep_link": "9",
 *     "universal_link": "10",
 *     "general_type": 11,
 *     "log_extra": "12",
 *     "description": "13",
 *     "thumbnail": {},
 *     "actions": {}
 * }
 */
public class AnchorCommonStructV2 {

    /**
     * keyword
     */
    @SerializedName("keyword")
    private String keyword;
    /**
     * url
     */
    @SerializedName("url")
    private String url;
    /**
     * language
     */
    @SerializedName("language")
    private String language;
    /**
     * schema
     */
    @SerializedName("schema")
    private String schema;
    /**
     * id
     */
    @SerializedName("id")
    private String id;
    /**
     * type
     */
    @SerializedName("type")
    private Integer type;
    /**
     * icon
     */
    @SerializedName("icon")
    private UrlStructV2 icon;
    /**
     * extra
     */
    @SerializedName("extra")
    private String extra;
    /**
     * deepLink
     */
    @SerializedName("deep_link")
    private String deepLink;
    /**
     * universalLink
     */
    @SerializedName("universal_link")
    private String universalLink;
    /**
     * generalType
     */
    @SerializedName("general_type")
    private Integer generalType;
    /**
     * logExtra
     */
    @SerializedName("log_extra")
    private String logExtra;
    /**
     * description
     */
    @SerializedName("description")
    private String description;
    /**
     * thumbnail
     */
    @SerializedName("thumbnail")
    private UrlStructV2 thumbnail;
    /**
     * actions
     */
    @SerializedName("actions")
    private List<AnchorPanelActionStructV2> actions;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public UrlStructV2 getIcon() {
        return icon;
    }

    public void setIcon(UrlStructV2 icon) {
        this.icon = icon;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public String getUniversalLink() {
        return universalLink;
    }

    public void setUniversalLink(String universalLink) {
        this.universalLink = universalLink;
    }

    public Integer getGeneralType() {
        return generalType;
    }

    public void setGeneralType(Integer generalType) {
        this.generalType = generalType;
    }

    public String getLogExtra() {
        return logExtra;
    }

    public void setLogExtra(String logExtra) {
        this.logExtra = logExtra;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UrlStructV2 getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(UrlStructV2 thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<AnchorPanelActionStructV2> getActions() {
        return actions;
    }

    public void setActions(List<AnchorPanelActionStructV2> actions) {
        this.actions = actions;
    }
}
