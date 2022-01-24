package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;

public class ReportDataBean {
    /**
     * 唯一id
     */
    @SerializedName("id")
    private String id;

    /**
     * deviceId
     * 设备号
     */
    @SerializedName("device_id")
    private String deviceId;

    /**
     * taskTurn
     * 任务轮次
     */
    @SerializedName("task_turn")
    private String taskTurn;

    /**
     * deviceCountry
     * 当前设备预设国家
     */
    @SerializedName("device_country")
    private String deviceCountry;
    /**
     * deviceCountry
     * 当前设备预设国家
     */
    @SerializedName("device_language")
    private String deviceLanguage;
    /**
     * foryou
     * 是否foryou推荐
     */
    @SerializedName("foryou")
    private Integer foryou;
    /**
     * originData
     * 抓取的源数据
     */
    @SerializedName("origin_data")
    private AbsOriginDataBean originData;

    public String getDeviceLanguage() {
        return deviceLanguage;
    }

    public void setDeviceLanguage(String deviceLanguage) {
        this.deviceLanguage = deviceLanguage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTaskTurn() {
        return taskTurn;
    }

    public void setTaskTurn(String taskTurn) {
        this.taskTurn = taskTurn;
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

    public AbsOriginDataBean getOriginData() {
        return originData;
    }

    public void setOriginData(AbsOriginDataBean originData) {
        this.originData = originData;
    }
}
