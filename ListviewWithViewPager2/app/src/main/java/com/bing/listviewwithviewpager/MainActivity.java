package com.bing.listviewwithviewpager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bing.listviewwithviewpager.adpater.ListViewAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        String[] viewPagerData = new String[]{"第一页", "第二页", "第三页", "第四页", "第五页"};
        String[] listViewData = new String[15];
        for (int i = 0; i < listViewData.length; i++) {
            listViewData[i] = "item" + i;
        }
        /**这里把viewpager要用的数据一块传过去，大家可以根据自己的喜好来实现**/
        listViewAdapter = new ListViewAdapter(context, listViewData, viewPagerData);
        listView.setAdapter(listViewAdapter);
    }
}
