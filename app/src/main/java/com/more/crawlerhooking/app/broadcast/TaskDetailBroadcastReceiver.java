package com.more.crawlerhooking.app.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.SPUtils;

public class TaskDetailBroadcastReceiver extends BroadcastReceiver {

    private static final String ACTION = "com.more.crawler.task";
    private static final String DEVICE_SERIAL = "device_serial";
    private static final String TASK_TURN = "task_turn";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtils.d("TaskDetailBroadcastReceiver action: " + action);
        if (action.equalsIgnoreCase(ACTION)){
            String serial = intent.getStringExtra(DEVICE_SERIAL);
            String taskTurn = intent.getStringExtra(TASK_TURN);
            if (!serial.isEmpty()){
                LogUtils.i("TaskDetailBroadcastReceiver device serial: " + serial);
                SPUtils.getInstance().setString(Common.SerialNoKey, serial);
            }
            if (!taskTurn.isEmpty()){
                LogUtils.i("TaskDetailBroadcastReceiver task turn: " + taskTurn);
                SPUtils.getInstance().setString(Common.TaskTurnKey, taskTurn);
            }
        }
    }
}
