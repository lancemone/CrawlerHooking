package com.more.crawlerhooking.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.more.crawlerhooking.Common;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.databinding.ActivityMain1Binding;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.SPUtils;

public class Main1Activity extends AppCompatActivity {

    private ActivityMain1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain1Binding.inflate(getLayoutInflater());
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