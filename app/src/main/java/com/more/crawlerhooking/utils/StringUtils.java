package com.more.crawlerhooking.utils;

import android.os.Build;
import android.util.Xml;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
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

    public static String byte2Base64String(byte[] b){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(b);
        }else {
            return "";
        }
    }

    public static String byte2String(byte[] data, long length){
        int index = (int) length;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                index = i;
                break;
            }
        }
        byte[] temp = new byte[index];
        Arrays.fill(temp, (byte) 0);
        System.arraycopy(data, 0, temp, 0, index);
        String str;
        try {
            str = new String(temp, "GBK");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
        return str;
    }
}
