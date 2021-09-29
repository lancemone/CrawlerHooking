package com.more.crawlerhooking.interfaces;

import android.content.ContentResolver;
import android.content.Context;

public interface SystemUtilsInterface {

    void applicationContext(Context context);

    void contextResolver(ContentResolver contentResolver);

    void androidId(String androidId);
}
