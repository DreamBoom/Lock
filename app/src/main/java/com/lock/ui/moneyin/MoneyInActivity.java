package com.lock.ui.moneyin;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoneyInActivity extends MVPBaseActivity<MoneyInContract.View, MoneyInPresenter>
        implements MoneyInContract.View {
    private MoneyInPresenter presenter;
    private EditText etMoney;
    private ImageView imZfb;
    private ImageView imWx;
    private TextView inMoney;
    private ImageView imAgree;

    @Override
    protected void initView() {
        presenter = new MoneyInPresenter();
        presenter.attachView(this);
        etMoney = findViewById(R.id.et_money);
        imZfb = findViewById(R.id.im_zfb);
        imWx = findViewById(R.id.im_wx);
        inMoney = findViewById(R.id.in_money);
        imAgree = findViewById(R.id.im_agree);
        presenter.init(etMoney,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_money_in;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    int agree = 1;
    @SuppressLint("SetTextI18n")
    @OnClick({R.id.back, R.id.r100, R.id.r200, R.id.r500, R.id.r1000, R.id.r2000, R.id.r5000,
            R.id.ll_zfb, R.id.ll_wx, R.id.im_agree, R.id.tv_agree, R.id.in_sure})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.r100:
                inMoney.setText("¥ 100元");
                etMoney.setText("100".toCharArray(), 0, "100".length());
                break;
            case R.id.r200:
                inMoney.setText("¥ 200元");
                etMoney.setText("200".toCharArray(), 0, "200".length());
                break;
            case R.id.r500:
                inMoney.setText("¥ 500元");
                etMoney.setText("500".toCharArray(), 0, "500".length());
                break;
            case R.id.r1000:
                inMoney.setText("¥ 1000元");
                etMoney.setText("1000".toCharArray(), 0, "1000".length());
                break;
            case R.id.r2000:
                inMoney.setText("¥ 2000元");
                etMoney.setText("2000".toCharArray(), 0, "2000".length());
                break;
            case R.id.r5000:
                inMoney.setText("¥ 5000元");
                etMoney.setText("5000".toCharArray(), 0, "5000".length());
                break;
            case R.id.ll_zfb:
                presenter.inType(1);
                imZfb.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                imWx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                break;
            case R.id.ll_wx:
                presenter.inType(2);
                imZfb.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                imWx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                break;
            case R.id.im_agree:
                if(agree == 2){
                    agree = 1;
                    presenter.agree(1);
                    imAgree.setImageDrawable(getResources().getDrawable(R.drawable.ico_yes));
                }else {
                    agree = 2;
                    presenter.agree(2);
                    imAgree.setImageDrawable(getResources().getDrawable(R.drawable.ico_yuan));
                }
                break;
            case R.id.tv_agree:

                break;
            case R.id.in_sure:
                String money = etMoney.getText().toString().trim();
                presenter.moneyIn(this,money);
                break;
        }
    }

    @Override
    public void moneyBack(String money) {
        inMoney.setText("¥ "+money+"元");
    }

    @Override
    public void success() {
        finish();
    }
}
