package com.lock.ui.map;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.ListView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MapContract {
    interface View extends BaseView {
        void addressInfo(String qu,String adCode,String address,double ltg,double lag);
    }

    interface Presenter extends BasePresenter<View> {
        void setLocationCallBack(Activity act, AMap aMap, ListView listView);
        void initListener(EditText et,ListView listview);
    }
}
