package com.bing.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bing.testaidldemo.Iprint;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bindBtn, unBindBtn, printBtn;
    private Intent intent;
    private MyServiceConnection conn;
    private Iprint iprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindBtn = (Button) findViewById(R.id.btn_bind);
        unBindBtn = (Button) findViewById(R.id.btn_unbind);
        printBtn = (Button) findViewById(R.id.btn_print);
        bindBtn.setOnClickListener(this);
        unBindBtn.setOnClickListener(this);
        printBtn.setOnClickListener(this);
        intent = new Intent();
        intent.setAction("com.bing.aidlDemo");
        conn = new MyServiceConnection();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind:
                bindService(intent, conn, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(conn);
                break;
            case R.id.btn_print:
                try {
                    iprint.print();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iprint = Iprint.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
