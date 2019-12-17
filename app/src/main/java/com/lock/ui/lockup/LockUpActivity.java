package com.lock.ui.lockup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionNo;
import com.yanzhenjie.permission.PermissionYes;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LockUpActivity extends MVPBaseActivity<LockUpContract.View, LockUpPresenter>
        implements LockUpContract.View {
    private ActivityUtils utils;
    private ImageView imPeople;
    private ImageView imCompany;
    private EditText et_phone;
    private EditText et_name;
    private EditText et_num;
    private EditText et_address;
    private EditText et_address_info;
    private LockUpPresenter presenter;
    private int sex = 0;
    private String qu;
    private String adCode;
    private String address;
    private double ltg;
    private double lag;

    @Override
    protected void initView() {
        App.addActivity(this);
        imPeople = findViewById(R.id.im_people);
        imCompany = findViewById(R.id.im_company);
        et_phone = findViewById(R.id.et_phone);
        et_name = findViewById(R.id.et_name);
        et_num = findViewById(R.id.et_num);
        et_address = findViewById(R.id.et_address);
        et_address_info = findViewById(R.id.et_address_info);
        utils = new ActivityUtils(this);
        presenter = new LockUpPresenter();
        presenter.init(this);
        presenter.attachView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lockup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.im_people, R.id.im_company, R.id.et_address, R.id.close, R.id.right_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_people:
                sex = 0;
                imPeople.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                imCompany.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                break;
            case R.id.im_company:
                sex = 1;
                imPeople.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
                imCompany.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
                break;
            case R.id.et_address:
                presenter.showAddress(this);
                break;
            case R.id.close:
                finish();
                break;
            case R.id.right_menu:
                String phone = et_phone.getText().toString().trim();
                String name = et_name.getText().toString().trim();
                String num = et_num.getText().toString().trim();
                String address = et_address.getText().toString().trim();
                String addressInfo = et_address_info.getText().toString().trim();
                String lgt = String.valueOf(ltg);
                String lat = String.valueOf(lag);
                presenter.next(this, sex, phone, name, num, address, addressInfo, qu, adCode, lgt, lat);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Tool.RESULT_SUCCESS) {
            return;
        }
        if (requestCode == Tool.forMap) {
            qu = data.getStringExtra("qu");
            adCode = data.getStringExtra("adCode");
            address = data.getStringExtra("address");
            ltg = data.getDoubleExtra("ltg", 0);
            lag = data.getDoubleExtra("lag", 0);
            et_address.setText(address.toCharArray(), 0, address.length());
        }
    }

    @Override
    public void infoBack(int sex,String district, String cityCode, double longitude, double latitude
            ,String etPhone, String etName, String etNum, String etAddress, String etAddressInfo) {
        if(sex == 0){
            imPeople.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
            imCompany.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
        }else {
            imPeople.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yuan));
            imCompany.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_yes));
        }
        qu = district;
        adCode = cityCode;
        ltg = longitude;
        lag = latitude;
        et_phone.setText(etPhone.toCharArray(), 0, etPhone.length());
        et_name.setText(etName.toCharArray(), 0, etName.length());
        et_num.setText(etNum.toCharArray(), 0, etNum.length());
        et_address.setText(etAddress.toCharArray(), 0, etAddress.length());
        et_address_info.setText(etAddressInfo.toCharArray(), 0, etAddressInfo.length());
    }
}
