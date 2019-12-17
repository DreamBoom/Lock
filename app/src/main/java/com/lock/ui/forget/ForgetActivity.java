package com.lock.ui.forget;


import android.annotation.SuppressLint;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

@SuppressLint("Registered")
public class ForgetActivity extends MVPBaseActivity<ForgetContract.View, ForgetPresenter> implements ForgetContract.View {

    @Override
    protected int getLayout() {
        return R.layout.forget;
    }

    @Override
    protected void initView() {
        App.addActivity(this);
    }
}
