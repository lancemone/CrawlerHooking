package com.more.crawlerhooking.hooking.tiktok;

import static com.more.crawlerhooking.http.beans.tiktok.AwemeReportBean.ReportDataBean;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.http.HttpRequest;
import com.more.crawlerhooking.http.beans.tiktok.AwemeReportBean;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class FeedVideo {

    private String serial = null;
    private final String taskTurn = "hooking-tt-1";
    private static final List<String> InstanceHash = new ArrayList<>();
    private final Gson gson = new GsonBuilder().serializeNulls().create();

    public FeedVideo(XC_LoadPackage.LoadPackageParam loadPackageParam, String serial){
        LogUtils.i("FeedVideo hooking");
        this.serial = serial;
        AwemeHooking(loadPackageParam);
    }

    public void AwemeHooking(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        try {
            LogUtils.i("AwemeHooking");
            XposedHelpers.findAndHookMethod(TiktokConfig.AwemeClass, loadPackageParam.classLoader, TiktokConfig.GetAidMethod, new XC_MethodHook() {

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    getAwemeFeedInfo(param);
                }
            });
        } catch (Exception e) {
            XposedBridge.log("AwemeHooking: " + e);
            e.printStackTrace();
        }
    }

    private void getAwemeFeedInfo(XC_MethodHook.MethodHookParam param) {
        String aid = (String) param.getResult();
        if (InstanceHash.contains(aid)){
            return;
        }else {
            InstanceHash.add(aid);
        }
        Object author = XposedHelpers.callMethod(param.thisObject, "getAuthor");
        Object itemVideo = XposedHelpers.callMethod(param.thisObject, "getVideo");
        Object itemStatistics = XposedHelpers.callMethod(param.thisObject, "getStatistics");

        // author信息
        String uid = (String) XposedHelpers.callMethod(author, "getUid");
        String uniqueId = (String) XposedHelpers.callMethod(author, "getUniqueId");
        String secUid = (String) XposedHelpers.callMethod(author, "getSecUid");
        String authorLanguage = (String) XposedHelpers.callMethod(author, "getLanguage");
        String authorRegion = (String) XposedHelpers.callMethod(author, "getRegion");
        ReportDataBean.OriginDataBean.AuthorBean authorBean = new ReportDataBean.OriginDataBean.AuthorBean(uid, uniqueId, secUid, authorLanguage, authorRegion);

        // video信息
        int videoHeight = (int) XposedHelpers.callMethod(itemVideo, "getHeight");
        int videoWidth = (int) XposedHelpers.callMethod(itemVideo, "getWidth");
        int videoDuration = (int) XposedHelpers.callMethod(itemVideo, "getVideoLength");
        Object videoUrlModel = XposedHelpers.callMethod(itemVideo, "getH264PlayAddr");
        String videoUri = (String) XposedHelpers.callMethod(videoUrlModel, "getUri");
        Object videoUrlObject = XposedHelpers.callMethod(videoUrlModel, "getUrlList");
        List<String> videoUrlList = StringUtils.caseList(videoUrlObject, String.class);
        Object coverObject = XposedHelpers.callMethod(itemVideo, "getCover");
        String coverUri = (String) XposedHelpers.callMethod(coverObject, "getUri");
        Object coverUrlObject = XposedHelpers.callMethod(coverObject, "getUrlList");
        List<String> coverUrlList = StringUtils.caseList(coverUrlObject, String.class);
        int coverHeight = (int) XposedHelpers.callMethod(coverObject, "getHeight");
        int coverWidth = (int) XposedHelpers.callMethod(coverObject, "getWidth");
        ReportDataBean.OriginDataBean.VideoBean.PlayAddrBean playAddrBean = new ReportDataBean.OriginDataBean.VideoBean.PlayAddrBean(videoUri, videoUrlList);
        ReportDataBean.OriginDataBean.VideoBean.CoverBean coverBean = new ReportDataBean.OriginDataBean.VideoBean.CoverBean(coverUri, coverUrlList, coverWidth, coverHeight);
        ReportDataBean.OriginDataBean.VideoBean videoBean= new ReportDataBean.OriginDataBean.VideoBean(videoDuration, videoHeight, videoWidth, playAddrBean, coverBean);

        // statistics
        long diggCount = (long) XposedHelpers.callMethod(itemStatistics, "getDiggCount");
        long commentCount = (long) XposedHelpers.callMethod(itemStatistics, "getCommentCount");
        long downloadCount = (long) XposedHelpers.callMethod(itemStatistics, "getDownloadCount");
        long forwardCount = (long) XposedHelpers.callMethod(itemStatistics, "getForwardCount");
        long playCount = (long) XposedHelpers.callMethod(itemStatistics, "getPlayCount");
        long shareCount = (long) XposedHelpers.callMethod(itemStatistics, "getShareCount");
        int loseCount = (int) XposedHelpers.callMethod(itemStatistics, "getLoseCount");
        int loseCommentCount = (int) XposedHelpers.callMethod(itemStatistics, "getLoseCommentCount");
        ReportDataBean.OriginDataBean.StatisticsBean statisticsBean = new ReportDataBean.OriginDataBean.StatisticsBean(aid, commentCount, diggCount, downloadCount, playCount, shareCount, forwardCount, loseCount, loseCommentCount);

        int awemeType = (int)XposedHelpers.callMethod(param.thisObject, "getAwemeType");
        long createTime = (long) XposedHelpers.callMethod(param.thisObject, "getCreateTime");
        XposedHelpers.callMethod(param.thisObject, "convertChallengeToHashTag");
        String desc = (String) XposedHelpers.callMethod(param.thisObject, "getDesc");
        String descLanguage = (String) XposedHelpers.callMethod(param.thisObject, "getDescLanguage");
        String awemeRegion = (String) XposedHelpers.callMethod(param.thisObject, "getRegion");
        ReportDataBean.OriginDataBean originDataBean = new ReportDataBean.OriginDataBean(aid, desc, createTime, descLanguage, awemeRegion, authorBean, videoBean, statisticsBean);

        // device country
        Class<?> deviceRegisterManager = XposedHelpers.findClass("com.ss.android.ugc.aweme.ak.d", param.thisObject.getClass().getClassLoader());
        String deviceCountry = (String) XposedHelpers.callStaticMethod(deviceRegisterManager, "i");;
        ReportDataBean reportDataBean = new ReportDataBean(this.serial, aid, taskTurn, deviceCountry, awemeType, originDataBean);
        int hashcode = aid.hashCode();
        AwemeReportBean awemeReportBean = new AwemeReportBean(reportDataBean, hashcode);
        LogUtils.i("start upload aweme: " + aid);
        HttpRequest.CrawlerReportRecord(awemeReportBean);
    }
}
