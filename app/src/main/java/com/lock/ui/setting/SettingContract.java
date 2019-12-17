package com.lock.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

import java.util.ArrayList;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class SettingContract {
    interface View extends BaseView {
        void getMemory(long i,int type);
    }

    interface  Presenter extends BasePresenter<View> {
        void exit(Activity act);
        void help(Activity act);
        void setArea(Activity act);
        void clean(Activity act);
        void initMemory(Activity act);
    }
}
