package com.more.crawlerhooking.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.more.crawlerhooking.BuildConfig;

import java.io.File;

public class SPUtils {

    private static SPUtils spUtils;
    private static SharedPreferences sp;

    private SPUtils(){}

    public static synchronized SPUtils getInstance(){
        if (spUtils == null){
            spUtils = new SPUtils();
        }
        return spUtils;
    }

    public void init(Context context){
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        setWorldReadable(context);
    }

    public SharedPreferences getSp(){
        return sp;
    }

    public String getString(String key, String def){
        return sp.getString(key,def);
    }

    public int getInt(String key, int def){
        return sp.getInt(key, def);
    }

    public boolean getBoolean(String key, boolean def){
        return sp.getBoolean(key, def);
    }

    public boolean setString(String key, String value){
        return sp.edit().putString(key, value).commit();
    }

    public boolean setInt(String key, int value){
        return sp.edit().putInt(key, value).commit();
    }

    public boolean setBoolean(String key, boolean value){
        return sp.edit().putBoolean(key, value).commit();
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    @SuppressLint({"SetWorldReadable", "WorldReadableFiles"})
    private void setWorldReadable(Context context){
        File dataDir = new File(context.getApplicationInfo().dataDir);
        File prefsDir = new File(dataDir, "shared_prefs");
        File prefsFile = new File(prefsDir, BuildConfig.APPLICATION_ID + "_preferences.xml");
        if (prefsFile.exists()){
            for (File file : new File[]{dataDir, prefsDir, prefsFile}) {
                file.setReadable(true, false);
                file.setExecutable(true, false);
            }
        }
    }

}
