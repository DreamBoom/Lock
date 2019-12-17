package com.lock.ui.lockup.person;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.TextView;

import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;

import java.io.File;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PersonContract {
    interface View extends BaseView {
        void success();
    }

    interface  Presenter extends BasePresenter<View> {
        void save(Activity act,String phone, String name, int sex, String num, String address, String addressInfo,
                  String qu, String adCode,String lgt,String lat);
        void photo(Activity act, TextView view);
        void upPhoto(Uri uri, int i);
    }
}
