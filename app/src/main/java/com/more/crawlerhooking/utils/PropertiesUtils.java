package com.more.crawlerhooking.utils;

import android.content.Context;

import com.more.crawlerhooking.AppApplication;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final PropertiesUtils instance = new PropertiesUtils();

    private PropertiesUtils(){}

    public static PropertiesUtils getInstance() {
        return instance;
    }


    public String getRegion(String serial) {
        Properties props = new Properties();
        try {
            props.load(AppApplication.getInstance().getApplicationContext().getAssets().open("tiktok/device_to_region"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(serial, "NG");
    }

    public String getCarrierCode(String region, Boolean isMcc) {
        String code;
        Properties properties = new Properties();
        try {
            properties.load(AppApplication.getInstance().getApplicationContext().getAssets().open("tiktok/device_to_carriercode"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        code = properties.getProperty(region, "62120");
        if(isMcc) {
            code = code.substring(0,2);
        }
        return code;
    }
}
