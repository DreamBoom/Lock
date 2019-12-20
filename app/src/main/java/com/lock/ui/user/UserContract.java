package com.lock.ui.user;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class UserContract {
    interface View extends BaseView {
        void orderNum(String i);
        void startWork();
        void stopWork();
    }

    interface  Presenter extends BasePresenter<View> {
        void init(Activity act);
        void Order(Activity act);
        void Order2(Activity act);
        void lockUp(Activity act);
        void setting(Activity act);
        void message(Activity act);
        void money(Activity act, TextView tv);
        void checkRest(Activity act,boolean rest);
    }
}
