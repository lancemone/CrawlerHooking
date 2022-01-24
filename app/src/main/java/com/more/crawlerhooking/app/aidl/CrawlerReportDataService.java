package com.more.crawlerhooking.app.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

import com.more.crawlerhooking.CrawlerDataListenerInterface;
import com.more.crawlerhooking.CrawlerDataManagerInterface;
import com.orhanobut.logger.Logger;

public class CrawlerReportDataService extends Service {

    //AIDL不支持正常的接口回调，使用RemoteCallbackList实现接口回调
    private final RemoteCallbackList<CrawlerDataListenerInterface> crawlerDataListener = new RemoteCallbackList<>();

    public CrawlerReportDataService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new CrawlerDataManager();
    }

    public class CrawlerDataManager extends CrawlerDataManagerInterface.Stub {

        @Override
        public void sendData(String data) throws RemoteException {
            receiveData(data);
        }

        @Override
        public void registerReceiveListener(CrawlerDataListenerInterface receiveListener) throws RemoteException {
            crawlerDataListener.register(receiveListener);
        }

        @Override
        public void unregisterReceiveListener(CrawlerDataListenerInterface receiveListener) throws RemoteException {
            boolean unregister = crawlerDataListener.unregister(receiveListener);
            if (unregister){
                Logger.d("unregister CrawlerDataListenerInterface success");
            }else {
                Logger.d("unregister CrawlerDataListenerInterface fail");
            }
        }
    }

    public void receiveData(String data){
        final int N = crawlerDataListener.beginBroadcast();
        for (int i=0; i<N; i++){
            CrawlerDataListenerInterface dataListener = crawlerDataListener.getBroadcastItem(i);
            if (dataListener != null){
                try {
                    dataListener.onReceive(data);
                }catch (RemoteException e){
                    Logger.e("receiveData error" + e.toString());
                }
            }
        }
    }
}