package com.lock.ui.orderinfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.lock.R;
import com.lock.base.App;
import com.lock.bean.ExitBean;
import com.lock.bean.FeeBean;
import com.lock.bean.FeeListBean;
import com.lock.bean.ServiceBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.main.MainActivity;
import com.lock.ui.message.MessageActivity;
import com.lock.ui.service.ServiceActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.LocationUtil;
import com.lock.utils.LogUtil;
import com.lock.utils.Tool;

import java.util.ArrayList;
import java.util.List;

import static com.amap.api.services.route.RouteSearch.DRIVING_SINGLE_DEFAULT;
import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class OrderInfoPresenter extends BasePresenterImpl<OrderInfoContract.View> implements
        OrderInfoContract.Presenter, LocationSource, RouteSearch.OnRouteSearchListener, LocationUtil.ILocationCallBack {
    private LocationUtil locationUtil;
    private OnLocationChangedListener mListener = null;//定位监听器
    private String orderId;
    private double la0 = 0;
    private double lg0 = 0;
    private Activity act;
    private AMap aMap;
    private int first = 0;
    private TextView tv;
    private ActivityUtils utils;

    @SuppressLint("SetTextI18n")
    @Override
    public void setLocationCallBack(Activity act, AMap aMap, double la, double lg, TextView tv, String orderId) {
        this.aMap = aMap;
        this.act = act;
        this.tv = tv;
        this.orderId = orderId;
        la0 = la;
        lg0 = lg;
        //设置定位监听
        aMap.setLocationSource(this);
        //设置缩放级别
        aMap.moveCamera(CameraUpdateFactory.zoomTo(18));
        aMap.setMyLocationEnabled(true);
        //显示定位层并可触发，默认false
        aMap.setMyLocationEnabled(true);
        utils = new ActivityUtils(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderState(token, orderId, "bill", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ServiceBean bean = JSONObject.parseObject(data, new TypeReference<ServiceBean>() {});
                if (bean.isSuccess()) {
                    double m1 = 0.00;
                    double m2 = 0.00;
                    if(bean.getModule().getItems().get(0).getFeeType()==1){
                        m1 = bean.getModule().getItems().get(0).getTotalAmount()*0.01;
                    }
                    if(bean.getModule().getItems().get(1).getFeeType()==2){
                        m2 = bean.getModule().getItems().get(1).getTotalAmount()*0.01;
                    }
                    double v = m1 + m2;
                    String s1 = String.valueOf(m1);
                    String s2 = String.valueOf(m2);
                    String s = String.valueOf(v);
                    mView.fee(s,s1,s2);
                }
            }
        });
    }

    boolean f = true;

    @Override
    public void callBack(String code, String str, double lat, double lgt, AMapLocation aMapLocation) {
        //根据获取的经纬度，将地图移动到定位位置
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(lat, lgt)));
        if (f) {
            mListener.onLocationChanged(aMapLocation);
            f = false;
        }
        //添加定位图标
        //定位坐标
        DPoint mPoint = new DPoint(lat, lgt);
        DPoint mPoint1 = new DPoint(la0, lg0);
        LatLonPoint start = new LatLonPoint(lat, lgt);
        LatLonPoint end = new LatLonPoint(la0, lg0);
        //获取两点之间距离
        CoordinateConverter.calculateLineDistance(mPoint, mPoint1);
        float distance = CoordinateConverter.calculateLineDistance(mPoint, mPoint1) / 1000;
        tv.setText("距离:" + (int) distance + "KM");
        if (first == 0) {
            first = 1;
            //路线规划
            RouteSearch routeSearch = new RouteSearch(act);
            routeSearch.setRouteSearchListener(this);
            //构建开始点与终止点的经纬度数据
            RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(start, end);
// fromAndTo包含路径规划的起点和终点，drivingMode表示驾车模式
// 第三个参数表示途经点（最多支持16个），  第四个参数表示避让区域（最多支持32个），第五个参数表示避让道路
            RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(
                    fromAndTo, DRIVING_SINGLE_DEFAULT, null, null, "");
            routeSearch.calculateDriveRouteAsyn(query);
            //添加标记
            aMap.addMarker(locationUtil.getstart(str, lat, lgt));
            aMap.addMarker(locationUtil.getend(str, la0, lg0));
        }
    }

    //订单开始
    @Override
    public void orderStart() {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderStart(token, orderId, "" + la0, "" + lg0, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    //订单提交成功，进入已出发环节，开始每30秒上传位置和30分钟倒计时
                    //每30秒上传位置
                    mView.state1();
                    Handler handler = new Handler();
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            sendLocation();
                            handler.postDelayed(this, 10000);
                        }
                    };
                    handler.postDelayed(runnable, 10000);
                    //30分钟倒计时
                    time(30 * 60 * 1000);
                } else {
                    Toast.makeText(act, "请求失败，请刷新重试", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    @Override
    public void orderArrive() {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderArrive(token, orderId, "" + la0, "" + lg0, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    mView.arrive();
                } else {
                    Toast.makeText(act, "请求失败，请刷新重试", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    @Override
    public void orderEnd() {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderEnd(token, orderId,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                if (bean.isSuccess()) {
                    mView.end();
                } else {
                    Toast.makeText(act, "请求失败，请刷新重试", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    //倒计时
    private void time(long time) {
        if(time>0){
            CountDownTimer timer = new CountDownTimer(time, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mView.time(formatTime(millisUntilFinished));
                }

                @Override
                public void onFinish() {
                    mView.time("00:00");
                }
            };
            timer.start();
        }else {
            mView.time("00:00");
        }
    }

    /**
     * 将毫秒转化为 分钟：秒 的格式
     *
     * @param millisecond 毫秒
     * @return
     */
    public String formatTime(long millisecond) {
        int minute;//分钟
        int second;//秒数
        minute = (int) ((millisecond / 1000) / 60);
        second = (int) ((millisecond / 1000) % 60);
        if (minute < 10) {
            if (second < 10) {
                return "0" + minute + ":" + "0" + second;
            } else {
                return "0" + minute + ":" + second;
            }
        } else {
            if (second < 10) {
                return minute + ":" + "0" + second;
            } else {
                return minute + ":" + second;
            }
        }
    }

    @Override
    public void stopTime(long time) {
        long l = System.currentTimeMillis();
        long l1 = 1800000 + time;
        if (l - time < 1800000) {
            time(l1 - l);
        }else {
            time(-1);
        }
    }

    //每30秒上传一次位置
    private void sendLocation() {
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderStart(token, orderId, "" + la0, "" + lg0, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
            }
        });
    }

    @Override
    public void startMain(Activity act) {
        Intent intent = new Intent();
        intent.setClass(act, MainActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void startMessage(Activity act) {
        Intent intent = new Intent();
        intent.setClass(act, MessageActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void putInfo(Activity act, String phone,String orderId) {
        Intent intent = new Intent();
        intent.putExtra("phone", phone);
        intent.putExtra("orderId", orderId);
        intent.setClass(act, ServiceActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void cancelOrder(TextView view, String orderId) {
        cancelPop(act, orderId);
        popCancel.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
    }


    @Override
    public void deleteOrder(TextView view, String orderId) {
        deletePop(act, orderId);
        popDelete.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
    }

    @Override
    public void call(String phone, TextView view) {
        showPop(act, phone);
        popup.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
    }

    private PopupWindow popCancel;
    @SuppressLint("SetTextI18n")
    private void cancelPop(Activity act, String orderId) {
        View view = LayoutInflater.from(act).inflate(R.layout.phone_dialog, null);
        TextView sure = view.findViewById(R.id.sure);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView title = view.findViewById(R.id.title);
        title.setText("取消当前订单？");
        popCancel = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popCancel.setTouchable(true);
        popCancel.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popCancel.setBackgroundDrawable(dw);
        sure.setOnClickListener(v -> {
            popCancel.dismiss();
            cancel(orderId);

        });
        cancel.setOnClickListener(v -> popCancel.dismiss());
    }

    private void cancel(String orderId) {
        utils.getload(act);
        String tokenId = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderCancel(tokenId, orderId, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                mView.cancel();
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }


    private PopupWindow popDelete;
    @SuppressLint("SetTextI18n")
    private void deletePop(Activity act, String orderId) {
        View view = LayoutInflater.from(act).inflate(R.layout.phone_dialog, null);
        TextView sure = view.findViewById(R.id.sure);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView title = view.findViewById(R.id.title);
        title.setText("删除当前订单？");
        popDelete = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popDelete.setTouchable(true);
        popDelete.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popDelete.setBackgroundDrawable(dw);
        sure.setOnClickListener(v -> {
            popDelete.dismiss();
            delete(orderId);

        });
        cancel.setOnClickListener(v -> popDelete.dismiss());
    }

    private void delete(String orderId) {
        utils.getload(act);
        String tokenId = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().order(tokenId, "delete", orderId, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                mView.delete();
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    private PopupWindow popup;

    @SuppressLint("SetTextI18n")
    private void showPop(Activity act, String phone) {
        View view = LayoutInflater.from(act).inflate(R.layout.phone_dialog, null);
        TextView sure = view.findViewById(R.id.sure);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView title = view.findViewById(R.id.title);
        title.setText("拨打客服电话：" + phone);
        popup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popup.setTouchable(true);
        popup.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popup.setBackgroundDrawable(dw);
        sure.setOnClickListener(v -> {
            popup.dismiss();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            act.startActivity(intent);

        });
        cancel.setOnClickListener(v -> popup.dismiss());
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        locationUtil = new LocationUtil();
        locationUtil.setLocationCallBack(this);
        locationUtil.startLocate(act);
    }

    @Override
    public void deactivate() {
        mListener = null;
    }

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {
        //  aMap.clear();
        //几种公交路线
        List<BusPath> busPathList = busRouteResult.getPaths();
        //选择第一条
        List<BusStep> busSteps = busPathList.get(0).getSteps();

        for (BusStep bs : busSteps) {
            //获取该条路线某段公交路程步行的点
            RouteBusWalkItem routeBusWalkItem = bs.getWalk();
            if (routeBusWalkItem != null) {
                List<WalkStep> wsList = routeBusWalkItem.getSteps();
                ArrayList<LatLng> walkPoint = new ArrayList<>();

                for (WalkStep ws : wsList) {
                    List<LatLonPoint> points = ws.getPolyline();
                    for (LatLonPoint lp : points) {
                        walkPoint.add(new LatLng(lp.getLatitude(), lp.getLongitude()));
                    }
                }
                //添加步行点
                aMap.addPolyline(new PolylineOptions()
                        .addAll(walkPoint)
                        .width(8)
                        .geodesic(true)
                        .color(Color.argb(100, 21, 79, 181)));
            }

            //获取该条路线某段公交路路程的点
            List<RouteBusLineItem> rbli = bs.getBusLines();
            ArrayList<LatLng> busPoint = new ArrayList<>();


            for (RouteBusLineItem one : rbli) {

                List<LatLonPoint> points = one.getPolyline();

                for (LatLonPoint lp : points) {
                    busPoint.add(new LatLng(lp.getLatitude(), lp.getLongitude()));
                }
            }
            //添加公交路线点
            aMap.addPolyline(new PolylineOptions()
                    .addAll(busPoint)
                    .width(8)
                    .geodesic(true)
                    .color(Color.argb(100, 21, 79, 181)));
        }
    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
        if (driveRouteResult.getPaths() == null) {
            return;
        }
        List<DrivePath> pathList = driveRouteResult.getPaths();
        List<LatLng> driverPath = new ArrayList<>();
        for (DrivePath dp : pathList) {
            List<DriveStep> stepList = dp.getSteps();
            for (DriveStep ds : stepList) {
                List<LatLonPoint> points = ds.getPolyline();
                for (LatLonPoint llp : points) {
                    driverPath.add(new LatLng(llp.getLatitude(), llp.getLongitude()));
                }
            }
        }

        //  aMap.clear();
        aMap.addPolyline(new PolylineOptions()
                .addAll(driverPath)
                .width(8)
                .geodesic(true)
                .color(Color.argb(100, 21, 79, 181)));

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

        List<WalkPath> pathList = walkRouteResult.getPaths();
        List<LatLng> walkPaths = new ArrayList<>();

        for (WalkPath dp : pathList) {

            List<WalkStep> stepList = dp.getSteps();
            for (WalkStep ds : stepList) {


                List<LatLonPoint> points = ds.getPolyline();
                for (LatLonPoint llp : points) {
                    walkPaths.add(new LatLng(llp.getLatitude(), llp.getLongitude()));
                }
            }
        }

        // aMap.clear();
        aMap.addPolyline(new PolylineOptions()
                .addAll(walkPaths)
                .width(8)
                .geodesic(true)
                .color(Color.argb(100, 21, 79, 181)));

    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

        List<RidePath> pathList = rideRouteResult.getPaths();
        List<LatLng> walkPaths = new ArrayList<>();

        for (RidePath dp : pathList) {

            List<RideStep> stepList = dp.getSteps();
            for (RideStep ds : stepList) {
                List<LatLonPoint> points = ds.getPolyline();
                for (LatLonPoint llp : points) {
                    walkPaths.add(new LatLng(llp.getLatitude(), llp.getLongitude()));
                }
            }
        }

        //aMap.clear();
        aMap.addPolyline(new PolylineOptions()
                .addAll(walkPaths)
                .width(8)
                .geodesic(true)
                .color(Color.argb(100, 21, 79, 181)));

    }
}

