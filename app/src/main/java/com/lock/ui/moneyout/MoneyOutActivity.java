package com.lock.ui.moneyout;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.MoneyInputFilter;
import com.lock.utils.Tool;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.lock.ui.Splash.mk;
import static java.lang.Double.valueOf;

public class MoneyOutActivity extends MVPBaseActivity<MoneyOutContract.View, MoneyOutPresenter>
        implements MoneyOutContract.View {

    private ImageView imZfb;
    private ImageView imWx;
    private EditText etMoney;
    private MoneyOutPresenter presenter;
    private RelativeLayout bar;
    private int type = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        presenter = new MoneyOutPresenter();
        presenter.attachView(this);
        TextView outMoney = findViewById(R.id.out_money);
        bar = findViewById(R.id.title);
        imZfb = findViewById(R.id.im_zfb);
        imWx = findViewById(R.id.im_wx);
        etMoney = findViewById(R.id.et_money);
        int i1 = mk.decodeInt(Tool.money, -1);
        double v = valueOf(i1) * 0.01;
        outMoney.setText("可提现金额:"+v+"元");
        MoneyInputFilter.MAX_VALUE = v;
        MoneyInputFilter moneyInputFilter = new MoneyInputFilter(this);
        InputFilter data[] = new InputFilter[1];
        data[0] = moneyInputFilter;
        etMoney.setFilters(data);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_money_out;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.what, R.id.ll_zfb, R.id.ll_wx, R.id.all_out, R.id.sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.what:

                break;
            case R.id.ll_zfb:
                presenter.outType(1);
                imZfb.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                imWx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                break;
            case R.id.ll_wx:
                presenter.outType(2);
                imZfb.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                imWx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                break;
            case R.id.all_out:
                int i1 = mk.decodeInt(Tool.money, 0);
                double v = valueOf(i1) * 0.01;
                String s = String.valueOf(v);
                etMoney.setText(s.toCharArray(), 0, s.length());
                break;
            case R.id.sure:
                presenter.showPop(this,bar,etMoney.getText().toString().trim(),type);
                break;
        }
    }

    @Override
    public void outMoney() {
        Toast.makeText(this, "已提交提现申请", Toast.LENGTH_LONG).show();
        finish();
    }
}
