package com.lock.ui.message;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lock.R;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 */

public class MessageActivity extends MVPBaseActivity<MessageContract.View, MessagePresenter> implements MessageContract.View {

    private LinearLayout choose;
    private MessagePresenter presenter;
    private ListView list;
    private ActivityUtils utils;

    @Override
    protected void initView() {
        presenter = new MessagePresenter();
        presenter.attachView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        utils = new ActivityUtils(this);
        choose = findViewById(R.id.choose);
        list = findViewById(R.id.list_ms);
        presenter.init(this,list);
    }

    private int click = 0;
    @OnClick({R.id.more, R.id.sys, R.id.setting,R.id.close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more:
                if(choose.getVisibility() == View.GONE){
                    choose.setVisibility(View.VISIBLE);
                }else {
                    choose.setVisibility(View.GONE);
                }
                break;
            case R.id.sys:
                if (click == 0) {
                    click = 1;
                    presenter.toSys();
                }
                break;
            case R.id.setting:
                if (click == 0) {
                    click = 1;
                    presenter.toSetting();
                }
                break;
            case R.id.close:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        click = 0;
    }
}
