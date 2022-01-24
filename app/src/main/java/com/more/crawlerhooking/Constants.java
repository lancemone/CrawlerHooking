package com.more.crawlerhooking;

public class Constants {

    public static final String AndroidIdKey = "androidId";

    public static final String SerialNoKey = "serialNo";

    public static final String TaskTurnKey = "taskTurn";

    public static final String PhoenixCountryKey = "phoenixCountry";

    public static final String CrawlerReportHost = "http://crawler.more.buzz:8688";
//    public static final String CrawlerReportHost = "http://10.236.141.185:8688";

    public static final String ApiReportRecords = "/api/v1/report/records/";



    // Broadcast
    public static final String ACTION_REPORT = "com.more.crawler.report";
    public static final String ACTION_TASK = "com.more.crawler.task";
    public static final String ACTION_ERROR = "com.more.crawler.error";
    public static final String EXTRA_NAME_CRAWLER_DATA_REPORT = "json";
    public static final String EXTRA_NAME_ERROR_MESSAGE = "msg";
    public static final String EXTRA_NAME_DEVICE_SERIAL = "device_serial";
    public static final String EXTRA_NAME_TASK_TURN = "task_turn";
}
