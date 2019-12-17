package com.lock.ui.setting;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SettingActivity extends MVPBaseActivity<SettingContract.View, SettingPresenter>
        implements SettingContract.View{

    private SettingPresenter presenter;
    private TextView memory;

    @Override
    protected void initView() {
        memory = findViewById(R.id.memory);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        App.addActivity(this);
        presenter = new SettingPresenter();
        presenter.attachView(this);
        presenter.initMemory(this);
    }

    private int click = 0;
    @OnClick({R.id.user_info, R.id.area, R.id.cache, R.id.version, R.id.help, R.id.about, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_info:
                Toast.makeText(this,"敬请期待",Toast.LENGTH_LONG).show();
                break;
            case R.id.area:
                presenter.setArea(this);
                break;
            case R.id.cache:
                presenter.clean(this);
                break;
            case R.id.version:
                Toast.makeText(this,"已是最新版本",Toast.LENGTH_LONG).show();
                break;
            case R.id.help:
                presenter.help(this);
                break;
            case R.id.about:
                Toast.makeText(this,"敬请期待",Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                presenter.exit(this);
                break;
        }
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void getMemory(long i,int p) {
        if(p == 0){
            memory.setText("已使用"+i+"MB  ");
        }else {
            Toast.makeText(this,"已请理至最佳状态",Toast.LENGTH_LONG).show();
            memory.setText("已使用"+i+"MB  ");
        }
    }
}
