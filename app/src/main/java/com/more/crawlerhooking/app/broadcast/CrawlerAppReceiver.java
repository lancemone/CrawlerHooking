package com.more.crawlerhooking.app.broadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.http.HttpRequest;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.Logger;

public class CrawlerAppReceiver extends BroadcastReceiver {

    public CrawlerAppReceiver(Context context){
        super();
    }

    public static void registerReceiver(Context context){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_ERROR);
        filter.addAction(Constants.ACTION_TASK);
        filter.addAction(Constants.ACTION_REPORT);
        context.registerReceiver(new CrawlerAppReceiver(context), filter);
        Logger.d("CrawlerAppReceiver register");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Logger.d("CrawlerAppReceiver Receive Action: " + action);
        try {
            switch (action){
                case Constants.ACTION_REPORT:
                    String reportData = intent.getStringExtra(Constants.EXTRA_NAME_CRAWLER_DATA_REPORT);
                    if (reportData != null && reportData.length() > 0){
                        crawlerDataReport(reportData);
                    }
                    break;
                case Constants.ACTION_ERROR:
                    String error = intent.getStringExtra(Constants.EXTRA_NAME_ERROR_MESSAGE);
                    Logger.e(error);
                    break;
                case Constants.ACTION_TASK:
                    String serial = intent.getStringExtra(Constants.EXTRA_NAME_DEVICE_SERIAL);
                    String taskTurn = intent.getStringExtra(Constants.EXTRA_NAME_TASK_TURN);
                    if (!serial.isEmpty()){
                        Logger.i("BroadcastReceiver device serial: " + serial);
                        SPUtils.getInstance().setString(Constants.SerialNoKey, serial);
                    }
                    if (!taskTurn.isEmpty()){
                        Logger.i("BroadcastReceiver task turn: " + taskTurn);
                        SPUtils.getInstance().setString(Constants.TaskTurnKey, taskTurn);
                    }
                    break;
                default:
                    Logger.d(intent.getDataString());
            }
        }catch (Exception e){
            Logger.e(e, "CrawlerAppReceiver receive error");
        }

    }

    private void crawlerDataReport(String body){
        HttpRequest.CrawlerReportRecord(body);
    }
}