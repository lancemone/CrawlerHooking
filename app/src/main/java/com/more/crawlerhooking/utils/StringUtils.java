package com.more.crawlerhooking.utils;

public class StringUtils {

    public static boolean notNUll(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean equal(String str, String str2) {
        if (notNUll(str) && notNUll(str2)) {
            return true;
        }
        return str != null && str.equals(str2);
    }


}
