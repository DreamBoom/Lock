package com.lock.ui.moneyout;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MoneyOutContract {
    interface View extends BaseView {
        void outMoney();
    }

    interface  Presenter extends BasePresenter<View> {
        void showPop(Activity act, android.view.View view,String money,int type);
        void outType(int type);
    }
}
