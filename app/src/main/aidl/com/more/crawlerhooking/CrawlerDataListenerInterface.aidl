// CrawlerDataListenerInterface.aidl
package com.more.crawlerhooking;

// Declare any non-default types here with import statements

interface CrawlerDataListenerInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onReceive(String data);
}