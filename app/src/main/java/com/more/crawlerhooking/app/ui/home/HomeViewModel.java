package com.more.crawlerhooking.app.ui.home;

import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.more.crawlerhooking.AppApplication;
import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.conf.TiktokConfig;
import com.more.crawlerhooking.utils.LogUtils;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.Logger;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mAndroidId;
    private MutableLiveData<String> mSerialNum;
    private MutableLiveData<String> mRegion;
    private MutableLiveData<String> mCarrierCode;
    private MutableLiveData<String> mTaskTurn;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public HomeViewModel() {
        initDate();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initDate(){
        if (mAndroidId == null){
            mAndroidId = new MutableLiveData<>();
        }
        String androidId = getSystemAndroidId();
        mAndroidId.setValue(androidId);
        if (mSerialNum == null){
            mSerialNum = new MutableLiveData<>();
        }
        String serial = getSerial(androidId);
        mSerialNum.setValue(serial);
        if (mRegion == null){
            mRegion = new MutableLiveData<>();
        }
        String region = TiktokConfig.SerialToRegion.getOrDefault(serial, "");
        mRegion.setValue(region);
        if (mCarrierCode == null){
            mCarrierCode = new MutableLiveData<>();
        }
        String carrierCode = TiktokConfig.RegionToCarrierCode.getOrDefault(region, "");
        mCarrierCode.setValue(carrierCode);

        updateTaskTurn();
    }

    private String getSystemAndroidId(){
        String androidId = SPUtils.getInstance().getString(Constants.AndroidIdKey, null);
        if (androidId == null){
            androidId = Settings.System.getString(AppApplication.getInstance().getContentResolver(), Settings.System.ANDROID_ID);
            SPUtils.getInstance().setString(Constants.AndroidIdKey, androidId);
        }
        Logger.i("android id: " + androidId);
        return androidId;
    }

    public void updateTaskTurn(){
        if (mTaskTurn == null){
            mTaskTurn = new MutableLiveData<>();
        }
        String task = SPUtils.getInstance().getString(Constants.TaskTurnKey, "null");
        mTaskTurn.setValue(task);
    }

    private String getSerial(String androidId){
        String serialNo = SPUtils.getInstance().getString(Constants.SerialNoKey, null);
        if (serialNo == null){
            try {
                serialNo = TiktokConfig.AndroidIdToSerial.get(androidId);
            }catch (NullPointerException e){
                LogUtils.e(e.getMessage());
            }
            SPUtils.getInstance().setString(Constants.SerialNoKey, serialNo);
        }
        Logger.i("serial number: " + serialNo);
        return serialNo;
    }



    public LiveData<String> getAndroidId(){
        return mAndroidId;
    }

    public LiveData<String> getSerialNum() {
        return mSerialNum;
    }

    public LiveData<String> getRegion() {
        return mRegion;
    }

    public LiveData<String> getCarrierCode() {
        return mCarrierCode;
    }

    public LiveData<String> getTaskTurn() {
        return mTaskTurn;
    }
}