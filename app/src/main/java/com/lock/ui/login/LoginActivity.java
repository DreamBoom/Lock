package com.lock.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.lock.R;
import com.lock.adapter.PagerAdapter;
import com.lock.base.App;
import com.lock.base.BaseActivity;
import com.lock.ui.login.message.MessageFragment;
import com.lock.ui.login.password.PasswordFragment;
import com.lock.utils.ActivityUtils;
import com.lock.utils.DepthPageTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    public static TabLayout mTab;
    private ActivityUtils utils;
    private Long firstTime = 0L;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        App.addActivity(this);
        utils = new ActivityUtils(this);
        mTab = findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PasswordFragment());
        fragments.add(new MessageFragment());
        PagerAdapter adapt = new PagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setPageTransformer(true, new DepthPageTransformer());
        viewpager.setAdapter(adapt);
        viewpager.addOnPageChangeListener(this);
        mTab.setUnboundedRipple(true);//点击的动画
        mTab.setTabIndicatorFullWidth(false);//下划线指示器的宽度不要填充完
        mTab.addTab(mTab.newTab().setText("密码登录"));
        mTab.addTab(mTab.newTab().setText("短信登录"));
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setTabGravity(TabLayout.GRAVITY_FILL);
        mTab.getTabAt(0).select();//默认选中
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

    //点击返回键两次退出程序
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
                System.exit(0);
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
