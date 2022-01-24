package com.more.crawlerhooking.http.beans.tiktok.aweme;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {
 *     "uri": "1",
 *     "url_list": [],
 *     "width": 3,
 *     "height": 4,
 *     "url_key": "5",
 *     "data_size": 6,
 *     "file_hash": 7,
 *     "file_cs": 8,
 *     "player_access_key": "9"
 * }
 */
public class UrlStructV2 {

    /**
     * uri
     */
    @SerializedName("uri")
    private String uri;
    /**
     * urlList
     */
    @SerializedName("url_list")
    private List<String> urlList;
    /**
     * width
     */
    @SerializedName("width")
    private Integer width;
    /**
     * height
     */
    @SerializedName("height")
    private Integer height;
    /**
     * urlKey
     */
    @SerializedName("url_key")
    private String urlKey;
    /**
     * dataSize
     */
    @SerializedName("data_size")
    private Integer dataSize;
    /**
     * fileHash
     */
    @SerializedName("file_hash")
    private String fileHash;
    /**
     * fileCs
     */
    @SerializedName("file_cs")
    private String fileCs;
    /**
     * playerAccessKey
     */
    @SerializedName("player_access_key")
    private String playerAccessKey;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public Integer getDataSize() {
        return dataSize;
    }

    public void setDataSize(Integer dataSize) {
        this.dataSize = dataSize;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String getFileCs() {
        return fileCs;
    }

    public void setFileCs(String fileCs) {
        this.fileCs = fileCs;
    }

    public String getPlayerAccessKey() {
        return playerAccessKey;
    }

    public void setPlayerAccessKey(String playerAccessKey) {
        this.playerAccessKey = playerAccessKey;
    }
}
