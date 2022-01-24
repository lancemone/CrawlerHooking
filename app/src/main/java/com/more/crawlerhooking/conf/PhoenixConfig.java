package com.more.crawlerhooking.conf;

import java.util.HashMap;

public class PhoenixConfig {

    private PhoenixConfig(){}

    public static HashMap<String, String[]> deviceToRegion = new HashMap<String, String[]>(){{
        put("FA7921A01744", new String[]{"EG", "AR"});
    }};
}
