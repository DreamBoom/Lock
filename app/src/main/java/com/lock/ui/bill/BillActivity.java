package com.lock.ui.bill;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BillActivity extends MVPBaseActivity<BillContract.View, BillPresenter>
        implements BillContract.View {

    private BillPresenter presenter;
    private ListView listPop;

    @Override
    protected void initView() {
        App.addActivity(this);
        presenter = new BillPresenter();
        presenter.attachView(this);
        ListView listView = findViewById(R.id.list_view);
        listPop = findViewById(R.id.list_pop);
        presenter.initData(this, listView);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bill;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.time, R.id.type, R.id.sx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.time:
                presenter.pop1(listPop);
                break;
            case R.id.type:
                presenter.pop2(listPop);
                break;
            case R.id.sx:
                presenter.pop3(listPop);
                break;
        }
    }
}
