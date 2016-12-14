package com.example.testing.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 使用Messenger远程服务
 * Created by wangying on 2016/12/14.
 */

public class DemoRemoteService extends Service {

    public class DemoRemoteHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("DEMO_LOG", "handleMessage(Message msg)");
        }
    }

    Messenger mMessenger = new Messenger(new DemoRemoteHandler());


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

}
