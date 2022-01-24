package com.more.crawlerhooking.utils;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class RegexUtilsTest {

    @Test
    public void urlFiler() {
        boolean match;
        String url;
        url = "https://xlog.tiktokv.com/v2/r?os=0&ver=0.6.11.29.19-MT&m=2&app_ver=18.8.41&region=en_US&aid=1180&did=6999555550145578501&iid=6999555606265169670";
        match = RegexUtils.urlMatchFiler(url);
        Assert.assertFalse(match);
        url = "https://log.tiktokv.com/service/2/app_log/?iid=6999555606265169670&device_id=6999555550145578501&ac=wifi&channel=googleplay&aid=1180&app_name=trill&version_code=180841&version_name=";
        match = RegexUtils.urlMatchFiler(url);
        Assert.assertFalse(match);
        url = "https://mon-va.tiktokv.com/monitor/collect/?sdk_version=400&manifest_version_code=18084";
        match = RegexUtils.urlMatchFiler(url);
        Assert.assertFalse(match);
        url = "https://dns.google.com/resolve?name=api-h2.tiktokv.com";
        match = RegexUtils.urlMatchFiler(url);
        Assert.assertFalse(match);
        url = "https://api.tiktokv.com/aweme/v1/aweme/stats/";
        match = RegexUtils.urlMatchFiler(url);
        Assert.assertTrue(match);
    }

    @Test
    public void urlMatchAwemeFeed() {
        String url = "https://api-h2.tiktokv.com/aweme/v2/feed/?sp=-1&type=0&max_cursor=0&min_cursor=0&count=6&volume=0.0&pull_type=0&req_from=enter_auto&gaid=eb6eab92-f0b6-495f-88ee-99ad6e4316fc&ad_user_agent=Mozilla%2F5.0+%28Linux%3B+Android+10%3B+Pixel+2+Build%2FQP1A.190711.019%3B+wv%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Version%2F4.0+Chrome%2F96.0.4664.104+Mobile+Safari%2F537.36&filter_warn=0&ad_personality_mode=1&address_book_access=2&local_cache=7044731529725218095&cached_item_num=0&last_ad_show_interval=-1&vpa_content_choice=1&sound_output_device=0&cmpl_enc=AgICAw0AFpMlF-RP_bEdhDhZcF08-_4VlG0Kf4QhYMLXaw&user_avatar_shrink=96_96&manifest_version_code=180841&_rticket=1640933894546&current_region=CI&app_language=fr&app_type=normal&iid=7038888397943621382&channel=googleplay&device_type=Pixel+2&language=fr&cpu_support64=true&host_abi=arm64-v8a&locale=en&resolution=1080";
        boolean b = RegexUtils.urlMatchAwemeFeed(url);
        Assert.assertTrue(b);
    }
}