package com.lock.ui.lockup.person;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;
import com.zhihu.matisse.Matisse;

import org.xutils.image.ImageOptions;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonActivity extends MVPBaseActivity<PersonContract.View, PersonPresenter> implements PersonContract.View {

    private TextView tv_title;
    private TextView right_menu;
    private PersonPresenter presenter;
    private ImageOptions options;
    private String phone, name, num, address, addressInfo, qu, adCode, lgt, lat;
    private int sex;
    private int take = 0; //图片类型 0 手持身份证 1 身份证正面 2 身份证反面
    private ImageView sc,zm,fm;

    @Override
    protected void initView() {
        App.addActivity(this);
        qu = getIntent().getStringExtra("qu");
        adCode = getIntent().getStringExtra("adCode");
        lgt = getIntent().getStringExtra("lgt");
        lat = getIntent().getStringExtra("lat");
        phone = getIntent().getStringExtra("phone");
        name = getIntent().getStringExtra("name");
        num = getIntent().getStringExtra("num");
        sex = getIntent().getIntExtra("sex", 0);
        address = getIntent().getStringExtra("address");
        addressInfo = getIntent().getStringExtra("addressInfo");
        presenter = new PersonPresenter();
        tv_title = findViewById(R.id.tv_title);
        right_menu = findViewById(R.id.right_menu);
        sc = findViewById(R.id.sc);
        zm = findViewById(R.id.zm);
        fm = findViewById(R.id.fm);
        right_menu.setText("保存");
        options = new ImageOptions.Builder()
                .setConfig(Bitmap.Config.ARGB_8888)
                .setSquare(true)
                .setCrop(false)
                .setFadeIn(true)
                .setCircular(false)
                .build();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lockup_ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.close,R.id.take_sfz, R.id.take_zm, R.id.take_fm, R.id.right_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.take_sfz:
                take = 0;
                presenter.photo(this, tv_title);
                break;
            case R.id.take_zm:
                take = 1;
                presenter.photo(this, tv_title);
                break;
            case R.id.take_fm:
                take = 2;
                presenter.photo(this, tv_title);
                break;
            case R.id.right_menu:
                presenter.save(this,phone, name, sex, num, address, addressInfo,qu,adCode,lgt,lat);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201 && resultCode == RESULT_OK) {
            List<Uri> mSelected = Matisse.obtainResult(data);
            Uri uri = mSelected.get(0);
            presenter.upPhoto(mSelected.get(0), take);
            switch (take){
                case 0:
                    sc.setVisibility(View.VISIBLE);
                    sc.setImageURI(uri);
                    break;
                case 1:
                    zm.setVisibility(View.VISIBLE);
                    zm.setImageURI(uri);
                    break;
                case 2:
                    fm.setVisibility(View.VISIBLE);
                    fm.setImageURI(uri);
                    break;
            }
        }
    }

    @Override
    public void success() {
        finish();
    }
}
