package com.more.crawlerhooking.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.databinding.ActivityMainBinding;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        String androidId = getAndroidId();
        Resources.getSystem().getConfiguration().locale.getCountry();
        binding.mainAndroidIdValue.setText(androidId);
        binding.mainAndroidSerialValue.setText(getSerial(androidId));
        binding.mainAndroidSerial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.i("sp string: " + SPUtils.getInstance().getSp().toString());
                LogUtils.i("sp all: " + SPUtils.getInstance().getSp().getAll());
                LogUtils.i("serial read from sp: " + SPUtils.getInstance().getString(Common.SerialNoKey, null));
            }
        });
    }

    private String getAndroidId(){
        String androidId = SPUtils.getInstance().getString(Common.AndroidIdKey, null);
        if (androidId == null){
            androidId = Settings.System.getString(this.getContentResolver(), Settings.System.ANDROID_ID);
            SPUtils.getInstance().setString(Common.AndroidIdKey, androidId);
        }
        LogUtils.i("android id: " + androidId);
        return androidId;
    }

    private String getSerial(String androidId){
        String serialNo = SPUtils.getInstance().getString(Common.SerialNoKey, null);
        if (serialNo == null){
            try {
                serialNo = TiktokConfig.AndroidIdToSerial.get(androidId);
            }catch (NullPointerException e){
                LogUtils.e(e.getMessage());
            }
            SPUtils.getInstance().setString(Common.SerialNoKey, serialNo);
        }
        LogUtils.i("serial number: " + serialNo);
        return serialNo;
    }
}