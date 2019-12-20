package com.lock.ui.help.learn;

import android.app.Activity;
import android.widget.ListView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

class LearnContract {
   interface View extends BaseView {
    }

    interface  Presenter extends BasePresenter<View> {
        void getList(Activity act, int i, ListView listview, boolean refresh);
    }
}
