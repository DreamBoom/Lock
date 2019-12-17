package com.lock.ui.money;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MoneyContract {
    interface View extends BaseView {
        void  money(String m1,String m2,String m3);
    }

    interface  Presenter extends BasePresenter<View> {
        void bindAccount();
        void moneyIn();
        void moneyOut(TextView tv);
        void setMoney(Activity act);
        void changePass();
        void changePayPass();
        void bill();
    }
}
