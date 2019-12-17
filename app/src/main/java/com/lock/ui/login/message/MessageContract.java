package com.lock.ui.login.message;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
        void login(Activity act, String userName, String password);
        void agree(Activity act, ImageView img);
        void getCode(Activity act, TextView send,TextView miao,String phone,EditText edit);
    }
}
