package com.more.crawlerhooking.app.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.more.crawlerhooking.app.service.SocketConnectService;
import com.more.crawlerhooking.utils.LogUtils;

public class SocketServiceBroadcastReceiver extends BroadcastReceiver {

    private static final String START_ACTION = "NotifyServiceStart";
    private static final String STOP_ACTION = "NotifyServiceStop";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (START_ACTION.equalsIgnoreCase(action)){
            context.startService(new Intent(context, SocketConnectService.class));
            LogUtils.i(Thread.currentThread().getName()+"------>" + "onReceive SocketConnectService start");
        }
        if (STOP_ACTION.equalsIgnoreCase(action)){
            context.stopService(new Intent(context, SocketConnectService.class));
            LogUtils.i(Thread.currentThread().getName()+"------>" + "onReceive SocketConnectService stop");
        }
    }
}
