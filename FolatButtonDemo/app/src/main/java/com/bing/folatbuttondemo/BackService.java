package com.bing.folatbuttondemo;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Description
 * Created by bing on 2015/10/10.
 */
public class BackService extends Service {
    private Process process;
    private FloatButton floatButton;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        floatButton = new FloatButton(this);
        floatButton.setBackgroundResource(R.mipmap.ic_launcher);
        showButton();
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "floatButton", Toast.LENGTH_LONG).show();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void showButton() {
        if (floatButton != null) {
            if (!floatButton.isShown()) {
                floatButton.show();
            }
        }
    }

    public void hideButton() {
        if (floatButton != null) {
            if (floatButton.isShown()) {
                floatButton.dismiss();
            }
        }
    }

    /**
     * 结束进程
     */
    private void killProcess(String packageName) {
        try {
            if (process == null) {
                process = Runtime.getRuntime().exec("sh");
            }
            OutputStream out = process.getOutputStream();
            String cmd = "am force-stop " + packageName;
            out.write(cmd.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
