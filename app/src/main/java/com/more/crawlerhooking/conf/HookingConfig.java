package com.more.crawlerhooking.conf;

import android.telephony.TelephonyManager;

import java.util.HashMap;

public class HookingConfig {

    public static String TelephonyManagerClass = "android.telephony.TelephonyManager";

    public static String NetworkOperatorMethod = "getNetworkOperator";      // 网络运营商类型
    public static String NetworkOperatorNameMethod = "getNetworkOperatorName";    // 网络类型名
    public static String SimOperatorMethod = "getSimOperator";    // 获取运营商代码
    public static String NetworkCountryIsoMethod = "getNetworkCountryIso";
}
