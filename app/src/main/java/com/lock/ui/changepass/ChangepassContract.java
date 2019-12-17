package com.lock.ui.changepass;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ChangepassContract {
    interface View extends BaseView {
        void success();
    }

    interface  Presenter extends BasePresenter<View> {
        void changePass(Activity act, String oldPass, String newPass);
    }
}
