package com.example.testing.servicedemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 本地的Service
 * Created by wangying on 2016/12/14.
 */

public class DemoService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }
}
