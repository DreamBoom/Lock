package com.lock.ui.lockup;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.lock.mvp.BasePresenter;
import com.lock.mvp.BaseView;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LockUpContract {
    interface View extends BaseView {
        void infoBack(int sex,String district,String cityCode, double longitude,double latitude
        ,String etPhone, String etName, String etNum, String etAddress, String etAddressInfo);
    }

    interface  Presenter extends BasePresenter<View> {
        void init(Activity act);
        void showAddress(Activity act);
        void next(Activity act,int goTo,String phone,String name,String num,
                  String address,String addressIfo,String qu,String adCode,String lgt,String lat);


    }
}
