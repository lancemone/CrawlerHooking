package com.more.crawlerhooking.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.more.crawlerhooking.AppApplication;

import java.io.File;

public class StorageUtils {

    /**
     * 获取SDCARD剩余存储空间
     *
     * @return
     */
    public static long getAvailableExternalMemorySize() throws IllegalArgumentException {
        if (externalMemoryAvailable()){
            File path = Environment.getExternalStorageDirectory();
            StatFs statFs = new StatFs(path.getPath());
            long blockSize = statFs.getBlockSizeLong();
            long availableBlocks = statFs.getAvailableBlocksLong();
            return availableBlocks * blockSize;
        }else {
            return -1;
        }
    }

    /**
     * 获取SDCARD总存储空间
     *
     * @return
     */
    public static long getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long totalBlocks = stat.getBlockCountLong();
            return totalBlocks * blockSize;
        } else {
            return -1;
        }
    }

    /**
     * SDCARD是否存在
     */
    public static boolean externalMemoryAvailable(){
        return getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * SDCARD是否只读
     */
    public static boolean externalMemoryReadOnly(){
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(getExternalStorageState());
    }

    public static String getExternalStorageState(){
        return Environment.getExternalStorageState();
    }

    /**
     * 将数字大小转为“MB”、“KB”、“GB”格式
     *
     * @param size
     * @return
     */
    public static String getSize(long size) {
        if (size < 0)
            return null;

        String result = null;
        if (size > 1024 * 1024 * 1024) {
            float f = (float) size / (1024 * 1024 * 1024);
            String s = String.valueOf(f);
            if (s.length() - s.indexOf(".") > 2)
                result = s.substring(0, s.indexOf(".") + 3);
            else
                result = s;
            return result + "GB";
        } else if (size > 1024 * 1024) {
            float f = (float) size / (1024 * 1024);
            String s = String.valueOf(f);
            if (s.length() - s.indexOf(".") > 2)
                result = s.substring(0, s.indexOf(".") + 3);
            else
                result = s;
            return result + "MB";
        } else if (size > 1024) {
            float f = (float) size / 1024;
            String s = String.valueOf(f);
            if (s.length() - s.indexOf(".") > 2)
                result = s.substring(0, s.indexOf(".") + 3);
            else
                result = s;
            return result + "KB";
        } else if (size < 1024) {
            return String.valueOf(size) + "B";
        } else
            return null;
    }

    public static long getFreeSpace(String dir) {
        StatFs state = null;
        try {
            state = new StatFs(dir);
            long blockSize = state.getBlockSizeLong();
            long availableCount = state.getAvailableBlocksLong();
            long free = availableCount * blockSize;
            if (free > 0) {
                return free;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static File getDiskCacheDir(Context context, String dirName){
        String cachePath;
        if (externalMemoryAvailable() || !Environment.isExternalStorageRemovable()){
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null){
                cachePath = context.getCacheDir().getPath();
            }else {
                cachePath = externalCacheDir.getAbsolutePath();
            }
        }else {
            cachePath = context.getCacheDir().getPath();
        }
        File file = new File(cachePath + File.separator + dirName);
        if (!file.exists()){
            boolean mkdir = file.mkdir();
            if (mkdir){
                return file;
            }else {
                Log.w(AppApplication.TAG, "file mkdirs fail: " + file.getAbsolutePath());
            }
        }else {
            Log.w(AppApplication.TAG, "file exists: " + file.getAbsolutePath());
            return file;
        }
        return null;
    }
}
