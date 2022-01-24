package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "author": "찬열 (CHANYEOL) & 펀치 (Punch)",
 *     "cover_medium": {
 *         "height": 720,
 *         "uri": "tos-alisg-v-2774/9d438739952f4c4e84a542a628545643",
 *         "url_list": ["https://p16-sg.tiktokcdn.com/aweme/200x200/tos-alisg-v-2774/9d438739952f4c4e84a542a628545643.jpeg"],
 *         "width": 720
 *     },
 *     "h5_url": "",
 *     "id": "6913678135750592513",
 *     "title": "Stay With Me"
 * }
 */
public class MatchedSongStructV2 {

    /**
     * author
     */
    @SerializedName("author")
    private String author;
    /**
     * coverMedium
     */
    @SerializedName("cover_medium")
    private UrlStructV2 coverMedium;
    /**
     * h5Url
     */
    @SerializedName("h5_url")
    private String h5Url;
    /**
     * id
     */
    @SerializedName("id")
    private String id;
    /**
     * title
     */
    @SerializedName("title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public UrlStructV2 getCoverMedium() {
        return coverMedium;
    }

    public void setCoverMedium(UrlStructV2 coverMedium) {
        this.coverMedium = coverMedium;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
