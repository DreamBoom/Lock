package com.lock.ui.moneyoutok;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoneyOutOkActivity extends MVPBaseActivity<MoneyOutOkContract.View, MoneyOutOkPresenter>
        implements MoneyOutOkContract.View {

    @Override
    protected void initView() {
        TextView money = findViewById(R.id.money);
        money.setText("成功转出0元到指定账户");
    }

    @Override
    protected int getLayout() {
        return R.layout.money_out_ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.what, R.id.close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.what:

                break;
            case R.id.close:
                finish();
                break;
        }
    }
}
