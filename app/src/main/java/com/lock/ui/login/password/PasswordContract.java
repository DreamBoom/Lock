package com.lock.ui.login.password;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.widget.EditText;
import android.widget.ImageView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PasswordContract {

    interface View extends BaseView {


    }

    interface Presenter extends BasePresenter<View> {
        void login(Activity act,String userName, String password);
        void agree(Activity act,ImageView img);
        void canSee(Activity act, EditText edit,ImageView img);
        void forget(Activity act);
        void web(Activity act);
    }
}
