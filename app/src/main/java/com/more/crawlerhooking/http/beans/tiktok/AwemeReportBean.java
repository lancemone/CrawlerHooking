package com.more.crawlerhooking.http.beans.tiktok;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AwemeReportBean {
    /**
     * source
     */
    @SerializedName("source")
    private String source;
    /**
     * reportData
     */
    @SerializedName("report_data")
    private ReportDataBean reportData;
    /**
     * hashCode
     */
    @SerializedName("hash_code")
    private Integer hashCode;

    public AwemeReportBean(){}

    public AwemeReportBean(ReportDataBean reportData, Integer hashCode){
        this.source = "tt";
        this.reportData = reportData;
        this.hashCode = hashCode;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ReportDataBean getReportData() {
        return reportData;
    }

    public void setReportData(ReportDataBean reportData) {
        this.reportData = reportData;
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
    }

    public static class ReportDataBean {
        /**
         * deviceId
         */
        @SerializedName("device_id")
        private String deviceId;
        /**
         * awemeId
         */
        @SerializedName("aweme_id")
        private String awemeId;

        @SerializedName("task_turn")
        private String taskTurn;

        /**
         * deviceCountry
         */
        @SerializedName("device_country")
        private String deviceCountry;
        /**
         * foryou
         */
        @SerializedName("foryou")
        private Integer foryou;
        /**
         * originData
         */
        @SerializedName("origin_data")
        private OriginDataBean originData;

        public ReportDataBean(){}

        public ReportDataBean(String deviceId, String awemeId, String taskTurn, String deviceCountry, Integer foryou, OriginDataBean originData){
            this.deviceId = deviceId;
            this.awemeId = awemeId;
            this.taskTurn = taskTurn;
            this.deviceCountry = deviceCountry;
            this.foryou = foryou;
            this.originData = originData;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getAwemeId() {
            return awemeId;
        }

        public void setAwemeId(String awemeId) {
            this.awemeId = awemeId;
        }

        public String getDeviceCountry() {
            return deviceCountry;
        }

        public void setDeviceCountry(String deviceCountry) {
            this.deviceCountry = deviceCountry;
        }

        public Integer getForyou() {
            return foryou;
        }

        public void setForyou(Integer foryou) {
            this.foryou = foryou;
        }

        public OriginDataBean getOriginData() {
            return originData;
        }

        public void setOriginData(OriginDataBean originData) {
            this.originData = originData;
        }

        public static class OriginDataBean {
            /**
             * awemeId
             */
            @SerializedName("aweme_id")
            private String awemeId;

            @SerializedName("desc")
            private String desc;

            @SerializedName("create_time")
            private long createTime;

            /**
             * author
             */
            @SerializedName("author")
            private AuthorBean author;
            /**
             * video
             */
            @SerializedName("video")
            private VideoBean video;
            /**
             * statistics
             */
            @SerializedName("statistics")
            private StatisticsBean statistics;
            /**
             * descLanguage
             */
            @SerializedName("desc_language")
            private String descLanguage;
            /**
             * region
             */
            @SerializedName("region")
            private String region;

            public OriginDataBean(){}

            public OriginDataBean(String awemeId, String desc, long createTime, String descLanguage, String region, AuthorBean author, VideoBean videoBean, StatisticsBean statistics){
                this.awemeId = awemeId;
                this.desc = desc;
                this.createTime = createTime;
                this.descLanguage = descLanguage;
                this.region = region;
                this.author = author;
                this.video = videoBean;
                this.statistics = statistics;
            }

            public String getAwemeId() {
                return awemeId;
            }

            public void setAwemeId(String awemeId) {
                this.awemeId = awemeId;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public StatisticsBean getStatistics() {
                return statistics;
            }

            public void setStatistics(StatisticsBean statistics) {
                this.statistics = statistics;
            }

            public String getDescLanguage() {
                return descLanguage;
            }

            public void setDescLanguage(String descLanguage) {
                this.descLanguage = descLanguage;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public static class AuthorBean {
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
                 * secUid
                 */
                @SerializedName("sec_uid")
                private String secUid;
                /**
                 * language
                 */
                @SerializedName("language")
                private String language;
                /**
                 * region
                 */
                @SerializedName("region")
                private String region;

                public AuthorBean(){}

                public AuthorBean(String uid, String uniqueId, String secUid, String language, String region){
                    this.uid = uid;
                    this.uniqueId = uniqueId;
                    this.secUid = secUid;
                    this.language = language;
                    this.region = region;
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

                public String getSecUid() {
                    return secUid;
                }

                public void setSecUid(String secUid) {
                    this.secUid = secUid;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public String getRegion() {
                    return region;
                }

                public void setRegion(String region) {
                    this.region = region;
                }
            }

            public static class VideoBean {
                /**
                 * duration
                 */
                @SerializedName("duration")
                private Integer duration;
                /**
                 * height
                 */
                @SerializedName("height")
                private Integer height;
                /**
                 * width
                 */
                @SerializedName("width")
                private Integer width;
                /**
                 * playAddr
                 */
                @SerializedName("play_addr")
                private PlayAddrBean playAddr;
                /**
                 * cover
                 */
                @SerializedName("cover")
                private CoverBean cover;

                public VideoBean(){}

                public VideoBean(int duration, int height, int width, PlayAddrBean playAddr, CoverBean cover){
                    this.duration = duration;
                    this.height = height;
                    this.width = width;
                    this.playAddr = playAddr;
                    this.cover = cover;
                }

                public Integer getDuration() {
                    return duration;
                }

                public void setDuration(Integer duration) {
                    this.duration = duration;
                }

                public Integer getHeight() {
                    return height;
                }

                public void setHeight(Integer height) {
                    this.height = height;
                }

                public Integer getWidth() {
                    return width;
                }

                public void setWidth(Integer width) {
                    this.width = width;
                }

                public PlayAddrBean getPlayAddr() {
                    return playAddr;
                }

                public void setPlayAddr(PlayAddrBean playAddr) {
                    this.playAddr = playAddr;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public static class PlayAddrBean {
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

                    public PlayAddrBean(){}

                    public PlayAddrBean(String uri, List<String> urlList){
                        this.uri = uri;
                        this.urlList = urlList;
                    }

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
                }

                public static class CoverBean {
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

                    public CoverBean(){}

                    public CoverBean(String uri, List<String> urlList, int width, int height){
                        this.uri = uri;
                        this.urlList = urlList;
                        this.width = width;
                        this.height = height;
                    }

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
                }
            }

            public static class StatisticsBean {
                /**
                 * awemeId
                 */
                @SerializedName("aweme_id")
                private String awemeId;
                /**
                 * commentCount
                 */
                @SerializedName("comment_count")
                private long commentCount;
                /**
                 * diggCount
                 */
                @SerializedName("digg_count")
                private long diggCount;
                /**
                 * downloadCount
                 */
                @SerializedName("download_count")
                private long downloadCount;
                /**
                 * playCount
                 */
                @SerializedName("play_count")
                private long playCount;
                /**
                 * shareCount
                 */
                @SerializedName("share_count")
                private long shareCount;
                /**
                 * forwardCount
                 */
                @SerializedName("forward_count")
                private long forwardCount;
                /**
                 * loseCount
                 */
                @SerializedName("lose_count")
                private int loseCount;
                /**
                 * loseCommentCount
                 */
                @SerializedName("lose_comment_count")
                private int loseCommentCount;
                /**
                 * whatsappShareCount
                 */
                @SerializedName("whatsapp_share_count")
                private int whatsappShareCount;

                public StatisticsBean(){}

                public StatisticsBean(String awemeId, long commentCount, long diggCount,
                                      long downloadCount, long playCount, long shareCount, long forwardCount,
                                      int loseCount, int loseCommentCount){
                    this.awemeId = awemeId;
                    this.commentCount = commentCount;
                    this.diggCount = diggCount;
                    this.downloadCount = downloadCount;
                    this.playCount = playCount;
                    this.shareCount = shareCount;
                    this.forwardCount = forwardCount;
                    this.loseCount = loseCount;
                    this.loseCommentCount = loseCommentCount;
                    this.whatsappShareCount = 0;
                }

                public String getAwemeId() {
                    return awemeId;
                }

                public void setAwemeId(String awemeId) {
                    this.awemeId = awemeId;
                }

                public long getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(long commentCount) {
                    this.commentCount = commentCount;
                }

                public long getDiggCount() {
                    return diggCount;
                }

                public void setDiggCount(long diggCount) {
                    this.diggCount = diggCount;
                }

                public long getDownloadCount() {
                    return downloadCount;
                }

                public void setDownloadCount(long downloadCount) {
                    this.downloadCount = downloadCount;
                }

                public long getPlayCount() {
                    return playCount;
                }

                public void setPlayCount(long playCount) {
                    this.playCount = playCount;
                }

                public long getShareCount() {
                    return shareCount;
                }

                public void setShareCount(long shareCount) {
                    this.shareCount = shareCount;
                }

                public long getForwardCount() {
                    return forwardCount;
                }

                public void setForwardCount(long forwardCount) {
                    this.forwardCount = forwardCount;
                }

                public Integer getLoseCount() {
                    return loseCount;
                }

                public void setLoseCount(Integer loseCount) {
                    this.loseCount = loseCount;
                }

                public Integer getLoseCommentCount() {
                    return loseCommentCount;
                }

                public void setLoseCommentCount(Integer loseCommentCount) {
                    this.loseCommentCount = loseCommentCount;
                }

                public Integer getWhatsappShareCount() {
                    return whatsappShareCount;
                }

                public void setWhatsappShareCount(Integer whatsappShareCount) {
                    this.whatsappShareCount = whatsappShareCount;
                }
            }
        }
    }
}
