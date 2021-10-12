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


    public static HashMap<String, String> SerialToRegion = new HashMap<String, String>() {{
        put("FA79K1A05028", "NG");
        put("FA7921A01744", "NG");
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
        // test devices
        put("HT7BV1A01078", "TZ");
        put("HT85R1A00680", "ML");
    }};

    public static HashMap<String, String> RegionToCarrierCode = new HashMap<String, String>(){{
        put("TZ", "64002");
        put("ET", "63601");
        put("KE", "63907");
        put("GH", "62006");
        put("NG", "62120");
        put("EG", "60201");
        put("CI", "61202");
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

    public static HashMap<String, String> DeviceIdToSerial = new HashMap<String, String>(){{
        put("6993301494053717506", "FA79Y1A01745");
        put("6993325258918430214", "FA79T1A05204");
        put("6995105490510808581", "FA79Y1A01775");
        put("6999555550145578501", "FA7921A01744");
        put("6999561089860027909", "FA79D1A05885");
        put("6999547738539787778", "FA79K1A05028");
        put("6999560049853548038", "FA79M1A00288");
        put("6999565190745589254", "FA79T1A02318");
        put("6999539000495080961", "FA79T1A05296");
        put("6999568759565026821", "FA81N1A00343");
        put("6999567562217080325", "FA81T1A05601");
        put("6999563574453028358", "HT7BN1A02199");
        put("6999831255387244037", "FA84D1A00563");
        // EG
        put("6999557097629435398", "HT85G1A05281");
        // fr
        put("6999647109764384262", "FA79E1A02926");
        put("6993325275308328453", "FA7981A04395");
        put("6999646052672882182", "FA79Y1A02047");
        put("6997032603971044866", "HT7BF1A01506");
        put("6999649628065187334", "HT79X1A00786");
        put("6999650899124897286", "FA7CN1A00127");
        put("6999651764560676358", "HT7BR1A03106");
        put("6999826797593609734", "FA79T1A05147");
        put("6999829798919013893", "FA7AW1A04774");
        // test 开发调试用
        put("6999648044644713989", "HT85R1A00680");
        put("7003328046380058113", "HT7BV1A01078");
        // 一对一
        put("7006243926302950918", "HT83X1A02104");
        put("7006247477943453190", "HT7991A03224");
        put("7006250833130128901", "HT7941A07289");
        put("7006249364604552710", "HT82T1A00925");
        put("7006250102679848453", "HT81F1A00528");
        put("7006260925695346181", "HT7C61A03340");
        put("7006261534863787526", "FA7A61A11156");
        put("7006262117138564613", "HT85N1A00536");
        put("7006262656873072134", "FA7B11A05127");
        put("7006263522904557061", "HT79V1A00338");
    }};

    public static HashMap<String, String> AndroidIdToSerial = new HashMap<String, String>(){{
        put("7917984559f97f5c", "HT7BR1A03106");
        put("32d8352139596ff3", "HT7BV1A01078");
    }};
}
