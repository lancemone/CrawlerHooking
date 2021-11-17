package com.more.crawlerhooking.http.okhttp;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CommonJsonCallback implements Callback {

    private final ResponseCallback mListener;
    private final Class<?> mClass;
    /**
     * the java layer exception, do not same to the logic error
     * @function 自定义异常类型
     */
    protected final int NETWORK_ERROR = -1; // the network relative error
    protected final int JSON_ERROR = -2; // the JSON relative error
    protected final int OTHER_ERROR = -3; // the unknow error

    protected final String EMPTY_MSG = "";
    protected final String JSON_TO_OBJECT_ERROR = "Json To Object Error";

    public CommonJsonCallback(ResposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        mListener.onFailure(new OkHttpException(NETWORK_ERROR, e.getMessage()));
    }

    /**
     * 请求成功的处理
     * 回调在主线程
     */
    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        String responseBody = Objects.requireNonNull(response.body()).string();
        try {
            if (mClass == null){
                mListener.onSuccess(responseBody);
            }else {
                Object obj = new Gson().fromJson(responseBody, mClass);
                if (obj != null){
                    mListener.onSuccess(obj);
                }else {
                    mListener.onFailure(new OkHttpException(JSON_ERROR, JSON_TO_OBJECT_ERROR));
                }
            }
        }catch (Exception e){
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
            e.printStackTrace();
        }
    }
}
