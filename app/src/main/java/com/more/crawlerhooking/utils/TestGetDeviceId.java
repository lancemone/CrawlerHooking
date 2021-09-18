package com.more.crawlerhooking.utils;

import android.text.TextUtils;

public abstract class TestGetDeviceId {

    public TestGetDeviceId instance;

    public interface R<L> {
        L a();

        L a(L l, L l2, TestGetDeviceId bVar);

        void a(L l);

        boolean a(L lm, L l2);

        boolean b(L l);
    }

    public abstract String a(String str);

    public abstract void a(String str, String str2);

    public void b(String str){
        TestGetDeviceId bVar =this.instance;
        if(bVar != null){
            bVar.b(str);
        }
    }

    public final String b(String str, String str2){
        return (String) a(str, str2, new R<String>() {
            @Override
            public String a() {
                return instance.a("device_id");
            }

            @Override
            public String a(String s, String l2, TestGetDeviceId bVar) {
                String str3 = s;
                String str4 = l2;
                if (bVar == null) {
                    return str3;
                }
                return bVar.b(str3, str4);
            }

            @Override
            public void a(String s) {
                instance.a("device_id", s);
            }

            @Override
            public boolean a(String lm, String l2) {
                return StringUtils.equal(lm, l2);
            }

            @Override
            public boolean b(String s) {
                return !TextUtils.isEmpty(s);
            }
        });
    }

    private <T> T a(T t, T t2, R<T> aVar) {
        TestGetDeviceId bVar = this.instance;
        T a2 = aVar.a();
        boolean b2 = aVar.b(t);
        boolean b3 = aVar.b(a2);

        if(!b2 && b3){
            t = a2;
        }
        if (bVar != null){
            T a3 = aVar.a(t,t2, bVar);
            if (!aVar.a(a3, a2)) {
                aVar.a(a3);
            }
            return a3;
        }
        boolean z = false;
        if(!b2 && !b3) {
            z = true;
            t = t2;
        }
        if((z && aVar.b(t)) || (b2 && !aVar.a(t, a2))) {
            aVar.a(t);
        }
        return t;
    }
}
