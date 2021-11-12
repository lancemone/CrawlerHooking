package com.more.crawlerhooking.utils;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestGetDeviceIdTest {

    private byte[] bytes;


    @Test
    public void b() {
        if (bytes.length >= 4){
            ByteBuffer allocate = ByteBuffer.allocate(4);
            byte[] bArr = new byte[4];
            System.arraycopy(bytes, 0, bArr, 0, 4);
            allocate.put(bArr).flip();
            int s = allocate.getInt();
        }
    }

    class UnknowUse{
        String code = "GBK";
    }
}