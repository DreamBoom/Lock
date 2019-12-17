package com.lock.ui.map;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.lock.R;
import com.lock.adapter.MapAdapter;
import com.lock.adapter.SearchAdapter;
import com.lock.bean.LocationInfo;
import com.lock.mvp.BasePresenterImpl;
import com.lock.utils.ActivityUtils;
import com.lock.utils.LocationUtil;

import java.util.ArrayList;
import java.util.List;

import kotlin.contracts.Returns;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MapPresenter extends BasePresenterImpl<MapContract.View>
        implements MapContract.Presenter, PoiSearch.OnPoiSearchListener, LocationSource {
    private Activity act;
    private ArrayList<PoiItem> list = new ArrayList<>();
    private MapAdapter mapAdapter;
    private SearchAdapter searchAdapter;
    private int oldPosition = 0;
    private LocationUtil locationUtil;
    private ActivityUtils utils;
    private String keyWord = "";// 要输入的poi搜索关键字
    private PoiSearch.Query query;// Poi查询条件类
    private PoiSearch poiSearch;// POI搜索
    private EditText et;
    private AMap aMap;
    private OnLocationChangedListener mListener = null;//定位监听器
    private ListView searchListview;
    private ListView listview;

    @Override
    public void setLocationCallBack(Activity act, AMap aMap, ListView listView) {
        this.act = act;
        this.aMap = aMap;
        this.listview = listView;
        //设置定位监听
        aMap.setLocationSource(this);
        //设置缩放级别
        aMap.moveCamera(CameraUpdateFactory.zoomTo(18));
        //显示定位层并可触发，默认false
        aMap.setMyLocationEnabled(true);
        utils = new ActivityUtils(act);
        locationUtil.setLocationCallBack((code, str, lat, lgt, aMapLocation) -> {
            //根据获取的经纬度，将地图移动到定位位置
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(lat, lgt)));
            mListener.onLocationChanged(aMapLocation);
            //添加定位图标
            aMap.addMarker(locationUtil.getMarkerOption(str, lat, lgt));
            poiSearch(lgt, lat);
        });
        if (mapAdapter == null) {
            mapAdapter = new MapAdapter(act, list, R.layout.map_item);
    }
        listview.setAdapter(mapAdapter);
    }

    //默认定位搜索回调,
    // 关键字搜索回调
    @Override
    public void onPoiSearched(PoiResult result, int rCode) {

        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getQuery() != null) {
                List<PoiItem> poiItems = result.getPois();
                list.clear();
                list.addAll(poiItems);
                mapAdapter.notifyDataSetChanged();
                searchAdapter.notifyDataSetChanged();
//                    List<SuggestionCity> suggestionCities = poiResult
//                            .getSearchSuggestionCitys();// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息
                searchListview.setOnItemClickListener((parent, view, position, id) -> {
                    String snippet = list.get(position).getSnippet();
                    et.setText(snippet.toCharArray(), 0, snippet.length());
                    double lgt = list.get(position).getLatLonPoint().getLongitude();
                    double lat = list.get(position).getLatLonPoint().getLatitude();
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(lat, lgt)));
                    //添加定位图标
                    aMap.addMarker(locationUtil.getMarkerOption("", lat, lgt));
                    searchListview.setVisibility(View.GONE);
                });
                listview.setOnItemClickListener((parent, view, position, id) -> {
                    mapAdapter.map.put(oldPosition + "", false);
                    mapAdapter.map.put(position + "", true);
                    oldPosition = position;
                    mapAdapter.notifyDataSetChanged();

                    String direction = list.get(position).getAdName();
                    String adCode = list.get(0).getAdCode();
                    String snippet = list.get(position).getSnippet();
                    double lgt = list.get(position).getLatLonPoint().getLongitude();
                    double lat = list.get(position).getLatLonPoint().getLatitude();
                    mView.addressInfo(direction,adCode,snippet,lgt,lat);
                });
                String direction = list.get(0).getAdName();
                String adCode = list.get(0).getAdCode();
                String snippet = list.get(0).getSnippet();
                double lgt = list.get(0).getLatLonPoint().getLongitude();
                double lat = list.get(0).getLatLonPoint().getLatitude();
                mView.addressInfo(direction,adCode,snippet,lgt,lat);
            } else {
                utils.showToast("未搜索到结果");
            }
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    @Override
    public void initListener(EditText et, ListView listview) {
        this.et = et;
        this.searchListview = listview;
        if (searchAdapter == null) {
            searchAdapter = new SearchAdapter(act, list, R.layout.search_item);
        }
        searchListview.setAdapter(searchAdapter);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                keyWord = String.valueOf(charSequence);
                if ("".equals(keyWord)) {
                    utils.showToast("请输入搜索关键字");
                    return;
                } else {
                    searchListview.setVisibility(View.VISIBLE);
                    doSearchQuery();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 周边搜索
     */

    private void poiSearch(double longitude, double latitude) {
        //不输入城市名称有些地方搜索不到
        query = new PoiSearch.Query(keyWord, "", "");
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);// 设置查第一页
        poiSearch = new PoiSearch(act, query);
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude, longitude), 10000));
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    /**
     * 关键字搜索
     */
    protected void doSearchQuery() {
        //不输入城市名称有些地方搜索不到
        query = new PoiSearch.Query(keyWord, "", "");
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query.setPageSize(20);// 设置每页最多返回多少条poiitem
        query.setPageNum(0);// 设置查第一页
        poiSearch = new PoiSearch(act, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        locationUtil = new LocationUtil();
        locationUtil.startLocate(act);
    }

    @Override
    public void deactivate() {
        mListener = null;
    }
}
