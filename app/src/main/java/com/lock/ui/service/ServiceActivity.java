package com.lock.ui.service;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lock.R;
import com.lock.bean.FeeListBean;
import com.lock.mvp.MVPBaseActivity;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.BitmapUtils;
import com.lock.utils.MoneyInputFilter;
import com.zhihu.matisse.Matisse;

import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ServiceActivity extends MVPBaseActivity<ServiceContract.View, ServicePresenter> implements ServiceContract.View {

    private ImageView im_xs, im_xx, imAgree, im1, im2, im3, close1, close2, close3;
    private ServicePresenter presenter;
    private TextView tv_title, tv_m1, tv_m2, tv_m3, tv_m4, tv_m5, tv_m6, tv1, tv2, tv3;
    private ActivityUtils utils;
    private File f3, f1, f2;
    private String phone;
    private String orderId;
    private TextView in_money;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;
    private LinearLayout l6;
    private String paymentType = "1";
    @Override
    protected void initView() {
        presenter = new ServicePresenter();
        presenter.attachView(this);
        utils = new ActivityUtils(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_service;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        phone = getIntent().getStringExtra("phone");
        orderId = getIntent().getStringExtra("orderId");
        in_money = findViewById(R.id.in_money);
        im_xs = findViewById(R.id.im_xs);
        im_xx = findViewById(R.id.im_xx);
        tv_title = findViewById(R.id.tv_title);
        imAgree = findViewById(R.id.im_agree);
        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        close1 = findViewById(R.id.close1);
        close2 = findViewById(R.id.close2);
        close3 = findViewById(R.id.close3);
        tv_m1 = findViewById(R.id.m1);
        tv_m2 = findViewById(R.id.m2);
        tv_m3 = findViewById(R.id.m3);
        tv_m4 = findViewById(R.id.m4);
        tv_m5 = findViewById(R.id.m5);
        tv_m6 = findViewById(R.id.m6);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);
        presenter.init(this, orderId);
    }

    int agree = 1;

    @OnClick({R.id.back, R.id.phone, R.id.im_xs, R.id.im_xx, R.id.im_bj, R.id.im_ks, R.id.pz, R.id.im_agree,
            R.id.tv_agree, R.id.in_sure, R.id.close1, R.id.close2, R.id.close3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.phone:
                presenter.call(phone, tv_title);
                break;
            case R.id.im_xs:
                paymentType = "1";
                im_xs.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                im_xx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                break;
            case R.id.im_xx:
                paymentType = "2";
                im_xx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                im_xs.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                break;
            case R.id.im_bj:
                presenter.pop(im_xs);
                break;
            case R.id.im_ks:
                presenter.feePop(im_xs, list);
                break;
            case R.id.pz:
                presenter.photo();
                break;
            case R.id.im_agree:
                if (agree == 2) {
                    agree = 1;
                    imAgree.setImageDrawable(getResources().getDrawable(R.drawable.ico_yes));
                } else {
                    agree = 2;
                    imAgree.setImageDrawable(getResources().getDrawable(R.drawable.ico_yuan));
                }
                break;
            case R.id.tv_agree:

                break;
            case R.id.in_sure:
                String m1 = tv_m1.getText().toString().trim();
                String m2 = tv_m2.getText().toString().trim();
                String m3 = tv_m3.getText().toString().trim();
                String m4 = tv_m4.getText().toString().trim();
                String m5 = tv_m5.getText().toString().trim();
                String m6 = tv_m6.getText().toString().trim();
                presenter.sure(this,f1,f2,f3,orderId,paymentType,m1,m2,m3,m4,m5,m6);
                break;
            case R.id.close1:
                im1.setVisibility(View.GONE);
                close1.setVisibility(View.GONE);
                tv1.setVisibility(View.VISIBLE);
                f1 = null;
                break;
            case R.id.close2:
                im2.setVisibility(View.GONE);
                close2.setVisibility(View.GONE);
                tv2.setVisibility(View.VISIBLE);
                f2 = null;
                break;
            case R.id.close3:
                im3.setVisibility(View.GONE);
                close3.setVisibility(View.GONE);
                tv3.setVisibility(View.VISIBLE);
                f3 = null;
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201 && resultCode == RESULT_OK) {
            List<Uri> mSelected = Matisse.obtainResult(data);
            Uri uri = mSelected.get(0);
            presenter.upPhoto();
            Bitmap bitm = null;
            try {
                bitm = BitmapUtils.uriToBitmap(this, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //图片压缩
            Bitmap bitmap = BitmapUtils.compressScale(bitm);
            if (f1 == null) {
                f1 = BitmapUtils.bitToFile(bitmap);
                im1.setVisibility(View.VISIBLE);
                im1.setImageURI(uri);
                close1.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.GONE);
            } else if (f2 == null) {
                f2 = BitmapUtils.bitToFile(bitmap);
                im2.setVisibility(View.VISIBLE);
                im2.setImageURI(uri);
                close2.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.GONE);
            } else if (f3 == null) {
                f3 = BitmapUtils.bitToFile(bitmap);
                im3.setVisibility(View.VISIBLE);
                im3.setImageURI(uri);
                close3.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.GONE);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void money(String m3, String m4, String m5, String m6) {
        double o = Double.valueOf(tv_m1.getText().toString().trim())
                + Double.valueOf(tv_m2.getText().toString().trim())
                + Double.valueOf(m3)
                + Double.valueOf(m4)
                + Double.valueOf(m5)
                + Double.valueOf(m6);
        in_money.setText("" + o);
        if (!m3.equals("0")) {
            l3.setVisibility(View.VISIBLE);
            tv_m3.setText(utils.save2(Double.valueOf(m3)));
        } else {
            l3.setVisibility(View.GONE);
            tv_m3.setText(m3);
        }
        if (!m4.equals("0")) {
            l4.setVisibility(View.VISIBLE);
            tv_m4.setText(utils.save2(Double.valueOf(m4)));
        } else {
            l4.setVisibility(View.GONE);
            tv_m4.setText(m4);
        }
        if (!m5.equals("0")) {
            l5.setVisibility(View.VISIBLE);
            tv_m5.setText(utils.save2(Double.valueOf(m5)));
        } else {
            l5.setVisibility(View.GONE);
            tv_m5.setText(m5);
        }
        if (!m6.equals("0")) {
            l6.setVisibility(View.VISIBLE);
            tv_m6.setText(utils.save2(Double.valueOf(m6)));
        } else {
            l6.setVisibility(View.GONE);
            tv_m6.setText(m6);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void service(String type) {
        if (type.equals("1")) {
            im_xs.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
            im_xx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
        } else {
            im_xx.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
            im_xs.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
        }
    }

    private ArrayList<FeeListBean.ModuleBean> list;

    @SuppressLint("SetTextI18n")
    @Override
    public void fee(String m,String m1,String m2,String m3,String m4,String m5,String m6, ArrayList<FeeListBean.ModuleBean> list) {
        this.list = list;
        tv_m1.setText(m1);
        in_money.setText(m);
        tv_m2.setText(m2);
        if(!m3.equals("0.0")){
            l3.setVisibility(View.VISIBLE);
            tv_m3.setText(m3);
        }
        if(!m4.equals("0.0")){
            l4.setVisibility(View.VISIBLE);
            tv_m4.setText(m4);
        }
        if(!m5.equals("0.0")){
            l5.setVisibility(View.VISIBLE);
            tv_m5.setText(m5);
        }
        if(!m6.equals("0.0")){
            l6.setVisibility(View.VISIBLE);
            tv_m6.setText(m6);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void feeMoney(String fee) {
        String trim1 = in_money.getText().toString().trim();
        String trim2 = tv_m2.getText().toString().trim();
        Double aDouble1 = Double.valueOf(trim1);
        Double aDouble2 = Double.valueOf(trim2);
        Double aDouble3 = Double.valueOf(fee);
        double i = aDouble1 - aDouble2 + aDouble3;
        tv_m2.setText(fee);
        in_money.setText("" + i);
    }
}
