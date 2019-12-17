package com.lock.ui.help.question;


import android.view.View;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class QuestionFragment extends MVPBaseFragment<QuestionContract.View, QuestionPresenter>
        implements QuestionContract.View {

    @Override
    protected int createView() {
        return R.layout.fragment_question;
    }

    @Override
    protected void initView(View view) { }

    @Override
    protected void initDate() {
        QuestionPresenter questionPresenter = new QuestionPresenter();
    }
}
