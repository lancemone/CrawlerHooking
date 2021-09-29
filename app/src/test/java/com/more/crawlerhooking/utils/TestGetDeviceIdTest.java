package com.more.crawlerhooking.utils;

import org.junit.Test;

public class TestGetDeviceIdTest {

    protected TestGetDeviceId testGetDeviceId = new TestGetDeviceId() {
        @Override
        public String a(String str) {
            return null;
        }

        @Override
        public void a(String str, String str2) {

        }
    };
    @Test
    public void b() {
        String a = testGetDeviceId.b("", "");
        System.out.println(a);
    }
}