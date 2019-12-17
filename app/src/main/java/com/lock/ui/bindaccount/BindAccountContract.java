package com.lock.ui.bindaccount;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BindAccountContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void showPop(Activity act, android.view.View view);
        void initData(Activity act, ListView listView);
    }
}
