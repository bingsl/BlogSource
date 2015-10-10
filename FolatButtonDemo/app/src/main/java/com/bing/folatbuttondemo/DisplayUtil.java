/**********************************************************************
 * AUTHOR：YOLANDA
 * DATE：2015年2月27日上午10:04:19
 * Copyright © 56iq. All Rights Reserved
 * ======================================================================
 * EDIT HISTORY
 * ----------------------------------------------------------------------
 * |  DATE      | NAME       | REASON       | CHANGE REQ.
 * ----------------------------------------------------------------------
 * | 2015年2月27日    | YOLANDA    | Created      |
 * <p/>
 * DESCRIPTION：create the File, and add the content.
 ***********************************************************************/
package com.bing.folatbuttondemo;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Description
 * Created by bing on 2015/10/10.
 */
public class DisplayUtil {
    /**
     * 屏幕宽度
     **/
    public static int screenWidth;
    /**
     * 屏幕高度
     **/
    public static int screenHeight;
    /**
     * 屏幕密度
     **/
    public static int screenDpi;

    /**
     * 初始化屏幕宽度和高度
     *
     * @param activity
     */
    public static void initScreen(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);

        screenWidth = metric.widthPixels;
        screenHeight = metric.heightPixels;
        screenDpi = metric.densityDpi;
    }

    public static boolean isHorizontal() {
        return screenWidth > screenHeight;
    }

    public static int px2dip(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().density;
        return (int) (inParam / f + 0.5F);
    }

    public static int dip2px(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().density;
        return (int) (inParam * f + 0.5F);
    }

    public static int px2sp(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().scaledDensity;
        return (int) (inParam / f + 0.5F);
    }

    public static int sp2px(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().scaledDensity;
        return (int) (inParam * f + 0.5F);
    }

    public static float getScale(int oldSize, int newSize) {
        if (oldSize <= 0 && newSize <= 0) return 0;
        return ((float) newSize) / oldSize;
    }
}