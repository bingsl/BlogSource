package com.bing.listviewitemdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Description
 * Created by bing on 2015/10/4.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ItemData> arrayList;
    private static final int TYPE_COUNT = 3;
    private ViewHolder viewHolder;

    public ListViewAdapter(Context context, ArrayList<ItemData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    /**
     * @param position 用于判断加载哪种item 根据自己的需要来实现
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {//是否是第一项
            return 0;
        } else if (position == 1) {//是否是第二项
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * @return Item的种类 这里共三种，TYPE_COUNT==3;
     */
    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == 0) {/**加载第一种item**/
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(context, R.layout.list_item_one, null);
                viewHolder.firstText = (TextView) convertView.findViewById(R.id.tv_item_one);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.firstText.setText(arrayList.get(position).getFirstItem());
        } else if (getItemViewType(position) == 1) {/**加载第二种item**/
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(context, R.layout.list_item_two, null);
                viewHolder.secondTextTop = (TextView) convertView.findViewById(R.id.tv_item_two_top);
                viewHolder.secondTextBottom = (TextView) convertView.findViewById(R.id.tv_item_two_bottom);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.secondTextTop.setText(arrayList.get(position).getSecondItemTop());
            viewHolder.secondTextBottom.setText(arrayList.get(position).getSecondItemBottom());
        } else if (getItemViewType(position) == 2) {/**加载第三种item**/
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(context, R.layout.list_item_three, null);
                viewHolder.thirdText = (TextView) convertView.findViewById(R.id.tv_item_three);
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_item_three);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.thirdText.setText(arrayList.get(position).getThirdItemText());
            viewHolder.imageView.setImageResource(arrayList.get(position).getThirdItemImg());
        }
        return convertView;
    }

    private static class ViewHolder {
        /**
         * 第一个item显示内容
         **/
        TextView firstText;
        /**
         * 第二个item显示内容
         **/
        TextView secondTextTop;
        TextView secondTextBottom;
        /**
         * 第三个item显示内容
         **/
        TextView thirdText;
        ImageView imageView;
    }
}
