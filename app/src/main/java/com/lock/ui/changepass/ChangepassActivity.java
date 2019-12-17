package com.lock.ui.changepass;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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

public class ChangepassActivity extends MVPBaseActivity<ChangepassContract.View, ChangepassPresenter>
        implements ChangepassContract.View {

    private ChangepassPresenter presenter;
    private EditText etOld;
    private EditText etNew;
    private ImageView imClose;
    private boolean canSee = false;
    @Override
    protected void initView() {
        App.addActivity(this);
        presenter = new ChangepassPresenter();
        presenter.attachView(this);
        etOld = findViewById(R.id.et_old);
        etNew = findViewById(R.id.et_new);
        imClose = findViewById(R.id.im_close);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_change;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.im_close, R.id.bt_change})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.im_close:
                if (canSee) {
                    canSee = false;
                    etNew.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imClose.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.close));
                    String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
                    Bitmap bm = BitmapFactory.decodeFile(path);
                    imClose.setImageBitmap(bm);
                    imClose.setImageResource(R.drawable.close);
                } else {
                    canSee = true;
                    etNew.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imClose.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.open));
                    String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
                    Bitmap bm = BitmapFactory.decodeFile(path);
                    imClose.setImageBitmap(bm);
                    imClose.setImageResource(R.drawable.open);
                }
                etOld.setSelection(etOld.getText().length());
                break;
            case R.id.bt_change:
                String oldPass = etOld.getText().toString().trim();
                String newPass = etNew.getText().toString().trim();
                presenter.changePass(this,oldPass,newPass);
                break;
        }
    }

    @Override
    public void success() {
        finish();
    }
}
