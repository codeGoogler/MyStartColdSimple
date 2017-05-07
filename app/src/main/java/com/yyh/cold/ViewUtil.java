package com.yyh.cold;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author yuyahao
 *
 */
public class ViewUtil {
	/**
	 * 实例化布局中每个view对象
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends View> T getView(Activity act, int viewId){
		return (T)act.findViewById(viewId);
	}
	/**
	 * 实例化布局中每个view对象
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends View> T getView(View view, int viewId){
		return (T)view.findViewById(viewId);
	}


	/**
	 * 为TextView设置字符串
	 * @param act
	 * @param viewId
	 * @param resId
	 */
    public static void setImageResoure(Activity act, int viewId, int resId) {
        ImageView view = getView(act, viewId);
        view.setImageResource(resId);
    }
    /**
     * 为TextView设置字符串
     * 
     * @param viewId
     * @param text
     * @return
     */
    public static void setText(Activity act, int viewId, String text) {
    	TextView view = getView(act, viewId);
    	view.setText(text);
    }
    /**
     * 为TextView设置字符串
     * 
     * @param viewId
     * @param text
     * @return
     */
    public static void setText(View view, int viewId, String text) {
    	TextView tv = getView(view, viewId);
    	tv.setText(text);
    }

	/**
	 * 适配一些图片组件  必须要drawable下的
	 * @param resId
	 */
	public static void setMyAutoDisplay(Context cnt,Button btn ,int resId){
		Drawable drawable = cnt.getResources().getDrawable(resId);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());
		btn.setCompoundDrawables(drawable, null, null, null);
	}
}
