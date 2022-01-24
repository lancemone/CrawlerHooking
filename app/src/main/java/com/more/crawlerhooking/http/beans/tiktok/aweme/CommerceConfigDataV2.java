package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

public class CommerceConfigDataV2 {

    /**
     * type
     */
    @SerializedName("type")
    private Integer type;
    /**
     * priority
     */
    @SerializedName("priority")
    private Integer priority;
    /**
     * itemLikeEgg
     */
    @SerializedName("item_like_egg")
    private ItemLikeEggStructV2 itemLikeEgg;
    /**
     * stickerPendant
     */
    @SerializedName("sticker_pendant")
    private StickerPendantStructV2 stickerPendant;
    /**
     * data
     */
    @SerializedName("data")
    private String data;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public ItemLikeEggStructV2 getItemLikeEgg() {
        return itemLikeEgg;
    }

    public void setItemLikeEgg(ItemLikeEggStructV2 itemLikeEgg) {
        this.itemLikeEgg = itemLikeEgg;
    }

    public StickerPendantStructV2 getStickerPendant() {
        return stickerPendant;
    }

    public void setStickerPendant(StickerPendantStructV2 stickerPendant) {
        this.stickerPendant = stickerPendant;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
