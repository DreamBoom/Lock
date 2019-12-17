package com.lock.ui.changepaypass;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ChangePayPassContract {
    interface View extends BaseView {
        void success();
    }

    interface  Presenter extends BasePresenter<View> {
        void getCode(Activity act, TextView send, TextView miao, EditText edit);
        void changePayPass(Activity act, String pass, String code);
    }
}
