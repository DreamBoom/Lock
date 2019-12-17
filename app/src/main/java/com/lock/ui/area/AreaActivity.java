package com.lock.ui.area;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.lock.R;
import com.lock.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 * @author wmx
 */

public class AreaActivity extends MVPBaseActivity<AreaContract.View, AreaPresenter> implements AreaContract.View {

    private AreaPresenter presenter;
    private MapView mapView;
    private EditText etJl;

    @Override
    protected void initView() {
        presenter = new AreaPresenter();
        presenter.attachView(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_area;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        AMap aMap = mapView.getMap();
        presenter.setLocationCallBack(this,aMap, 30);
        etJl = findViewById(R.id.et_jl);
    }

    @OnClick({R.id.close, R.id.right_menu, R.id.see})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.right_menu:
                //presenter.showMarker();
                break;

            case R.id.see:
                String trim = etJl.getText().toString().trim();
                presenter.showMarker(trim);
                break;
        }
    }
}
