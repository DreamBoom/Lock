package com.lock.ui.area;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class AreaContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void setLocationCallBack(Activity act, AMap aMap,int i);
        void showMarker(String jl);
    }
}
