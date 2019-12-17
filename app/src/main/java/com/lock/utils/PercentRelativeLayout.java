package com.lock.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lock.R;

/**
 * @author Created by Dream
 * Email：499276615@qq.com
 * On 2017/12/2
 * 百分比布局
 *
 */

public class PercentRelativeLayout extends RelativeLayout{

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new PercentRelativeLayout.LayoutParams(getContext(),attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取当前控件宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //获取子控件数量
        int iChildCount = getChildCount();
        float heightPercent = 0;
        float widthPercent = 0;
        for (int i = 0; i < iChildCount; i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            //判断子控件如果是PercentRelativeLayout的子类，对子控件进行长宽的设定
            if(layoutParams instanceof PercentRelativeLayout.LayoutParams){
                PercentRelativeLayout.LayoutParams percentLp = (LayoutParams) layoutParams;
                heightPercent = percentLp.getHeightPercent();
                widthPercent = percentLp.getWidthPercent();
            }
            if(heightPercent > 0){
                layoutParams.height = (int)(height*heightPercent);
            }
            if(widthPercent > 0){
                layoutParams.width = (int)(width*widthPercent);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public  static  class LayoutParams extends RelativeLayout.LayoutParams{

        private float heightPercent;
        private float widthPercent;

        float getHeightPercent() {
            return heightPercent;
        }

        public void setHeightPercent(float heightPercent) {
            this.heightPercent = heightPercent;
        }

        float getWidthPercent() {
            return widthPercent;
        }

        public void setWidthPercent(float widthPercent) {
            this.widthPercent = widthPercent;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            @SuppressLint("CustomViewStyleable")
            TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.Percent);
            heightPercent = array.getFloat(R.styleable.Percent_height_percent,heightPercent);
            widthPercent = array.getFloat(R.styleable.Percent_width_percent,widthPercent);
            array.recycle();
        }
    }
}
