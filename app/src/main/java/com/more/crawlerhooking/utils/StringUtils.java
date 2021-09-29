package com.more.crawlerhooking.utils;

import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<T> caseList(Object obj, Class<T> clazz){
        List<T> result = new ArrayList<T>();
        if (obj instanceof List<?>){
            for (Object o : (List<?>)obj){
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
