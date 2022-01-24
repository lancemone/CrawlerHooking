package com.more.crawlerhooking.conf;

import java.util.HashMap;

public class TiktokConfig {

    public static String TikTokPn = "com.ss.android.ugc.trill";
    public static String AwemeClass = "com.ss.android.ugc.aweme.feed.model.Aweme";
    public static String FeedItemListClass = "com.ss.android.ugc.aweme.feed.model.FeedItemList";
    public static String DeviceRegisterManagerClass = "com.ss.android.deviceregister.DeviceRegisterManager";

    public static String GetRegionMethod = "getRegion";
    public static String GetAidMethod = "getAid";
    public static String getFeedItemsMethod = "getItems";
    public static String GetDeviceIdMethod = "getDeviceId";
    public static String TryWaitDeviceIdInit = "tryWaitDeviceIdInit";

    public static String SsHttpCallClass = "com.bytedance.retrofit2.SsHttpCall";
    public static String GetResponseMethod = "getResponseWithInterceptorChain";
    public static String GetRequestMethod= "request";


    public static String RetrofitRequestClass = "com.bytedance.retrofit2.client.Request";
    public static String RetrofitRequestHeadersField = "headers";
    public static String RetrofitRequestGetHeadersMethod = "getHeaders";
    public static String RetrofitRequestGetMethodMethod = "getMethod";
    public static String RetrofitRequestGetServiceTypeMethod = "getServiceType";
    public static String RetrofitRequestGetUrlMethod = "getUrl";
    public static String RetrofitRequestIsAddCommonParamMethod = "isAddCommonParam";
    public static String RetrofitRequestGetBodyMethod = "getBody";


    public static String RetrofitResponseClass = "com.bytedance.retrofit2.u";
    public static String RetrofitResponseHeadersMethod = "b";
    public static String RetrofitRawResponseClass = "com.bytedance.retrofit2.client.c";
    public static String RetrofitResponseRawResponseField = "a";
    public static String RetrofitResponseBeanObjectField = "b";
    public static String RetrofitResponseTypeInputField = "c";




    public static HashMap<String, String> SerialToRegion = new HashMap<String, String>() {{
        put("", "NG");
        put("FA79K1A05028", "NG");
        put("FA79M1A00288", "NG");
        put("FA79D1A05885", "NG");
        put("HT7BN1A02199", "NG");
        put("FA79T1A02318", "NG");
        put("FA79T1A05296", "NG");
        put("FA81N1A00343", "NG");
        put("FA81T1A05601", "NG");
        put("FA84D1A00563", "GH");
        put("FA79Y1A01775", "KE");
        put("FA79T1A05204", "ET");
        put("FA79Y1A01745", "TZ");
        put("HT85G1A05281", "EG");          // 埃及
        put("FA79Y1A02047", "CI");
        put("FA79E1A02926", "CI");
        put("HT79X1A00786", "ML");
        put("FA7CN1A00127", "BF");
        put("HT7BR1A03106", "SN");
        put("FA79T1A05147", "CD");
        put("FA7AW1A04774", "CM");
        put("FA7981A04395", "CI");
        put("HT7BF1A01506", "ML");
        put("HT83X1A02104", "GN");
        put("HT7991A03224", "BJ");
        put("HT7941A07289", "NE");
        put("HT82T1A00925", "UG");
        put("HT81F1A00528", "SL");
        put("HT7C61A03340", "ZM");
        put("FA7A61A11156", "TG");
        put("HT85N1A00536", "LR");
        put("FA7B11A05127", "RW");
        put("HT79V1A00338", "GA");
        put("HT7BV1A01078", "TZ");
        put("HT85R1A00680", "ML");
        // test devices
        put("FA7921A01744", "CI");
    }};

    public static HashMap<String, String> RegionToCarrierCode = new HashMap<String, String>(){{
        put("TZ", "64002");
        put("ET", "63601");
        put("KE", "63907");
        put("GH", "62006");
        put("NG", "62120");
        put("EG", "60201");
        put("CI", "61202"); //科特迪瓦
        put("ML", "61001");
        put("BF", "61301");
        put("SN", "60802");
        put("CD", "63001");
        put("CM", "62401");
        put("GN", "61104");
        put("BJ", "61601");
        put("NE", "61404");
        put("UG", "64114");
        put("SL", "61904");
        put("ZM", "64502");
        put("TG", "61501");
        put("LR", "61801");
        put("RW", "63510");
        put("GA", "62803");
    }};

    public static HashMap<String, String> RegionToLanguage = new HashMap<String, String>(){{
        put("TZ", "en");
        put("ET", "en");
        put("KE", "en");
        put("GH", "en");
        put("NG", "en");
        put("EG", "ar");
        put("CI", "fr"); //科特迪瓦
        put("ML", "fr");
        put("BF", "fr");
        put("SN", "fr");
        put("CD", "fr");
        put("CM", "fr");
        put("GN", "fr");
        put("BJ", "fr");
        put("NE", "fr");
        put("UG", "en");
        put("SL", "en");
        put("ZM", "en");
        put("TG", "fr");
        put("LR", "en");
        put("RW", "en");
        put("GA", "fr");
    }};

    public static HashMap<String, String> AndroidIdToSerial = new HashMap<String, String>(){{
        put("7917984559f97f5c", "HT7BR1A03106");
        put("32d8352139596ff3", "HT7BV1A01078");
        put("255b06963fa7427e", "FA7921A01744");
        put("d424c76908d5550a", "FA7921A01744");
    }};
}
