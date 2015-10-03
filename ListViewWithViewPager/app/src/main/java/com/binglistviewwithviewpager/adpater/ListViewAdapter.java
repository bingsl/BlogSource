package com.binglistviewwithviewpager.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.binglistviewwithviewpager.R;

/**
 * Description
 * Created by bing on 2015/10/3.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] data;
    private ViewHolder viewHolder;

    public ListViewAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.listview_item, null);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_listview_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(data[position]);
        return view;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
