package com.lock.ui.bill;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BillContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void initData(Activity act, ListView listView);
        void pop1(ListView listView);
        void pop2(ListView listView);
        void pop3(ListView listView);
    }
}
