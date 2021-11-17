package com.more.crawlerhooking.utils;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class UrlUtilsTest {

    @Test
    public void getUrlAllParams() {
        String url = "qb://video/minivideo/list?vid=6650573099598049075&title=always make money to feed home. but not to compete with friends #&tabid=150006&type=2&tag=LABEL_NONE&downloadCount=15&from=Youngest Pro&view=25358&like=18&hate=0&liked=0&comment=0&playUrl=http://akoss.bangcdn.net/res/video/2021/11/14/20211114192033_-2036503179_6650573099598049075_mp4_h264.mp4&optPlayUrl=http://akoss.bangcdn.net/res/video/2021/11/14/20211114192033_-2036503179_6650573099598049075_mp4_h265_medium.mp4&picUrl=https://akoss.bangcdn.net/res/content/2021/11/14/20211114192035_-1692889684__540_1014_80_webp.webp&shareUrl=https://l.kphx.net/s?d=6650573099598049075&publisher=@ Sean&itemID=5_6650573099598049075&isPraised=false&commentCount=0&praiseCount=18&shareCount=36";
        Map<String, String> params = UrlUtils.getUrlAllParams(url);
        String vid = params.get("vid");
        Assert.assertEquals(vid, "6650573099598049075");
    }
}