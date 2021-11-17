package com.more.crawlerhooking.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    // http(s?)://(([^/]+)([^?]+)).*[^.webp|.jpeg|.jpg|.mp4]$

    public static ArrayList<String> NO_MATCH_HOST = new ArrayList<>(Arrays.asList(
            ".*log.*", "dns.google.com.*"));

    public static ArrayList<String> MATCH_HOST = new ArrayList<>(Arrays.asList(
            ".*aweme/v2/feed.*","api.tiktokv.com.*",".*aweme/v2/category/list.*"
    ));

    public static boolean urlMatchFiler(String url){
        String uri = getUriFromUrl(url);
        for (String reg1 : MATCH_HOST){
            if (Pattern.matches(reg1, uri)){
                return true;
            }
        }
        return false;
    }

    public static boolean urlUnMatchFiler(String url){
        String uri = getUriFromUrl(url);
        for (String reg1 : NO_MATCH_HOST){
            if (Pattern.matches(reg1, uri)){
                return false;
            }
        }
        return true;
    }

    public static String getUriFromUrl(String url){
        String uri = "";
        final String reg = "http(s?)://([^?]+).*[^.webp|.jpeg|.jpg|.mp4|.png]$";
        final Pattern pattern = Pattern.compile(reg);
        final Matcher matcher = pattern.matcher(url);
        while (matcher.find()){
            uri = matcher.group(2);
        }
        return uri;
    }
}
