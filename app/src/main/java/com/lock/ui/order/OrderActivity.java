package com.lock.ui.order;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.lock.R;
import com.lock.adapter.PagerAdapter;
import com.lock.base.App;
import com.lock.ui.order.history.HistoryFragment;
import com.lock.ui.order.incomplete.IncompleteFragment;
import com.lock.utils.ActivityUtils;
import com.lock.utils.DepthPageTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    public static TabLayout mTab;
    private ActivityUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        App.addActivity(this);
        utils = new ActivityUtils(this);
        mTab = findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new IncompleteFragment());
        fragments.add(new HistoryFragment());
        PagerAdapter adapt = new PagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setPageTransformer(true, new DepthPageTransformer());
        viewpager.setAdapter(adapt);
        viewpager.addOnPageChangeListener(this);
        mTab.setUnboundedRipple(true);//点击的动画
        mTab.setTabIndicatorFullWidth(false);//下划线指示器的宽度不要填充完
        mTab.addTab(mTab.newTab().setText("未完成订单"));
        mTab.addTab(mTab.newTab().setText("历史订单"));
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setTabGravity(TabLayout.GRAVITY_FILL);
        int site = getIntent().getIntExtra("site", 0);
        mTab.getTabAt(site).select();//默认选中
        mTab.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (viewpager.getCurrentItem()) {
                case 0:
                    mTab.getTabAt(0).select();
                    break;
                case 1:
                    mTab.getTabAt(1).select();
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @OnClick({R.id.back, R.id.phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.phone:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18061420000"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}

