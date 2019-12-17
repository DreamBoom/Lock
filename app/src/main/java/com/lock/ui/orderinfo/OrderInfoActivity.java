package com.lock.ui.orderinfo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.lock.R;
import com.lock.base.App;
import com.lock.bean.FeeListBean;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.LogUtil;

import org.xutils.x;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class OrderInfoActivity extends MVPBaseActivity<OrderInfoContract.View, OrderInfoPresenter>
        implements OrderInfoContract.View {
    private OrderInfoPresenter presenter;
    private MapView mapView;
    private TextView jl;
    private String mobile;
    private String orderId;
    private RelativeLayout r1;
    private RelativeLayout r2;
    private RelativeLayout r3;
    private RelativeLayout r4;
    private RelativeLayout r5;
    private RelativeLayout r6;
    private RelativeLayout r7;
    private TextView tv_minute;
    private TextView tv_second;
    private TextView order_num;
    private TextView r7_fy;
    private TextView r7_time;
    private String money;
    private String im1;
    private String im2;
    private String im3;
    private TextView money1;
    private TextView money2;
    private TextView all_money;
    private TextView r6Money;

    @Override
    protected void initView() {
        App.addActivity(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_order_info;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        presenter = new OrderInfoPresenter();
        presenter.attachView(this);
        mapView = findViewById(R.id.order_map);
        jl = findViewById(R.id.jl);
        mapView.onCreate(savedInstanceState);
        TextView address = findViewById(R.id.address);
        tv_minute = findViewById(R.id.tv_minute);
        tv_second = findViewById(R.id.tv_second);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        r7 = findViewById(R.id.r7);
        order_num = findViewById(R.id.order_num);
        r6Money = findViewById(R.id.r6_money);
        r7_fy = findViewById(R.id.r7_fy);
        r7_time = findViewById(R.id.r7_time);
        all_money = findViewById(R.id.all_money);
        money1 = findViewById(R.id.money1);
        money2 = findViewById(R.id.money2);
        ImageView r4_img1 = findViewById(R.id.r4_img1);
        ImageView r4_img2 = findViewById(R.id.r4_img2);
        ImageView r4_img3 = findViewById(R.id.r4_img3);
        int state = getIntent().getIntExtra("state", 0);
        mobile = getIntent().getStringExtra("mobile");
        long startTime = getIntent().getLongExtra("startTime", 0);
        orderId = getIntent().getStringExtra("orderId");
        money = getIntent().getStringExtra("money");
        String createTime = getIntent().getStringExtra("createTime");
        String addressName = getIntent().getStringExtra("addressName");
        im1 = getIntent().getStringExtra("im1");
        im2 = getIntent().getStringExtra("im2");
        im3 = getIntent().getStringExtra("im3");
        TextView address_name = findViewById(R.id.address_name);
        address_name.setText("   " + addressName);
        switch (state) {
            case 1:
                //待出发
                address.setText("等待服务");
                r1.setVisibility(View.VISIBLE);
                break;
            case 2:
                //已出发
                address.setText("等待服务");
                presenter.stopTime(startTime);
                r2.setVisibility(View.VISIBLE);
                break;
            case 3:
                //待填写服务项
                r3.setVisibility(View.VISIBLE);
                address.setText("订单详情");
                break;
            case 4:
                //待客户审核服务项
                r4.setVisibility(View.VISIBLE);
                x.image().bind(r4_img1, im1);
                x.image().bind(r4_img2, im2);
                x.image().bind(r4_img3, im3);
                address.setText("订单详情");
                break;
            case 5:
                //待客户确认
                //已核实服务项
                r5.setVisibility(View.VISIBLE);
                address.setText("订单详情");
                break;
            case 6:
                //等待付款
                r6.setVisibility(View.VISIBLE);
                address.setText("订单详情");
                break;
            case 7:
                //锁匠取消
                r7.setVisibility(View.VISIBLE);
                order_num.setText("订单编号: " + orderId);
                r7_fy.setText("费用: " + money + "元");
                r7_time.setText("下单时间: " + createTime);
                address.setText("订单取消");
                break;
            case 8:
                //服务结束
                r7.setVisibility(View.VISIBLE);
                order_num.setText("订单编号: " + orderId);
                r7_fy.setText("费用: " + money + "元");
                r7_time.setText("下单时间: " + createTime);
                address.setText("订单完成");
                break;
            default:
                address.setText("订单详情");
                break;
        }

        SeekBar seekBar = findViewById(R.id.progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() != seekBar.getMax()) {
                    seekBar.setProgress(0);
                } else {
                    presenter.orderStart();
                }
            }
        });

        SeekBar seekBar1 = findViewById(R.id.progress1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() != seekBar.getMax()) {
                    seekBar.setProgress(0);
                } else {
                    presenter.orderArrive();
                }
            }
        });

        SeekBar seekBar5 = findViewById(R.id.progress5);
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() != seekBar.getMax()) {
                    seekBar.setProgress(0);
                } else {
                    seekBar.setProgress(0);
                    presenter.orderEnd();
                }
            }
        });


        AMap aMap = mapView.getMap();
        double lat = getIntent().getDoubleExtra("lat", 0);
        double lgt = getIntent().getDoubleExtra("lgt", 0);
        presenter.setLocationCallBack(this, aMap, lat, lgt, jl, orderId);
    }

    private int click = 0;

    @OnClick({R.id.main, R.id.message, R.id.phone, R.id.r3_put_info, R.id.r7_call, R.id.r7_delete,
            R.id.r3_cancel, R.id.r4_change, R.id.r4_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main:
                if (click == 0) {
                    click = 1;
                    presenter.startMain(this);
                    finish();
                }
                break;
            case R.id.message:
                if (click == 0) {
                    click = 1;
                    presenter.startMessage(this);
                }
                break;
            case R.id.phone:
            case R.id.r7_call:
                presenter.call(mobile, jl);
                break;
            case R.id.r7_delete:
                presenter.deleteOrder(jl, orderId);
                break;
            case R.id.r4_change:
            case R.id.r3_put_info:
                if (click == 0) {
                    click = 1;
                    presenter.putInfo(this, mobile, orderId);
                }
                break;
            case R.id.r4_start:
                r4.setVisibility(View.GONE);
                r5.setVisibility(View.VISIBLE);
                break;
            case R.id.r3_cancel:
                presenter.cancelOrder(jl, orderId);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁地图
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //重新绘制加载地图
        mapView.onResume();
        click = 0;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void time(String time) {
        String[] split = time.split(":");
        tv_minute.setText(split[0]);
        tv_second.setText(split[1]);
    }

    @Override
    public void state1() {
        r1.setVisibility(View.GONE);
        r2.setVisibility(View.VISIBLE);
    }

    @Override
    public void delete() {
        finish();
    }

    @Override
    public void cancel() {
        finish();
    }

    @Override
    public void arrive() {
        r2.setVisibility(View.GONE);
        r3.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void end() {
        r5.setVisibility(View.GONE);
        r6.setVisibility(View.VISIBLE);
        r6Money.setText("费用"+m+"元");
    }
    private String m = "";
    @SuppressLint("SetTextI18n")
    @Override
    public void fee(String m,String m1,String m2) {
        this.m = m;
        all_money.setText("费用: " + m + "元");
        money1.setText("上门费: " + m1);
        money2.setText("开锁费: " + m2);
    }
}
