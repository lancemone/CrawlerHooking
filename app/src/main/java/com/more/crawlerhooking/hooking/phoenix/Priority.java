package com.more.crawlerhooking.hooking.phoenix;

import androidx.annotation.NonNull;

public interface Priority {

    enum LeverEnum {
        Low("Low", 0),
        NORMAL("NORMAL", 1),
        HIGH("HIGH", 2),
        IMMEDIATE("IMMEDIATE", 3);

//        private int value;

        private LeverEnum(String arg2,int i){
//            super(arg2, i);
        }


    }

    int size();

    LeverEnum priority();
}
