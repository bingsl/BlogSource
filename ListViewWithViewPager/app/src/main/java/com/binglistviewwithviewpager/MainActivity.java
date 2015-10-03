package com.binglistviewwithviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.binglistviewwithviewpager.adpater.ListViewAdapter;
import com.binglistviewwithviewpager.adpater.ViewPagerAdapter;

/**
 * 实现顶部轮播，下部listview经典布局(方式一)
 * ViewPager设置为ListView的header
 */
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        initView();
        initData();

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        View header = View.inflate(context, R.layout.listview_header, null);
        viewPager = (ViewPager) header.findViewById(R.id.viewpager_main);
        listView.addHeaderView(header);//在setAdapter前
    }

    private void initData() {
        String[] viewPagerData = new String[]{"第一页", "第二页", "第三页", "第四页", "第五页"};
        String[] listViewData = new String[15];
        for (int i = 0; i < listViewData.length; i++) {
            listViewData[i] = "item" + i;
        }
        listViewAdapter = new ListViewAdapter(context, listViewData);
        viewPagerAdapter = new ViewPagerAdapter(context, viewPagerData);
        listView.setAdapter(listViewAdapter);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
