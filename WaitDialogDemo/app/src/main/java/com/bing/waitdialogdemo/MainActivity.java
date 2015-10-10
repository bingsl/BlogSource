package com.bing.waitdialogdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WaitDialog waitDialog;
    private ProgressDialog progressDialog;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProgressDialog();
        initWaitDialog();
        button1 = (Button) findViewById(R.id.btn_main_one);
        button2 = (Button) findViewById(R.id.btn_main_two);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }


    private void initProgressDialog() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(false);//循环滚动
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("loading...");
        progressDialog.setCancelable(false);//false不能取消显示，true可以取消显示
    }

    private void initWaitDialog() {
        waitDialog = new WaitDialog(MainActivity.this);
        waitDialog.setText("loading...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_one:
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            progressDialog.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
                break;
            case R.id.btn_main_two:
                waitDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            waitDialog.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }
}
