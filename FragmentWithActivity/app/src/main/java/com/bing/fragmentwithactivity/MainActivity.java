package com.bing.fragmentwithactivity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentA.OnReceiverDataListener {
    /**
     * 1.activity向fragment传递数据可以用bundle
     * 2.fragment向activity传递数据可以用接口
     */
    private Button btn1;
    private FragmentManager fragmentManager;
    private FragmentA fragmentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentA = new FragmentA();
        btn1 = (Button) findViewById(R.id.btn_main_1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_1:
                Bundle bundle = new Bundle();
                bundle.putString("data", "数据来自mainActivity");
                fragmentA.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.layout_root, fragmentA, null).commit();
                break;
        }
    }

    @Override
    public void loadData(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}
