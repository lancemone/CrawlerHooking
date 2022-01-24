package com.more.crawlerhooking.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.more.crawlerhooking.CrawlerDataManagerInterface;
import com.more.crawlerhooking.R;
import com.more.crawlerhooking.app.aidl.CrawlerDataListener;
import com.more.crawlerhooking.app.aidl.CrawlerReportDataService;
import com.more.crawlerhooking.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ServiceConnection connection;
    private CrawlerReportDataService.CrawlerDataManager crawlerDataManager = null;
    private CrawlerDataManagerInterface crawlerDataManagerInterface;
    private CrawlerDataListener crawlerDataListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
        bindCrawlerDataManagerServer();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void bindCrawlerDataManagerServer() {
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                crawlerDataManager = (CrawlerReportDataService.CrawlerDataManager) service;
                crawlerDataManagerInterface = CrawlerDataManagerInterface.Stub.asInterface(service);
                try {
                    crawlerDataManagerInterface.asBinder().linkToDeath(new IBinder.DeathRecipient() {
                        @Override
                        public void binderDied() {
                            //当承载IBinder的进程消失时接收回调的接口
                        }
                    }, 0);
                    crawlerDataListener = new CrawlerDataListener();
                    crawlerDataManager.registerReceiveListener(crawlerDataListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent intent = new Intent(MainActivity.this, CrawlerReportDataService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private void checkPermission() {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(this,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (crawlerDataManager != null && crawlerDataManager.asBinder().isBinderAlive()) {
            try {
                crawlerDataManager.unregisterReceiveListener(crawlerDataListener);
            } catch (RemoteException e) {
                Logger.e(e, "crawlerDataManager unregisterReceiveListener fail");
            }
        }
        // 接触绑定服务
        unbindService(connection);
        super.onDestroy();
    }
}