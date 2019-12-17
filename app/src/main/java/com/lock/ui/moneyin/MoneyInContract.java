package com.lock.ui.moneyin;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MoneyInContract {
    interface View extends BaseView {
        void moneyBack(String money);
        void success();
    }

    interface  Presenter extends BasePresenter<View> {
        void agree(int i);
        void inType(int inType);
        void init(EditText et, Activity act);
        void moneyIn( Activity act,String money);
    }
}
