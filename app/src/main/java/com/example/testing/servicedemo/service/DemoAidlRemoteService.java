package com.example.testing.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.testing.servicedemo.IDemoRemoteService;

/**
 * 使用AIDL绑定的远程服务
 * Created by wangying on 2016/12/14.
 */

public class DemoAidlRemoteService extends Service {

    public class DemoIAidlRemoteService extends IDemoRemoteService.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void log() throws RemoteException {
            Log.i("DEMO_LOG", "DemoAidlRemoteService");
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DemoIAidlRemoteService();
    }
}
