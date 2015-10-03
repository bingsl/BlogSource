package com.bing.listviewwithviewpager.adpater;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bing.listviewwithviewpager.R;

/**
 * Description
 * Created by bing on 2015/10/3.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] listViewData;
    private String[] viewPagerData;
    private ViewHolder viewHolder;
    private static final int TYPE_COUNT = 2;

    public ListViewAdapter(Context context, String[] listViewData, String[] viewPagerData) {
        this.context = context;
        this.listViewData = listViewData;
        this.viewPagerData = viewPagerData;
    }

    @Override
    public int getCount() {
        return listViewData.length;
    }

    @Override
    public Object getItem(int i) {
        return listViewData[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
/**这两个方法必须得实现**/
    /**
     * @param position
     * @return ListView item的类型
     */
    @Override
    public int getItemViewType(int position) {
        return position > 0 ? 1 : 0;
    }

    /**
     * @return ListView 中item的种类
     */
    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (getItemViewType(position) == 0) {/**应该加载viewpager**/
            if (view == null) {
                viewHolder = new ViewHolder();
                view = View.inflate(context, R.layout.listview_first_item, null);
                viewHolder.viewPager = (ViewPager) view.findViewById(R.id.viewpager_main);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.viewPager.setAdapter(new ViewPagerAdapter(context, viewPagerData));
        } else if (getItemViewType(position) == 1) {/**应该加载普通的listview Item**/
            if (view == null) {
                viewHolder = new ViewHolder();
                view = View.inflate(context, R.layout.listview_item, null);
                viewHolder.textView = (TextView) view.findViewById(R.id.tv_listview_item);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.textView.setText(listViewData[position]);
        }

        return view;
    }

    private static class ViewHolder {
        TextView textView;
        ViewPager viewPager;
    }
}
