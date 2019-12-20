package com.lock.ui.main;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lock.R;
import com.lock.adapter.OrderAdapter;
import com.lock.base.App;
import com.lock.bean.OrderListBean;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;
import com.lock.utils.UPMarqueeView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.lock.ui.Splash.mk;
public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View {
    private ActivityUtils utils;
    private Long firstTime = 0L;
    private MainPresenter mainPresenter;
    private ImageView banner;
    private RelativeLayout status1;
    private RelativeLayout status2;
    private RelativeLayout title;
    private RelativeLayout line3;
    private LinearLayout ll_button;
    private LinearLayout ll_order;
    private ImageView im_status2;
    private TextView tv_sta2;
    private TextView tv_sta1;
    private ListView mainList;
    private ImageView im_rest;
    private int state;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        App.addActivity(this);
        utils = new ActivityUtils(this);
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        UPMarqueeView gg = findViewById(R.id.gg);
        banner = findViewById(R.id.banner);
        im_rest = findViewById(R.id.rest);
        title = findViewById(R.id.title);
        status1 = findViewById(R.id.status1);
        status2 = findViewById(R.id.status2);
        ll_order = findViewById(R.id.ll_order);
        line3 = findViewById(R.id.line3);
        ll_button = findViewById(R.id.ll_button);
        im_status2 = findViewById(R.id.im_status2);
        tv_sta1 = findViewById(R.id.tv_sta1);
        tv_sta2 = findViewById(R.id.tv_sta2);
        mainList = findViewById(R.id.main_list);
        gg.setViews(mainPresenter.setGg(this));
        gg.setOnItemClickListener((position, view) -> mainPresenter.toGg(MainActivity.this,position));
    }

    @Override
    public void status0() {
        line3.setVisibility(View.VISIBLE);
        ll_button.setVisibility(View.VISIBLE);
        im_rest.setVisibility(View.GONE);
    }

    @Override
    public void status1() {
        status2.setVisibility(View.VISIBLE);
        im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_waiting));
        tv_sta1.setText("资料正在审核，点击修改");
        tv_sta2.setText("点击刷新审核进度");
        im_rest.setVisibility(View.GONE);
        banner.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        ll_button.setVisibility(View.GONE);
    }

    @Override
    public void status2(int state) {
        this.state = state;
        banner.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        ll_button.setVisibility(View.GONE);
        boolean rest = mk.decodeBool(Tool.rest, false);
        if (rest) {
            ll_order.setVisibility(View.GONE);
            status1.setVisibility(View.VISIBLE);
        } else {
            if (state == 1) {
                ll_order.setVisibility(View.VISIBLE);
                status1.setVisibility(View.GONE);
            } else {
                ll_order.setVisibility(View.GONE);
                status1.setVisibility(View.GONE);
                status2.setVisibility(View.VISIBLE);
                im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_lock03));
                tv_sta1.setText("暂无订单记录");
                tv_sta2.setText("赶紧上线接单就会有订单");
            }
        }
    }

    @Override
    public void status3() {
        status2.setVisibility(View.VISIBLE);
        im_rest.setVisibility(View.GONE);
        im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_modify));
        tv_sta1.setText("资料未通过审核");
        tv_sta2.setText("点击修改资料");
        banner.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        ll_button.setVisibility(View.GONE);
    }

    @Override
    public void status8() {
        status2.setVisibility(View.VISIBLE);
        im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_funds));
        tv_sta1.setText("账号异常");
        tv_sta2.setText("点击进行充值");
        im_rest.setEnabled(false);
        im_rest.setBackground(ContextCompat.getDrawable(this, R.drawable.xx));
        mk.encode(Tool.rest, true);
        banner.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        ll_button.setVisibility(View.GONE);
    }

    @Override
    public void status9() {
        status2.setVisibility(View.VISIBLE);
        im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_weigui));
        tv_sta1.setText("账号违规");
        tv_sta2.setText("点击联系客服");
        im_rest.setEnabled(false);
        im_rest.setBackground(ContextCompat.getDrawable(this, R.drawable.xx));
        mk.encode(Tool.rest, true);
        banner.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        ll_button.setVisibility(View.GONE);
    }

    @Override
    public void startWork() {
        im_rest.setEnabled(true);
        im_rest.setBackground(ContextCompat.getDrawable(this, R.drawable.jd));
        mk.encode(Tool.rest, false);
        if (state == 1) {
            ll_order.setVisibility(View.VISIBLE);
            status1.setVisibility(View.GONE);
        } else {
            ll_order.setVisibility(View.GONE);
            status1.setVisibility(View.GONE);
            status2.setVisibility(View.VISIBLE);
            im_status2.setBackground(ContextCompat.getDrawable(this, R.drawable.ico_lock03));
            tv_sta1.setText("暂无订单记录");
            tv_sta2.setText("赶紧上线接单就会有订单");
        }
    }

    @Override
    public void stopWork() {
        im_rest.setEnabled(true);
        im_rest.setBackground(ContextCompat.getDrawable(this, R.drawable.xx));
        mk.encode(Tool.rest, true);
        ll_order.setVisibility(View.GONE);
        status1.setVisibility(View.VISIBLE);
    }

    @Override
    public void orderList(ArrayList<OrderListBean.ModuleBean> list) {
        OrderAdapter adapter = new OrderAdapter(this, list, R.layout.main_item);
        mainList.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.header, R.id.rest, R.id.banner, R.id.tv_sta1, R.id.tv_sta2, R.id.more_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.header:
                mainPresenter.toUser(this);
                break;
            case R.id.rest:
                int i = mk.decodeInt(Tool.mstatus, -1);
                if (i != 9) {
                    boolean encode = mk.decodeBool(Tool.rest, false);
                    mainPresenter.checkRest(this, encode);
                } else {
                    utils.showToast("账号违规，状态不可修改");
                }
                break;
            case R.id.banner:
                mainPresenter.toLockUp(this);
                break;
            case R.id.tv_sta1:
                mainPresenter.toTv1(this);
                break;
            case R.id.tv_sta2:
                mainPresenter.toTv2(this, title);
                break;
            case R.id.more_order:
                mainPresenter.toOrder(this);
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                utils.showToast("再按一次退出程序");
                firstTime = secondTime;
                return false;
            } else {
                App.finishAll();
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.headerShow(this);
    }
}
