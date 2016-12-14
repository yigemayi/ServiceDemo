package com.example.testing.servicedemo.service;

import android.os.Binder;
import android.util.Log;

/**
 * 本地的Binder
 * Created by wangying on 2016/12/14.
 */

public class LocalBinder extends Binder {

    public void log() {
        Log.i("DEMO_LOG", "LocalBinder!");
    }
}
