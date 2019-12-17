package com.lock.ui.user;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.DragPointView;
import com.lock.utils.Tool;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UserActivity extends MVPBaseActivity<UserContract.View, UserPresenter>
        implements UserContract.View, DragPointView.OnDragListencer {

    private UserPresenter presenter;
    private ImageView imLockStart;
    private ImageView imLockEnd;
    private TextView tvLockEnd;
    private TextView tvLockStart;
    private int count = 0;
    private TextView orderNum;

    @Override
    protected void initView() {
        App.addActivity(this);
        presenter = new UserPresenter();
        presenter.init(this);
        presenter.attachView(this);
        imLockStart = findViewById(R.id.im_lock_start);
        imLockEnd = findViewById(R.id.im_lock_end);
        tvLockEnd = findViewById(R.id.tv_lock_end);
        tvLockStart = findViewById(R.id.tv_lock_start);
        orderNum = findViewById(R.id.tv_order_num);
        DragPointView numView = findViewById(R.id.message_num);
        numView.setDragListencer(this);
        if (count == 0) {
            numView.setVisibility(View.GONE);
        } else if (count > 0 && count < 100) {
            numView.setVisibility(View.VISIBLE);
            numView.setText(String.valueOf(count));
        } else {
            numView.setVisibility(View.VISIBLE);
            numView.setText("99+");
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.user_order, R.id.ll_Money, R.id.ll_order, R.id.ll_setting, R.id.user_message, R.id.im_bj
            , R.id.im_lock_end, R.id.im_lock_start, R.id.header})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_order:
                presenter.Order(this);
                break;
            case R.id.ll_Money:
                presenter.money(this,tvLockStart);
                break;
            case R.id.ll_order:
                presenter.Order2(this);
                break;
            case R.id.ll_setting:
                presenter.setting(this);
                break;
            case R.id.user_message:
                presenter.message(this);
                break;
            case R.id.im_bj:
                presenter.lockUp(this);
                break;
            case R.id.im_lock_end:
                // imLockEnd.setBackground(ContextCompat.getDrawable(this,R.drawable.tbg));
                break;
            case R.id.im_lock_start:

                break;
            case R.id.header:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.init(this);
        //    boolean rest = mk.decodeBool(Tool.rest, false);
//        if (rest) {
//
//        } else {
//
//        }
    }

    @Override
    public void onDragOut() {

    }

    @Override
    public void orderNum(String i) {
        orderNum.setText(i);
    }
}
