package com.more.crawlerhooking.conf.tiktok;

public class TrillConfig extends AbsTiktokConfig{

    public static String packageName = "com.ss.android.ugc.trill";

    public static String AddCustomParamsClass = "com.ss.android.common.applog.NetUtil";

    public static String AddCustomParamsMethod = "putCommonParams";

    public static String SsHttpCallClass = "com.bytedance.retrofit2.SsHttpCall";

    public static String SsHttpCallGetResponseMethod = "getResponseWithInterceptorChain";

    public static String SsHttpCallGetRequestMethod = "request";

    public static String RetrofitResponseClass = "com.bytedance.retrofit2.s";

    public static String RetrofitResponseRawResponseField = "a";

    public static String RetrofitResponseHeadersMethod = "b";

    public static String RetrofitRawResponseClass = "com.bytedance.retrofit2.b.d";

    public static String RetrofitRawResponseStatusCodeField = "b";

    public static String RetrofitRawResponseReasonField = "c";

    public static String RetrofitRawResponseHeadersField = "d";

    public static String RetrofitRawResponseTypedInputField = "e";

    public static String RetrofitRawResponseObjectField = "f";

    public static String RetrofitRequestClass = "com.bytedance.retrofit2.b.c";

    public static String RetrofitRequestMethodField = "a";

    public static String RetrofitRequestUrlField = "b";

    public static String RetrofitRequestHeadersField = "c";

    public static String RetrofitRequestTypedOutputField = "d";

    public static String RetrofitRequestOkhttpRequestField = "e";

    public static String RetrofitRequestTypedOutputMethod = "a";

    public static String RetrofitRequestObjectMapField = "l";

    public static String RetrofitRequestKField = "k";

    public static String RetrofitRequestJsonObjectField = "m";

    public static String RetrofitMimeOverridingTypedOutputClass = "com.bytedance.retrofit2.RequestBuilder$MimeOverridingTypedOutput";

    public static String RetrofitMimeOverridingTypedOutputTypedOutputField = "delegate";

    public static String RetrofitTypedOutputMimeTypeMethod = "mimeType";

    public static String RetrofitTypedOutputFileNameMethod = "fileName";

    // 此方法入参类型: OutputStream
    public static String RetrofitTypedOutputWriteToMethod = "writeTo";

    public static String RetrofitTypedByteArrayClass = "com.bytedance.retrofit2.mime.TypedByteArray";

    public static String RetrofitTypedByteArrayGetBytesMethod = "getBytes";

    public static String RetrofitTypedByteArrayGetInputStreamMethod = "in";
}
