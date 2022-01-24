package com.more.crawlerhooking.http.beans;

import com.google.gson.annotations.SerializedName;

public class CrawlerReportDataBean {

    @SerializedName("source")
    private String source;

    @SerializedName("report_data")
    private ReportDataBean reportDataBean;

    public CrawlerReportDataBean(){};

    public CrawlerReportDataBean(String source, ReportDataBean reportDataBean){
        this.source = source;
        this.reportDataBean = reportDataBean;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ReportDataBean getReportDataAbsBean() {
        return reportDataBean;
    }

    public void setReportDataAbsBean(ReportDataBean reportDataBean) {
        this.reportDataBean = reportDataBean;
    }
}
