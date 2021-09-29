package com.more.crawlerhooking.interfaces;

import android.content.ContentResolver;
import android.content.Context;

import com.more.crawlerhooking.utils.SystemUtils;

public class SystemUtilsImpl implements SystemUtilsInterface{

    private Context mContext = null;
    private ContentResolver mContentResolver = null;
    private String androidId = null;
    private SystemUtils systemUtils;

    public SystemUtilsImpl(SystemUtils systemUtils){
        this.systemUtils = systemUtils;
    }

    @Override
    public void applicationContext(Context context) {
        this.mContext = context;
    }

    @Override
    public void contextResolver(ContentResolver contentResolver) {
        this.mContentResolver = contentResolver;
    }

    public Context getAppContext(){
        if (this.mContext == null){
            this.systemUtils.getApplicationContext(this);
        }
        return this.mContext;
    }

    public ContentResolver getContentResolver(){
        if (this.mContentResolver == null){
            this.systemUtils.getContentResolver(this);
        }
        return this.mContentResolver;
    }

    @Override
    public void androidId(String androidId) {
        this.androidId = androidId;
    }
}
