package com.bing.listviewwithviewpager.adpater;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bing.listviewwithviewpager.R;


/**
 * Description
 * Created by bing on 2015/10/3.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] data;

    public ViewPagerAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.viewpager_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_viewpager_item);
        textView.setText(data[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
