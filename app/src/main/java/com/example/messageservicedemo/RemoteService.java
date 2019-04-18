package com.example.messageservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;

import java.util.Random;

public class RemoteService extends Service {

    private final Random mGenerator = new Random();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * method for clients
     */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public String message(String aString) {
            return getRandomNumber() + aString;
        }

        public int getPid() {
            return Process.myPid();
        }

    };
}