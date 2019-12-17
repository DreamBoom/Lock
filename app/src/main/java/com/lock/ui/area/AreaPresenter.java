package com.lock.ui.area;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.Toast;

import com.amap.api.fence.GeoFenceClient;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.lock.R;
import com.lock.mvp.BasePresenterImpl;
import com.lock.utils.LocationUtilOne;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AreaPresenter extends BasePresenterImpl<AreaContract.View> implements AreaContract.Presenter,
         LocationSource, LocationUtilOne.ILocationCallBack {

    private LocationUtilOne locationUtil;
    private LocationSource.OnLocationChangedListener mListener = null;//定位监听器
    private Activity act;
    private AMap aMap;
//    public static final int GEOFENCE_IN; //进入地理围栏
//    public static final int GEOFENCE_OUT ;//退出地理围栏
//    public static final int GEOFENCE_STAYED; //停留在地理围栏内10分钟
    @Override
    public void setLocationCallBack(Activity act, AMap aMap, int i) {
        this.aMap = aMap;
        this.act = act;
        aMap.setLocationSource(this);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(18));
        aMap.setMyLocationEnabled(true);
        //默认定位园清除
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));//设置圆形的边框颜色
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));//设置圆形的填充颜色
        aMap.setMyLocationStyle(myLocationStyle);
    }

    @Override
    public void showMarker(String jl) {
        if(TextUtils.isEmpty(jl)){
            Toast.makeText(act,"距离不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        Float aFloat = Float.valueOf(jl);
        if(aFloat<=0){
            Toast.makeText(act,"距离不可小于0KM",Toast.LENGTH_SHORT).show();
            return;
        }
        aMap.clear();
        aMap.addMarker(locationUtil.getMarkerOption("", lat, lgt));
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(lat,lgt));
        circleOptions.radius(aFloat*1000);
        circleOptions.strokeColor(R.color.blue00);
        circleOptions.fillColor(R.color.blue00);
        circleOptions.strokeWidth(2f);
        aMap.addCircle(circleOptions);
    }

    private double lat = 0.0;
    private double lgt = 0.0;
    @Override
    public void callBack(String code, String str, double lat, double lgt, AMapLocation aMapLocation) {
        //根据获取的经纬度，将地图移动到定位位置
        this.lat = lat;
        this.lgt = lgt;
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(lat, lgt)));
        mListener.onLocationChanged(aMapLocation);

//        //实例化地理围栏客户端
//        GeoFenceClient mGeoFenceClient = new GeoFenceClient(act);
//        //设置希望侦测的围栏触发行为，默认只侦测用户进入围栏的行为
//        // mGeoFenceClient.setActivateAction(GEOFENCE_IN|GEOFENCE_OUT|GEOFENCE_STAYED);
//        //创建一个中心点坐标
//        DPoint centerPoint = new DPoint();
//        //设置中心点纬度
//        centerPoint.setLatitude(lat);
//        centerPoint.setLongitude(lgt);
//        mGeoFenceClient.addGeoFence (centerPoint,500F,"自有业务Id");
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        locationUtil = new LocationUtilOne();
        locationUtil.setLocationCallBack(this);
        locationUtil.startLocate(act);
    }

    @Override
    public void deactivate() {
        mListener = null;
    }
}
