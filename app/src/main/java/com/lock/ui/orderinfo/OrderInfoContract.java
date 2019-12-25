package com.lock.ui.orderinfo;

import android.app.Activity;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.lock.bean.FeeListBean;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

import java.util.ArrayList;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class OrderInfoContract {
    interface View extends BaseView {
        void time(String time);
        void state1();
        void delete();
        void cancel();
        void arrive();
        void end();
        void fee(String m,String m1,String m2);
    }

    interface  Presenter extends BasePresenter<View> {
        void startMain(Activity act);
        void startMessage(Activity act);
        void putInfo(Activity act,String phone,String orderId);
        void setLocationCallBack(Activity act, AMap aMap,double lat, double lgt, TextView tv,String orderId);
        void call(String phone,TextView view);
        void call(TextView view);
        void callMoney(String orderId);
        void stopTime(long time);
        void orderStart();
        void orderArrive();
        void orderEnd();
        void deleteOrder(TextView view,String orderId);
        void cancelOrder(TextView view,String orderId);
    }
}
