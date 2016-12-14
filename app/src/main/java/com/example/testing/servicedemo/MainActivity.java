package com.example.testing.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.example.testing.servicedemo.service.DemoAidlRemoteService;
import com.example.testing.servicedemo.service.DemoRemoteService;
import com.example.testing.servicedemo.service.DemoService;
import com.example.testing.servicedemo.service.LocalBinder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindLocalService();
        bindRemoteService();
        bindAidlRemoteService();
    }

    private void bindLocalService() {
        Intent intent = new Intent(this, DemoService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocalBinder localBinder = (LocalBinder) iBinder;
                localBinder.log();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    private void bindRemoteService() {
        Intent intent = new Intent(this, DemoRemoteService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Message message = Message.obtain();
                Messenger messenger = new Messenger(iBinder);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    private void bindAidlRemoteService() {
        Intent intent = new Intent(this, DemoAidlRemoteService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IDemoRemoteService iDemoRemoteService = IDemoRemoteService.Stub.asInterface(iBinder);
                try {
                    iDemoRemoteService.log();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

}
