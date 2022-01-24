package com.more.crawlerhooking.app.aidl;

import android.os.RemoteException;

import com.more.crawlerhooking.CrawlerDataListenerInterface;
import com.orhanobut.logger.Logger;

public class CrawlerDataListener extends CrawlerDataListenerInterface.Stub {

    @Override
    public void onReceive(String data) throws RemoteException {
        Logger.i("CrawlerData: \n" + data);
    }
}
