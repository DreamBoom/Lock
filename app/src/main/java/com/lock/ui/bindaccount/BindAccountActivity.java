package com.lock.ui.bindaccount;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BindAccountActivity extends MVPBaseActivity<BindAccountContract.View, BindAccountPresenter>
        implements BindAccountContract.View {

    private BindAccountPresenter presenter;
    private TextView tvTitle;

    @Override
    protected void initView() {
        presenter = new BindAccountPresenter();
        tvTitle = findViewById(R.id.tv_title);
        TextView rightMenu = findViewById(R.id.right_menu);
        ListView listView = findViewById(R.id.listView);
        tvTitle.setText("我的钱包");
        rightMenu.setVisibility(View.GONE);
        presenter.initData(this,listView);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bind_account;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.close, R.id.add_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.add_account:
                presenter.showPop(this,tvTitle);
                break;
        }
    }
}
