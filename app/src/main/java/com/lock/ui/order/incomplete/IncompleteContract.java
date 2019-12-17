package com.lock.ui.order.incomplete;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import com.lock.adapter.OrderAdapter;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class IncompleteContract {
    interface View extends BaseView {
        void finish();
    }

    interface  Presenter extends BasePresenter<View> {
        void getList(Activity act, int i, ListView listview,boolean refresh);
    }
}
