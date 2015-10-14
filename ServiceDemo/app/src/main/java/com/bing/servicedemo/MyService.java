package com.bing.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Description
 * Created by bing on 2015/10/13.
 */
public class MyService extends Service {
    private static final String TAG = "qwe";
    private Iprint iprint;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart");
    }

    public void printLog() {
        Log.d(TAG, "activity 调用 service 的方法");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * 绑定服务后，由MyBinder调用service中的方法，onBind()返回MyBinder对象
     */
    class MyBinder extends Binder implements Iprint {
        /**
         * 实现接口，调用服务中的方法，传到activity中，实现activity间接调用service中的方法
         */
        @Override
        public void print() {
            printLog();
        }
    }
}
