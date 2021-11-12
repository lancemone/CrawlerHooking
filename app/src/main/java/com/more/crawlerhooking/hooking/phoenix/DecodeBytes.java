package com.more.crawlerhooking.hooking.phoenix;

import android.os.SystemClock;

import com.more.crawlerhooking.utils.LogUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class DecodeBytes {

//    public final class Execute implements Priority, Runnable{
//
//        @Override
//        public int size() {
//            return 0;
//        }
//
//        @Override
//        public LeverEnum priority() {
//            return null;
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }

//    public void run(){
//        long startTime = SystemClock.elapsedRealtime();
//        int v2 = 0;
//        int v3 = -5000;
//        try {
//
//        }catch (Exception e){
//            throw e;
//        }
//    }

    public static void decode(XC_MethodHook.MethodHookParam param, Object h){
        StringBuilder builder = new StringBuilder();
        builder.append("╔═══════════════════════════════════════════════════════════════════════════════════════\n");
        builder.append(h).append("\n");
        Object n8c = XposedHelpers.getObjectField(param.thisObject, "b");
        builder.append("n8c object: ").append(n8c.getClass().getName()).append("\n");
        Object k8a = XposedHelpers.callMethod(n8c, "h");
        builder.append("k8a object: ").append(k8a.getClass().getName()).append("\n");
        boolean statusCodeTrue = (boolean) XposedHelpers.callMethod(h, "i");
        if (statusCodeTrue){
            Object n8d = XposedHelpers.callMethod(k8a, "j");
            builder.append("n8d Object: ").append(n8d.getClass().getName()).append("\n");
            List hk = (List) XposedHelpers.callMethod(h, "k");

            Object obj1 = XposedHelpers.callMethod(n8d, "c", k8a, hk);
            if (obj1 != null){
                String classObj1 = obj1.getClass().getName();
                builder.append("Object after decode: ").append(classObj1).append("\n");
                if (classObj1.equals("c70.m")){
                    builder.append("c70.m field g: ").append(XposedHelpers.getObjectField(obj1, "g")).append("\n");
                    builder.append("c70.m field u ").append(XposedHelpers.getObjectField(obj1, "u")).append("\n");
                    Class<?> s8d = XposedHelpers.findClassIfExists("s8.d", param.thisObject.getClass().getClassLoader());
                    if (s8d != null){
                        try {
                            Object s8dInstance = s8d.newInstance();
                            XposedHelpers.callMethod(obj1, "writeTo", s8dInstance);
                            String charset = (String) XposedHelpers.getObjectField(s8dInstance, "b");
                            ByteBuffer buffer = (ByteBuffer) XposedHelpers.getObjectField(s8dInstance, "a");
                            if (charset.toLowerCase(Locale.ROOT).equals("utf-8")){
                                if (buffer.hasArray()){
                                    String result = new String(buffer.array(), StandardCharsets.UTF_8);
                                    builder.append("s8d ByteBuffer string: ").append(result).append("\n");
                                }else {
                                    builder.append("s8d ByteBuffer string: ").append("\n");
                                }
                            }else {
                                builder.append("s8d charset: ").append(charset).append("\n");
                            }
                        } catch (IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
//                builder.append("Object after decode field a: ").append(XposedHelpers.getObjectField(obj1, "a")).append("\n");
//                builder.append("Object after decode field b: ").append(XposedHelpers.getObjectField(obj1, "b")).append("\n");
//                ArrayList fieldC = (ArrayList) XposedHelpers.getObjectField(obj1, "c");
//                for (Object l : fieldC){
//                    builder.append("Object after decode field c: ").append(l.toString()).append("\n");
//                }
//                ArrayList fieldE = (ArrayList) XposedHelpers.getObjectField(obj1, "e");
//                for (Object l : fieldE){
//                    builder.append("Object after decode field e: ").append(l.toString()).append("\n");
//                }
//                builder.append("Object after decode field f: ").append(XposedHelpers.getObjectField(obj1, "f")).append("\n");
//                builder.append("Object after decode field g: ").append(XposedHelpers.getObjectField(obj1, "g")).append("\n");
//                Object k8a1 = XposedHelpers.callMethod(XposedHelpers.getObjectField(param.thisObject, "b"), "h");
//                builder.append("k8a1 object: ").append(k8a1.getClass().getName()).append("\n");
//                Object o8b = XposedHelpers.callMethod(XposedHelpers.getObjectField(param.thisObject, "a"), "h");
//                builder.append("o8b object: ").append(o8b.getClass().getName()).append("\n");
//                Object o8a = XposedHelpers.callMethod(o8b, "a", k8a1);
//                builder.append("o8a object: ").append(o8a.getClass().getName()).append("\n");
            }else {
                builder.append("Object after decode is null").append("\n");
            }
        }else {
            builder.append("statusCode is not 200").append("\n");
        }
        builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
        LogUtils.i(builder.toString());
    }
}
