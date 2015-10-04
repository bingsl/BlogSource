package com.bing.fragmentwithactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Description
 * Created by bing on 2015/10/4.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    private TextView textView;
    private Button button;
    private OnReceiverDataListener onReceiverDataListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_main, container, false);
        textView = (TextView) view.findViewById(R.id.tv_fragmentA);
        button = (Button) view.findViewById(R.id.btn_fragmentA);
        button.setOnClickListener(this);
        /**接收来自Activity的数据**/
        Bundle bundle = getArguments();
        textView.setText(bundle.getString("data"));
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onReceiverDataListener = (OnReceiverDataListener) activity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_fragmentA) {
            onReceiverDataListener.loadData("数据来自fragmentA");
        }
    }

    public interface OnReceiverDataListener {
        void loadData(String str);
    }
}
