package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "icon": {},
 *     "schema": "",
 *     "action_type": 3
 * }
 */
public class AnchorPanelActionStructV2 {

    /**
     * icon
     */
    @SerializedName("icon")
    private UrlStructV2 icon;
    /**
     * schema
     */
    @SerializedName("schema")
    private String schema;
    /**
     * actionType
     */
    @SerializedName("action_type")
    private Integer actionType;

    public UrlStructV2 getIcon() {
        return icon;
    }

    public void setIcon(UrlStructV2 icon) {
        this.icon = icon;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }
}
