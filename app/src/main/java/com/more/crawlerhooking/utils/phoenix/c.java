package com.more.crawlerhooking.utils.phoenix;

import java.nio.ByteBuffer;

public final class c {

    private ByteBuffer byteBuffer;

    protected String encode = "GBK";

    public static class a {
        public byte aByte;

        public int size;
    }

    public c() {}

    public c(ByteBuffer byteBuffer){
        this.byteBuffer = ByteBuffer.wrap(byteBuffer.array(), 0, byteBuffer.position());
    }

    public c(byte[] bArr){
        this.byteBuffer = ByteBuffer.wrap(bArr);
    }

    public c(byte[] bArr, int position){
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.byteBuffer = wrap;
        wrap.position(position);
    }

    private void addPosition(int i){
        ByteBuffer byteBuffer1 = this.byteBuffer;
        byteBuffer1.position(byteBuffer1.position() + 1);
    }

    private void funD(){
        a aVar = new a();
        funx(aVar);
        funE(aVar.aByte);
    }

    private void funE(byte b11){

    }

    private void funx(a aVar){
        funw(aVar, this.byteBuffer);
    }

    public static int funw(a aVar, ByteBuffer byteBuffer){
        byte b11 = byteBuffer.get();
        aVar.aByte = (byte) (b11 & 15);
        int i = (b11 & 240) >> 4;
        aVar.size = i;
        if (i != 15){
            return 1;
        }
        aVar.size = byteBuffer.get() & 255;
        return 2;
    }
}
