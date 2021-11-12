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
}