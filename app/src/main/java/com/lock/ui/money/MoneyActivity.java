package com.lock.ui.money;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;
import com.lock.ui.Splash;
import com.lock.utils.Tool;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoneyActivity extends MVPBaseActivity<MoneyContract.View, MoneyPresenter>
        implements MoneyContract.View {

    private MoneyPresenter presenter;
    private TextView tv_money;
    private TextView tv_ky;
    private TextView tv_yj;
    private ImageView see;

    @Override
    protected void initView() {
        presenter = new MoneyPresenter();
        presenter.attachView(this);
        tv_money = findViewById(R.id.tv_money);
        tv_ky = findViewById(R.id.tv_ky);
        tv_yj = findViewById(R.id.tv_yj);
        see = findViewById(R.id.see);
        see.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yanjin));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_money;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    private int click = 0;
    @OnClick({R.id.ll_Money, R.id.change_pass, R.id.change_pay_pass, R.id.rl_in, R.id.rl_out,
            R.id.close, R.id.bill, R.id.see})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.ll_Money:
                if (click == 0) {
                    click = 1;
                    presenter.bindAccount();
                }
                break;
            case R.id.change_pass:
                if (click == 0) {
                    click = 1;
                    presenter.changePass();
                }
                break;
            case R.id.rl_in:
                if (click == 0) {
                    click = 1;
                    presenter.moneyIn();
                }
                break;
            case R.id.rl_out:
                presenter.moneyOut(tv_yj);
                break;
            case R.id.change_pay_pass:
                if (click == 0) {
                    click = 1;
                    presenter.changePayPass();
                }
                break;
            case R.id.bill:
                if (click == 0) {
                    click = 1;
                    presenter.bill();
                }
                break;
            case R.id.see:
                boolean b = Splash.mk.decodeBool(Tool.canSee, true);
                if (b) {
                    Splash.mk.encode(Tool.canSee, false);
                    tv_money.setText("****");
                    tv_yj.setText("****");
                    tv_ky.setText("****");
                    see.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yanjin1));
                }else {
                    Splash.mk.encode(Tool.canSee, true);
                    tv_money.setText(m1);
                    tv_yj.setText(m3);
                    tv_ky.setText(m2);
                    see.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yanjin));
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setMoney(this);
        click = 0;
    }

    private String m1 = "0.0";
    private String m2 = "0.0";
    private String m3 = "0.0";
    @Override
    public void money(String m1, String m2, String m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        boolean b = Splash.mk.decodeBool(Tool.canSee, true);
        if (!b) {
            tv_money.setText("****");
            tv_yj.setText("****");
            tv_ky.setText("****");
            see.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yanjin1));
        }else {
            tv_money.setText(m1);
            tv_yj.setText(m3);
            tv_ky.setText(m2);
            see.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yanjin));
        }
    }
}
