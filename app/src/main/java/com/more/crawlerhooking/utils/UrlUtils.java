package com.more.crawlerhooking.utils;

import java.util.HashMap;
import java.util.Map;

public class UrlUtils {

    public static Map<String, String> getUrlAllParams(String url){
        Map<String, String> params = new HashMap<>();
        System.out.println("url: " + url);
        String[] strings = url.split("\\?", 2);
        if (strings.length > 1){
            String str1 = strings[1];
            System.out.println("str1: " + str1);
            String[] string1 = str1.split("&");
            for (String param : string1){
                System.out.println("param: " + param);
                String[] strings2 = param.split("=", 2);
                String key = strings2[0];
                String value = strings2[1];
                params.put(key, value);
            }
        }else {
            System.out.println("url split fail");
        }
        return params;
    }
}
