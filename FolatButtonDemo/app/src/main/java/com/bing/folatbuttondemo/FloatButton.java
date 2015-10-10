package com.bing.folatbuttondemo;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Description
 * Created by bing on 2015/10/10.
 */
public class FloatButton extends ImageView {
    private boolean isShown = false;

    private WindowManager windowManager;
    // 此windowManagerParams变量为获取的全局变量，用以保存悬浮窗口的属性
    private WindowManager.LayoutParams windowManagerParams;
    private float mRawX;
    private float mRawY;
    private float mStartY;
    private float mStartX;

    private boolean isOut = false;

    private OnClickListener listenner = null;

    public FloatButton(Context context) {
        super(context);
        windowManager = (WindowManager) getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowManagerParams = new WindowManager.LayoutParams();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取到状态栏的高度
        Rect frame = new Rect();
        getWindowVisibleDisplayFrame(frame);

        // 当前值以屏幕左上角为原点
        mRawX = event.getRawX();
        mRawY = event.getRawY();

        final int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 以当前父视图左上角为原点
                mStartX = event.getX();
                mStartY = event.getY();
                isOut = false;
                break;
            case MotionEvent.ACTION_MOVE:
                updateViewPosition();
                if (Math.abs(event.getX() - mStartX) > 5 || Math.abs(event.getY() - mStartY) > 5) {
                    isOut = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                updateViewPosition();
                if (!isOut && Math.abs(event.getX() - mStartX) < 5 && Math.abs(event.getY() - mStartY) < 5) {
                    if (listenner != null) {
                        listenner.onClick(this);
                        Toast.makeText(getContext(),"clicked",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
        return true;
    }

    private void updateViewPosition() {
        // 更新浮动窗口位置参数
        windowManagerParams.x = (int) (mRawX - mStartX);
        windowManagerParams.y = (int) (mRawY - mStartY);
        if (this.isShown()) {
            windowManager.updateViewLayout(this, windowManagerParams); // 刷新显示
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.listenner = onClickListener;
    }

    public void dismiss() {
        windowManager.removeView(this);
        isShown = false;
    }

    public void show() {
        windowManagerParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
        windowManagerParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        // 设置Window flag
        windowManagerParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        /*
		 * 注意，flag的值可以为： LayoutParams.FLAG_NOT_TOUCH_MODAL 不影响后面的事件
		 * LayoutParams.FLAG_NOT_FOCUSABLE 不可聚焦 LayoutParams.FLAG_NOT_TOUCHABLE
		 * 不可触摸
		 */
        windowManagerParams.gravity = Gravity.LEFT | Gravity.TOP;
        // 以屏幕左上角为原点，设置x、y初始值
        windowManagerParams.x = DisplayUtil.screenWidth - this.getWidth();
        windowManagerParams.y = DisplayUtil.screenHeight - this.getHeight();
        // 设置悬浮窗口长宽数据
        windowManagerParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        windowManagerParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        // 显示myFloatView图像
        windowManager.addView(this, windowManagerParams);
        isShown = true;
    }

    public boolean isShown() {
        return isShown;
    }
}
