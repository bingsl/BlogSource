package com.bing.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn, stopBtn, bindBtn, unBindBtn, dataBtn;
    private Intent intent;
    private MyServiceConnection conn;
    private Iprint iprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);
        bindBtn = (Button) findViewById(R.id.btn_bind);
        unBindBtn = (Button) findViewById(R.id.btn_unbind);
        dataBtn = (Button) findViewById(R.id.btn_get_service_data);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unBindBtn.setOnClickListener(this);
        dataBtn.setOnClickListener(this);
        intent = new Intent(this, MyService.class);
        conn = new MyServiceConnection();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startService(intent);
                break;
            case R.id.btn_stop:
                stopService(intent);
                break;
            case R.id.btn_bind:
                bindService(intent, conn, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(conn);
                break;
            case R.id.btn_get_service_data://与service通信，必须先绑定服务
                iprint.print();
                break;
        }
    }

    class MyServiceConnection implements ServiceConnection {
        /**
         * MyService中MyBinder是Iprint的实现类，可以强转为Iprint(也必须强转为Iprint)
         *
         * @param name
         * @param service service中onBind()方法返回的对象
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iprint = (Iprint) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
