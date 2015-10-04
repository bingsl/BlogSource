package com.bing.listviewitemdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<ItemData> arrayList;//数据集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        initData();
        listView.setAdapter(new ListViewAdapter(this, arrayList));
    }

    /**
     * 初始化数据
     * 根据自己的需要初始化数据，我这里把所有的item放在一个javabean里面，
     * 需要用哪个初始化哪个，我为了简单这样写的，但不建议这样写
     */
    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemData("first item"));
        arrayList.add(new ItemData("second item top", "second item bottom"));
        arrayList.add(new ItemData("third item text1", R.mipmap.ic_launcher));
        arrayList.add(new ItemData("third item text2", R.mipmap.ic_launcher));
        arrayList.add(new ItemData("third item text3", R.mipmap.ic_launcher));
    }
}
