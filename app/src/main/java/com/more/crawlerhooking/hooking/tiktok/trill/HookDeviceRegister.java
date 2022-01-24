package com.more.crawlerhooking.hooking.tiktok.trill;

import android.content.Context;

import com.more.crawlerhooking.utils.LogUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookDeviceRegister {

    private XC_LoadPackage.LoadPackageParam lpParam;
    public HookDeviceRegister(XC_LoadPackage.LoadPackageParam loadPackageParam){
        lpParam = loadPackageParam;
    }

    public void hookDeviceRegisterMethod(XC_LoadPackage.LoadPackageParam loadPackageParam){
        Class<?> deviceRegisterBuilderClass = XposedHelpers.findClass("com.ss.android.deviceregister.b.d.a", loadPackageParam.classLoader);
        if (deviceRegisterBuilderClass != null){
            try {
                XposedHelpers.findAndHookMethod(deviceRegisterBuilderClass, "b", "java.lang.String", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        LogUtils.i("device Register params:\n" + Arrays.toString(param.args));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void hookSendEncryptLog(){
        Class<?> netUtilClass = XposedHelpers.findClass("com.ss.android.common.applog.NetUtil", lpParam.classLoader);
        Class<?> clazzEncryptorUtil = XposedHelpers.findClass("com.bytedance.frameworks.encryptor.EncryptorUtil", lpParam.classLoader);
        if (netUtilClass != null){
            XposedHelpers.findAndHookMethod(netUtilClass, "sendEncryptLog",String.class, byte[].class, Context.class, boolean.class, String[].class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
                    String url = (String) param.args[0];
                    LogUtils.i("sendEncryptLog params url: " + url);
                    Object context = param.args[2];
                    LogUtils.i("sendEncryptLog params url: " + context.toString());
                    String jsonString = "{\"_gen_time\":1640679174405,\"header\":{\"manifest_version_code\":\"180841\",\"sdk_target_version\":\"29\",\"access\":\"wifi\",\"app_version\":\"18.8.41\",\"device_model\":\"Pixel 2\",\"timezone\":2,\"channel\":\"googleplay\",\"app_version_minor\":\"\",\"language\":\"en\",\"resolution\":\"1794x1080\",\"device_manufacturer\":\"Google\",\"openudid\":\"22cf731aceb471d5\",\"update_version_code\":\"180841\",\"req_id\":\"c2cb7357-964c-4a72-87ec-ea2e2338e5c1\",\"rom\":\"5790879\",\"density_dpi\":\"420\",\"cdid\":\"eef9d498-d4ac-4947-8e88-0ab4e2f3a172\",\"os_api\":\"29\",\"cpu_abi\":\"arm64-v8a\",\"tz_name\":\"Africa/Cairo\",\"apk_first_install_time\":\"1640176808376\",\"tz_offset\":7200,\"sdk_version\":\"2.12.1-rc.17\",\"gaid_limited\":0,\"not_request_sender\":0,\"package\":\"com.ss.android.ugc.trill\",\"os\":\"Android\",\"os_version\":\"10\",\"custom\":{\"filter_warn\":0,\"user_period\":0,\"is_kids_mode\":0,\"web_ua\":\"Mozilla/5.0 (Linux; Android 10; Pixel 2 Build/QP1A.190711.019; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/96.0.4664.104 Mobile Safari/537.36\",\"user_mode\":-1},\"version_code\":\"180841\",\"display_name\":\"TikTok\",\"display_density\":\"mdpi\",\"release_build\":\"ac6e3ab_20210325\",\"clientudid\":\"8b468f6d-b8c9-4f91-942c-4aad41fe6af5\",\"google_aid\":\"5ae54f59-50a6-4225-9ef6-c7c7a08344fa\",\"device_brand\":\"google\",\"sdk_flavor\":\"global\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"is_system_app\":0,\"region\":\"NG\",\"aid\":1180,\"rom_version\":\"QP1A.190711.019\",\"git_hash\":\"27690874\"},\"magic_tag\":\"ss_app_log\"}";
                    byte[] bytes = jsonString.getBytes(StandardCharsets.UTF_8);
                    LogUtils.i("jsonString bytes:\n" + Arrays.toString(bytes));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        LogUtils.i("gzip bytes:\n" + Arrays.toString(byteArray));
                        Class<?> clazzB = XposedHelpers.findClass("com.bytedance.frameworks.core.a.b", lpParam.classLoader);
                        byte[] a = (byte[]) XposedHelpers.callStaticMethod(clazzB, "a", byteArray, byteArray.length);
                        LogUtils.d("after ttEncrypt bytes:\n" + Arrays.toString(a));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void invokeEncryptorUtil(){
        Class<?> clazzEncryptorUtil = XposedHelpers.findClass("com.bytedance.frameworks.encryptor.EncryptorUtil", lpParam.classLoader);
        if (clazzEncryptorUtil != null){
            String jsonString = "{\"_gen_time\":1640679174405,\"header\":{\"manifest_version_code\":\"180841\",\"sdk_target_version\":\"29\",\"access\":\"wifi\",\"app_version\":\"18.8.41\",\"device_model\":\"Pixel 2\",\"timezone\":2,\"channel\":\"googleplay\",\"app_version_minor\":\"\",\"language\":\"en\",\"resolution\":\"1794x1080\",\"device_manufacturer\":\"Google\",\"openudid\":\"22cf731aceb471d5\",\"update_version_code\":\"180841\",\"req_id\":\"c2cb7357-964c-4a72-87ec-ea2e2338e5c1\",\"rom\":\"5790879\",\"density_dpi\":\"420\",\"cdid\":\"eef9d498-d4ac-4947-8e88-0ab4e2f3a172\",\"os_api\":\"29\",\"cpu_abi\":\"arm64-v8a\",\"tz_name\":\"Africa/Cairo\",\"apk_first_install_time\":\"1640176808376\",\"tz_offset\":7200,\"sdk_version\":\"2.12.1-rc.17\",\"gaid_limited\":0,\"not_request_sender\":0,\"package\":\"com.ss.android.ugc.trill\",\"os\":\"Android\",\"os_version\":\"10\",\"custom\":{\"filter_warn\":0,\"user_period\":0,\"is_kids_mode\":0,\"web_ua\":\"Mozilla/5.0 (Linux; Android 10; Pixel 2 Build/QP1A.190711.019; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/96.0.4664.104 Mobile Safari/537.36\",\"user_mode\":-1},\"version_code\":\"180841\",\"display_name\":\"TikTok\",\"display_density\":\"mdpi\",\"release_build\":\"ac6e3ab_20210325\",\"clientudid\":\"8b468f6d-b8c9-4f91-942c-4aad41fe6af5\",\"google_aid\":\"5ae54f59-50a6-4225-9ef6-c7c7a08344fa\",\"device_brand\":\"google\",\"sdk_flavor\":\"global\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"is_system_app\":0,\"region\":\"NG\",\"aid\":1180,\"rom_version\":\"QP1A.190711.019\",\"git_hash\":\"27690874\"},\"magic_tag\":\"ss_app_log\"}";
            byte[] bytes = jsonString.getBytes(StandardCharsets.UTF_8);
            LogUtils.i("jsonString bytes:\n" + Arrays.toString(bytes));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                LogUtils.i("gzip bytes:\n" + Arrays.toString(byteArray));
                byte[] a = (byte[]) XposedHelpers.callStaticMethod(clazzEncryptorUtil, "a", byteArray, byteArray.length);
                LogUtils.d("after ttEncrypt bytes:\n" + Arrays.toString(a));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
