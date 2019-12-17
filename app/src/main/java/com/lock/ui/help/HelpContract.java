package com.lock.ui.help;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

import java.util.ArrayList;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class HelpContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        ArrayList<Fragment> list();
        void call(Activity act, String phone, RelativeLayout view);
    }
}
