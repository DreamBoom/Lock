package com.lock.ui.message;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MessageContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void init(Activity act,ListView listview);
        void toSetting();
        void toSys();
    }
}
