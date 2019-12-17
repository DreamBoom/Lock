package com.lock.ui.help;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.lock.R;
import com.lock.adapter.PagerAdapter;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.DepthPageTransformer;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HelpActivity extends MVPBaseActivity<HelpContract.View, HelpPresenter>
        implements HelpContract.View, RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    private HelpPresenter presenter;
    private ViewPager viewpager;
    private TabLayout mTab;
    private RelativeLayout title;

    @Override
    protected void initView() {
        presenter = new HelpPresenter();
        presenter.attachView(this);
        App.addActivity(this);
        mTab = findViewById(R.id.tab);
        viewpager = findViewById(R.id.viewpager);
        viewpager.setPageTransformer(true, new DepthPageTransformer());
        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager(), presenter.list()));
        viewpager.addOnPageChangeListener(this);
        mTab.setUnboundedRipple(true);//点击的动画
        mTab.setTabIndicatorFullWidth(false);//下划线指示器的宽度不要填充完
        mTab.addTab(mTab.newTab().setText("常见问题"));
        mTab.addTab(mTab.newTab().setText("教学资料"));
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setTabGravity(TabLayout.GRAVITY_FILL);
        mTab.getTabAt(0).select();//默认选中
        mTab.addOnTabSelectedListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_help;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title = findViewById(R.id.title);
    }

    @OnClick({R.id.back, R.id.call})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.call:
                presenter.call(this,"18888888888",title);
                break;
        }
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
}
