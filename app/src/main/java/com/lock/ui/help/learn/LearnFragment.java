package com.lock.ui.help.learn;


import android.view.View;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 * @author wmx
 */

public class LearnFragment extends MVPBaseFragment<LearnContract.View, LearnPresenter>
        implements LearnContract.View {

    @Override
    protected int createView() {
        return R.layout.fragment_learn;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initDate() {
        LearnPresenter learnPresenter = new LearnPresenter();
    }

}
