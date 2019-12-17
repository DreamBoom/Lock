package com.lock.ui.changepaypass;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ChangePayPassActivity extends MVPBaseActivity<ChangePayPassContract.View, ChangePayPassPresenter> implements ChangePayPassContract.View {

    private ChangePayPassPresenter presenter;
    private EditText etPass;
    private EditText etCode;
    private ImageView imClose;
    private TextView tvDjs;
    private TextView sendCode;
    private boolean canSee = false;
    @Override
    protected void initView() {
        App.addActivity(this);
        presenter = new ChangePayPassPresenter();
        presenter.attachView(this);
        etPass = findViewById(R.id.et_pass);
        etCode = findViewById(R.id.et_code);
        imClose = findViewById(R.id.im_close);
        tvDjs = findViewById(R.id.tv_djs);
        sendCode = findViewById(R.id.send_code);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pay_pass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.close, R.id.im_close, R.id.send_code, R.id.bt_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.im_close:
                if (canSee) {
                    canSee = false;
                    etPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imClose.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.close));
                    String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
                    Bitmap bm = BitmapFactory.decodeFile(path);
                    imClose.setImageBitmap(bm);
                    imClose.setImageResource(R.drawable.close);
                } else {
                    canSee = true;
                    etPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imClose.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.open));
                    String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
                    Bitmap bm = BitmapFactory.decodeFile(path);
                    imClose.setImageBitmap(bm);
                    imClose.setImageResource(R.drawable.open);
                }
                etPass.setSelection(etPass.getText().length());
                break;
            case R.id.send_code:
                presenter.getCode(this,sendCode,tvDjs,etCode);
                break;
            case R.id.bt_sure:
                String pass = etPass.getText().toString().trim();
                String code = etCode.getText().toString().trim();
                presenter.changePayPass(this,pass,code);
                break;
        }
    }

    @Override
    public void success() {
        finish();
    }
}
