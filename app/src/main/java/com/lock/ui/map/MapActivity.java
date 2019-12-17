package com.lock.ui.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.MVPBaseActivity;
import com.lock.utils.LocationUtil;
import com.lock.utils.Tool;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MapActivity extends MVPBaseActivity<MapContract.View, MapPresenter>
        implements MapContract.View {
    private MapPresenter presenter;
    private MapView mapView;
    private AMap aMap;
    private ListView listView;
    private ListView searchList;
    private EditText et_search;

    @Override
    protected void initView() {
        App.addActivity(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_map;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        presenter = new MapPresenter();
        presenter.attachView(this);
        mapView = findViewById(R.id.map_view);
        et_search = findViewById(R.id.et_search);
        TextView title = findViewById(R.id.tv_title);
        TextView right_menu = findViewById(R.id.right_menu);
        listView = findViewById(R.id.map_list);
        searchList = findViewById(R.id.search_list);
        title.setText("选择地区");
        right_menu.setText("保存");
        mapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        presenter.setLocationCallBack(this, aMap, listView);
        presenter.initListener(et_search,searchList);
    }

    @OnClick({R.id.close, R.id.right_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.right_menu:
                Intent intent = new Intent();
                intent.putExtra("qu", qu);
                intent.putExtra("adCode", adCode);
                intent.putExtra("address", address);
                intent.putExtra("ltg", ltg);
                intent.putExtra("lag", lag);
                setResult(Tool.RESULT_SUCCESS, intent);
                finish();
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
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private String qu;
    private String adCode;
    private String address;
    private double ltg;
    private double lag;
    @Override
    public void addressInfo(String qu, String adCode, String address, double ltg, double lag) {
        this.qu = qu;
        this.adCode = adCode;
        this.address = address;
        this.ltg = ltg;
        this.lag = lag;
    }
}
