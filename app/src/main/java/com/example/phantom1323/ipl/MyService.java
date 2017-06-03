package com.example.phantom1323.ipl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public final static String TAG = "Himanshu";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand called");

    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Destroyed method called");
    }
}
