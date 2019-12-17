package com.lock.ui.service;

import android.app.Activity;
import android.widget.TextView;

import com.lock.bean.FeeListBean;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ServiceContract {
    interface View extends BaseView {
        void money(String m3,String m4,String m5,String m6);
        void service(String type);
        void fee(String m,String m1,String m2,String m3,String m4,String m5,String m6,
                 ArrayList<FeeListBean.ModuleBean> list);
        void feeMoney(String fee);
    }

    interface  Presenter extends BasePresenter<View> {
        void pop(android.view.View view);
        void feePop(android.view.View view, ArrayList<FeeListBean.ModuleBean> list);
        void photo();
        void upPhoto();
        void call(String phone,TextView view);
        void init(Activity act,String orderId);
        void sure(Activity act,File f1,File f2,File f3,String orderId,String paymentType,
                  String m1,String m2,String m3,String m4,String m5,String m6);
    }
}
