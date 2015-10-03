package com.bing.picassodemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        imageView1 = (ImageView) findViewById(R.id.iv_main_pic1);
        imageView2 = (ImageView) findViewById(R.id.iv_main_pic2);
        imageView3 = (ImageView) findViewById(R.id.iv_main_pic3);
        imageView4 = (ImageView) findViewById(R.id.iv_main_pic4);
        imageView5 = (ImageView) findViewById(R.id.iv_main_pic5);
        imageView6 = (ImageView) findViewById(R.id.iv_main_pic6);
        String url = "http://pic2.zhimg.com/a3a8d07829d7f076fd1ca9d99045edcd.jpg";
        /**加载网络图片**/
        Picasso.with(context).load(url).into(imageView1);
        /**加载网络图片,自定义尺寸**/
        Picasso.with(context).load(url).resize(300, 300).centerCrop().into(imageView2);
        /**加载网络图片，自定义形状**/
        Picasso.with(context).load(url).transform(new CircleImage()).into(imageView3);
        /**图片链接不存在**/
        Picasso.with(context).load("http://picmg.com/a3dcd.jpg").placeholder(R.mipmap.ic_launcher).error(R.color.gray).into(imageView4);
        /**加载本地图片**/
        Picasso.with(context).load(R.mipmap.ic_launcher).into(imageView5);
        Picasso.with(context).load("file:///android_asset/ic_launcher.png").into(imageView6);

    }

}
