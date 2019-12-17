package com.lock.ui.main;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lock.bean.OrderListBean;
import com.lock.bean.OrderListBean.ModuleBean;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;
import com.lock.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        void  status0();
        void  status1();
        //state: 0 无订单  1有订单
        void  status2(int state);
        void  status3();
        void  status8();
        void  status9();
        void startWork();
        void stopWork();
        void orderList(ArrayList<ModuleBean> list);
    }

    interface  Presenter extends BasePresenter<View> {
        List<android.view.View> setGg(Activity act);
        void headerShow(Activity act);
        void toUser(Activity act);
        void toLockUp(Activity act);
        void toGg(Activity act,int i);
        void toOrder(Activity act);
        void toTv1(Activity act);
        void toTv2(Activity act, RelativeLayout view);
        void checkRest(Activity act,boolean rest);
    }
}
