package com.more.crawlerhooking.hooking.tiktok.trill;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.conf.tiktok.TrillConfig;
import com.more.crawlerhooking.hooking.XpBroadcast;
import com.more.crawlerhooking.http.HttpRequest;
import com.more.crawlerhooking.http.ICrawlerSource;
import com.more.crawlerhooking.http.beans.TiktokOriginDataBean;
import com.more.crawlerhooking.http.beans.tiktok.aweme.AwemeStatisticsStructV2;
import com.more.crawlerhooking.http.beans.tiktok.aweme.AwemeStructV2;
import com.more.crawlerhooking.http.beans.tiktok.aweme.AwemeV2FeedResponse;
import com.more.crawlerhooking.http.beans.tiktok.aweme.UserStructV2;
import com.more.crawlerhooking.http.beans.CrawlerReportDataBean;
import com.more.crawlerhooking.http.beans.ReportDataBean;
import com.more.crawlerhooking.http.beans.tiktok.aweme.VideoStructV2;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.RegexUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTrillSsHttpCall {
    private final String region;
    private final String language;
    private final String mcc;
    private final XC_LoadPackage.LoadPackageParam lpparms;
    private final String serial;
    private Context context;
    private final List<String> filterRegion = Arrays.asList("FA79Y1A01745", "FA79T1A05204");
    private final CrawlerReportDataBean crawlerReportDataBean = new CrawlerReportDataBean();
    private final ReportDataBean reportDataBean = new ReportDataBean();

    public HookTrillSsHttpCall(XC_LoadPackage.LoadPackageParam loadPackageParam, XSharedPreferences prefs) {
        serial = prefs.getString(Constants.SerialNoKey, "");
        String taskTurn = prefs.getString(Constants.TaskTurnKey, "");
        this.lpparms = loadPackageParam;
        this.region = TiktokConfig.SerialToRegion.get(serial);
        this.language = TiktokConfig.RegionToLanguage.get(this.region);
        this.mcc = TiktokConfig.RegionToCarrierCode.get(this.region);
        this.crawlerReportDataBean.setSource(ICrawlerSource.TIKTOK);
        this.reportDataBean.setDeviceId(serial);
        this.reportDataBean.setDeviceLanguage(language);
        this.reportDataBean.setTaskTurn(taskTurn);
        this.reportDataBean.setDeviceCountry(region);
    }

    public void hookAddCustomParams(){
        Class<?> clazzNetUtil = XposedHelpers.findClass(TrillConfig.AddCustomParamsClass, lpparms.classLoader);
        if (clazzNetUtil != null){
            XposedHelpers.findAndHookMethod(clazzNetUtil, TrillConfig.AddCustomParamsMethod, Map.class, boolean.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Map<String, String> map = (Map<String, String>) param.args[0];
//                    LogUtils.d("AddCustomParamsMethod method map params:\n" + map.toString());
                    map.put("carrier_region", region);
                    for (Map.Entry<String, String> entry : map.entrySet()){
                        String key = entry.getKey();
                        if (key.contains("region")){
                            entry.setValue(region);
                        }
                        if (key.contains("language")){
                            entry.setValue(language);
                        }
                        if (key.contains("mcc")){
                            entry.setValue(mcc);
                        }
                    }
//                    LogUtils.d("AddCustomParamsMethod method map params after:\n" + map.toString());
                    param.args[0] = map;
                }
            });
        }
    }

    public void getContext(){
        if (context == null){
            XposedHelpers.findAndHookMethod(Application.class, "attach",
                    Context.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            context = (Context) param.args[0];
                        }
                    });
        }
    }

    public void getResponseWithInterceptorChain(){
        Class<?> ssHttpCallClazz = XposedHelpers.findClassIfExists(TrillConfig.SsHttpCallClass, lpparms.classLoader);
        if (ssHttpCallClazz != null) {
            try {
                XposedHelpers.findAndHookMethod(ssHttpCallClazz, TrillConfig.SsHttpCallGetResponseMethod, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object response = param.getResult();
                        if (response == null) {
                            return;
                        }
                        Object originalRequest = XposedHelpers.callMethod(param.thisObject, TrillConfig.SsHttpCallGetRequestMethod);
                        String requestUlr = (String) XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestUrlField);
                        if (RegexUtils.urlUnMatchFiler(requestUlr)){
                            return;
                        }
                        if (RegexUtils.urlMatchAwemeFeed(requestUlr)){
                            LogUtils.d("urlMatchAwemeFeed True");
                            awemeDataReport(response);
                        }
//                        analyzeResponse(requestUlr, originalRequest, response);
                    }
                });
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }

    private void analyzeResponse(String requestUlr, Object originalRequest, Object response){
        Object rawResponse = XposedHelpers.getObjectField(response, TrillConfig.RetrofitResponseRawResponseField);
        if (rawResponse == null) {
            LogUtils.i("rawResponse is null");
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\n╔═══════════════════════════════════════════════════════════════════════════════════════").append("\n");
        builder.append(TrillConfig.SsHttpCallGetResponseMethod).append(" afterHookedMethod:").append("\n");
        builder.append("Request Url:\n").append(requestUlr).append("\n");
        builder.append("Request Method: ").append(XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestMethodField)).append("\n");
        builder.append("Request Headers: \n").append(XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestHeadersField)).append("\n");
        Object typedOutput = XposedHelpers.callMethod(originalRequest, TrillConfig.RetrofitRequestTypedOutputMethod);
        if (typedOutput != null){
            builder.append("Request TypedOutput: ").append(typedOutput).append("\n");
            if (typedOutput.getClass().getName().equals(TrillConfig.RetrofitMimeOverridingTypedOutputClass)){
                builder.append("Request MimeOverridingTypedOutput TypedOutput: ").append(XposedHelpers.getObjectField(typedOutput, TrillConfig.RetrofitMimeOverridingTypedOutputTypedOutputField)).append("\n");
                typedOutput = XposedHelpers.getObjectField(typedOutput, TrillConfig.RetrofitMimeOverridingTypedOutputTypedOutputField);
//                                builder.append("Request TypedOutput MimeType: ").append(XposedHelpers.callMethod(typedOutput, TrillConfig.RetrofitTypedOutputMimeTypeMethod)).append("\n");
//                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                                XposedHelpers.callMethod(typedOutput, TrillConfig.RetrofitTypedOutputWriteToMethod, byteArrayOutputStream);
//                                byteArrayOutputStream.close();
//                                builder.append("Request body: ").append(byteArrayOutputStream.toString()).append("\n");
            }
            if (typedOutput.getClass().getName().equals(TrillConfig.RetrofitTypedByteArrayClass)){
                builder.append("Request TypedOutput MimeType: ").append(XposedHelpers.callMethod(typedOutput, TrillConfig.RetrofitTypedOutputMimeTypeMethod)).append("\n");
//                                byte[] bytes = (byte[]) XposedHelpers.callMethod(typedOutput, TrillConfig.RetrofitTypedByteArrayGetBytesMethod);
                if (requestUlr.contains("service/2/device_register")){
                    try {
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        InputStream inputStream = (InputStream) XposedHelpers.callMethod(typedOutput, TrillConfig.RetrofitTypedByteArrayGetInputStreamMethod);
                        inputStream = new GZIPInputStream(inputStream);
                        byte[] bytes = new byte[8192];
                        int l = 0;
                        while ((l = inputStream.read(bytes)) >=0){
                            outputStream.write(bytes, 0, l);
                        }
                        builder.append("Request body: ").append(Arrays.toString(outputStream.toByteArray())).append("\n");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        builder.append("Request k: ").append(XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestKField)).append("\n");
        builder.append("Request ObjectMap: ").append(XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestObjectMapField)).append("\n");
        Object requestJsonObject = XposedHelpers.getObjectField(originalRequest, TrillConfig.RetrofitRequestJsonObjectField);
        if (requestJsonObject != null){
            builder.append("Request ObjectMap: ").append(XposedHelpers.callMethod(requestJsonObject, "a")).append("\n");
        }
        builder.append("response object Info:").append(response.getClass().getName()).append("\n");
        builder.append("StatusCode: ").append(XposedHelpers.getIntField(rawResponse, TrillConfig.RetrofitRawResponseStatusCodeField)).append("\n");
        builder.append("reason: ").append(XposedHelpers.getObjectField(rawResponse, TrillConfig.RetrofitRawResponseReasonField)).append("\n");
        List<?> headers = (List<?>) XposedHelpers.callMethod(response, TrillConfig.RetrofitResponseHeadersMethod);
        if (headers != null || !headers.isEmpty()) {
            builder.append("Headers:\n");
            for (Object bb : headers) {
                builder.append("\t").append(bb.toString()).append("\n");
            }
        }
        Object rawTypedInput = XposedHelpers.getObjectField(rawResponse, TrillConfig.RetrofitRawResponseTypedInputField);
        if (rawTypedInput != null) {
            String mimeType = (String) XposedHelpers.callMethod(rawTypedInput, "mimeType");
            builder.append("rawResponse TypedInput mimeType:").append(mimeType).append("\n");
        }
        builder.append("rawResponse Object f:").append(XposedHelpers.getObjectField(rawResponse, TrillConfig.RetrofitRawResponseObjectField)).append("\n");
        Object body = XposedHelpers.getObjectField(response, "c");
        if (body != null) {
            builder.append("Response body:\n").append(body).append("\n");
        } else {
            builder.append("Response body(c) is null").append("\n");
        }
        Object T = XposedHelpers.getObjectField(response, "b");
        if (T != null) {
            String name = T.getClass().getName();
            if (name.equals("com.bytedance.retrofit2.mime.TypedByteArray")){
                byte[] bytes = (byte[]) XposedHelpers.callMethod(T, "getBytes");
                builder.append("Response T):\n").append(name).append(": ").append(new String(bytes)).append("\n");
            }else {
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(T);
                builder.append("Response T:\n").append(T.getClass().getName()).append(": ").append(jsonString).append("\n");
            }
        }
        Object qObj = XposedHelpers.getObjectField(response, "d");
        if (qObj != null) {
            builder.append("Response q:\n").append(qObj).append("\n");
            builder.append("Response q.a:\n").append(XposedHelpers.callMethod(qObj, "a")).append("\n");
        }
        builder.append("╚═══════════════════════════════════════════════════════════════════════════════════════");
        LogUtils.d(builder.toString());
    }

    private void awemeDataReport(Object response){
        try {
            Object responseBody = XposedHelpers.getObjectField(response, "b");
            if (responseBody == null){
                return;
            }
            Object awemeV2FeedResponseOrigion = XposedHelpers.getObjectField(responseBody, "b");
            if (awemeV2FeedResponseOrigion == null){
                return;
            }
            Gson gson = new GsonBuilder().serializeNulls().create();
            String awemeResponseString = gson.toJson(awemeV2FeedResponseOrigion);
            AwemeV2FeedResponse awemeV2FeedResponse = gson.fromJson(awemeResponseString, AwemeV2FeedResponse.class);
            int foryou = awemeV2FeedResponse.getHomeModel();
            reportDataBean.setForyou(foryou);
            List<AwemeStructV2> awemeStructV2List = awemeV2FeedResponse.getAwemeList();
            for (AwemeStructV2 awemeStructV2 : awemeStructV2List){
                String awemeId = awemeStructV2.getAwemeId();
                UserStructV2 userStructV2 = awemeStructV2.getAuthor();
                if (foryou == 1 && this.filterRegion.contains(serial)){
                    if (!userStructV2.getRegion().equals(this.region)){
                        continue;
                    }
                }
                AwemeStatisticsStructV2 statisticsStructV2 = awemeStructV2.getStatistics();
                VideoStructV2 videoStructV2 = awemeStructV2.getVideo();
                TiktokOriginDataBean tiktokOriginDataBean = new TiktokOriginDataBean(awemeId,
                        awemeStructV2.getDesc(), awemeStructV2.getCreateTime(),
                        userStructV2, videoStructV2, statisticsStructV2,
                        awemeStructV2.getDescLanguage(), awemeStructV2.getRegion());
                reportDataBean.setOriginData(tiktokOriginDataBean);
                reportDataBean.setId(awemeId);
                crawlerReportDataBean.setReportDataAbsBean(reportDataBean);
                LogUtils.d("start upload tiktok aweme");
//                HttpRequest.CrawlerReportRecord(crawlerReportDataBean);
                XpBroadcast.sendCrawlerReportData(context, crawlerReportDataBean);
            }
        }catch (Exception e){
            XpBroadcast.sendErrorMsg(context, e.toString());
//            LogUtils.e(e);
        }
    }
}
