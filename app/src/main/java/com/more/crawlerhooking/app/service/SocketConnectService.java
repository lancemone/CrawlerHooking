package com.more.crawlerhooking.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.more.crawlerhooking.Constants;
import com.more.crawlerhooking.utils.SPUtils;
import com.orhanobut.logger.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class SocketConnectService extends Service {

    ServerSocket serverSocket = null;
    final int SERVER_PORT = 7540;
    public static Boolean mainThreadFlag = true;
    public static Boolean ioThreadFlag = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i("SocketConnectService create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.i("SocketConnectService onStartCommand ");
        mainThreadFlag = true;
        new Thread(){
            @Override
            public void run() {
                doListen();
            }
        }.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 关闭线程
        mainThreadFlag = false;
        ioThreadFlag = false;
        Logger.i(Thread.currentThread().getName() + "-- SocketConnectService close");
        if (serverSocket != null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 监听端口
     */
    private void doListen(){
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            Logger.i("start listening socket port: " + SERVER_PORT);
            while (mainThreadFlag){
                Socket socket = serverSocket.accept();
                new Thread(new ThreadReadWriterIOSocket(this, socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ThreadReadWriterIOSocket implements Runnable{

        private final Socket client;
        private final Context context;

        public ThreadReadWriterIOSocket(Context context, Socket client){
            this.client = client;
            this.context = context;
        }

        @Override
        public void run() {

            Logger.i("client has connected to socket server");
            BufferedOutputStream outputStream;
            BufferedInputStream inputStream;
            String msgFromClient = "";
            try {
                outputStream = new BufferedOutputStream(client.getOutputStream());
                inputStream = new BufferedInputStream(client.getInputStream());
                ioThreadFlag = true;
                while (ioThreadFlag){
                    if (!client.isConnected()){
                        break;
                    }
                    Logger.i(Thread.currentThread().getName() + "--- start read data from connected client");
                    msgFromClient = readMsgFromSocket(inputStream);
                    Logger.i(Thread.currentThread().getName() + "--- msg from client: " + msgFromClient);
                    String result = handleMsgWithJson(msgFromClient);
                    outputStream.write(result.getBytes());
                    outputStream.flush();
                }
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (client != null){
                        Logger.i(Thread.currentThread().getName() + "--- connected client close");
                        client.close();
                    }
                } catch (IOException e) {
                    Logger.i(Thread.currentThread().getName() + "--- read data from connected client error");
                    e.printStackTrace();
                }
            }
        }

        private String readMsgFromSocket(BufferedInputStream inputStream){
            int MAX_BUFFER_BYTES = 2048;
            String msg = "";
            byte[] tempBuffer = new byte[MAX_BUFFER_BYTES];
            try {
                int numReadBytes = inputStream.read(tempBuffer, 0, tempBuffer.length);
                msg = new String(tempBuffer, 0, numReadBytes, StandardCharsets.UTF_8);
                tempBuffer = null;
                Logger.i(Thread.currentThread().getName() + "--- read data from connected client successful");
            } catch (IOException e) {
                Logger.i(Thread.currentThread().getName() + "--- read data from connected client error");
                e.printStackTrace();
            }
            return msg;
        }

        private String handleMsgWithJson(String msg){
            Map<String, Object> resultMap = new HashMap<>();
            String result = "ok";
            if (msg.isEmpty() || msg.length() == 1){
                resultMap.put("code", 400);
                resultMap.put("error", "content is empty");
                result = new Gson().toJson(resultMap);
                return result;
            }
            if (msg.contains("\"connect_type\": \"application/json\"")){
                try {
                    Map msgMap = new Gson().fromJson(msg, Map.class);
                    if (msgMap.containsKey("device_serial")){
                        String deviceSerial = (String) msgMap.get("device_serial");
                        SPUtils.getInstance().setString(Constants.SerialNoKey, deviceSerial);
                    }
                    if (msgMap.containsKey("task_turn")){
                        String taskTurn = (String) msgMap.get("task_turn");
                        SPUtils.getInstance().setString(Constants.TaskTurnKey, taskTurn);
                    }
                    resultMap.put("code", 200);
                    resultMap.put("error", "");
                    result = new GsonBuilder().serializeNulls().create().toJson(resultMap);
                    return result;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                resultMap.put("code", 300);
                resultMap.put("error", "content not json");
                result = new GsonBuilder().serializeNulls().create().toJson(resultMap);
                return result;
            }
            return result;
        }
    }
}
