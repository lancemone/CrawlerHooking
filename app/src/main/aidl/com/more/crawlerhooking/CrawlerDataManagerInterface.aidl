// CrawlerDataManagerInterface.aidl
package com.more.crawlerhooking;

import com.more.crawlerhooking.CrawlerDataListenerInterface;

// Declare any non-default types here with import statements

interface CrawlerDataManagerInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void sendData(String data);
    void registerReceiveListener(CrawlerDataListenerInterface receiveListener);
    void unregisterReceiveListener(CrawlerDataListenerInterface receiveListener);
}