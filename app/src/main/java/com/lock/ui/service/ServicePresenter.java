package com.lock.ui.service;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.FeeAdapter;
import com.lock.bean.ExitBean;
import com.lock.bean.FeeBean;
import com.lock.bean.FeeListBean;
import com.lock.bean.ServiceBean;
import com.lock.bean.UpBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.LogUtil;
import com.lock.utils.MoneyInputFilter;
import com.lock.utils.MyGlideEngine;
import com.lock.utils.Tool;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ServicePresenter extends BasePresenterImpl<ServiceContract.View> implements ServiceContract.Presenter {

    private Activity act;
    private ActivityUtils utils;
    private double m2 = 0;
    private double m3 = 0;
    private double m4 = 0;
    private double m5 = 0;
    private double m6 = 0;
    @Override
    public void init(Activity act, String orderId) {
        this.act = act;
        utils = new ActivityUtils(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().orderState(token, orderId, "bill", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ServiceBean bean = JSONObject.parseObject(data, new TypeReference<ServiceBean>() {
                });
                if (bean.isSuccess()) {
                    if (bean.getModule().getItems().get(1).getFeeType() == 2) {
                        m2 = bean.getModule().getItems().get(1).getTotalAmount() * 0.01;
                    }
                    if (bean.getModule().getItems().get(2) != null
                            && bean.getModule().getItems().get(2).getFeeType() == 3) {
                        m3 = bean.getModule().getItems().get(2).getTotalAmount() * 0.01;
                    }
                    if (bean.getModule().getItems().get(3) != null
                            && bean.getModule().getItems().get(3).getFeeType() == 4) {
                        m4 = bean.getModule().getItems().get(3).getTotalAmount() * 0.01;
                    }
                    if (bean.getModule().getItems().get(4) != null
                            && bean.getModule().getItems().get(4).getFeeType() == 5) {
                        m5 = bean.getModule().getItems().get(4).getTotalAmount() * 0.01;
                    }
                    if (bean.getModule().getItems().get(5) != null
                            && bean.getModule().getItems().get(5).getFeeType() == 6) {
                        m6 = bean.getModule().getItems().get(5).getTotalAmount() * 0.01;
                    }
                    mView.service(bean.getModule().getPaymentType() + "");
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                m1(token, orderId);
            }
        });
    }

    @Override
    public void sure(Activity act, File f1, File f2, File f3, String orderId, String paymentType,
                     String m1, String m2, String m3, String m4, String m5, String m6) {
        if (f1 == null && f2 == null && f3 == null) {
            utils.showToast("请至少上传一张图片");
            return;
        }
        UpBean upBean = new UpBean();
        upBean.setId(Integer.valueOf(orderId));
        upBean.setPaymentType(Integer.valueOf(paymentType));
        ArrayList<UpBean.ItemsBean> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            UpBean.ItemsBean itemsBean = new UpBean.ItemsBean();

            switch (i + 1) {
                case 1:
                    if (!"0.00".equals(m1)) {
                        itemsBean.setCid("1");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m1);
                        itemsBean.setTotalAmountDesc(m1);
                        list.add(itemsBean);
                    }
//                    else {
//                        itemsBean.setCid("");
//                        m1 = "0.00";
//                    }

                    break;
                case 2:
                    if (!"0.00".equals(m2)) {
                        itemsBean.setCid("2");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m2);
                        itemsBean.setTotalAmountDesc(m2);
                        list.add(itemsBean);
                    }

                    break;
                case 3:
                    if (!"0.00".equals(m3)) {
                        itemsBean.setCid("3");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m3);
                        itemsBean.setTotalAmountDesc(m3);
                        list.add(itemsBean);
                    }

                    break;
                case 4:
                    if (!"0.00".equals(m4)) {
                        itemsBean.setCid("4");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m4);
                        itemsBean.setTotalAmountDesc(m4);
                        list.add(itemsBean);
                    }
                    break;
                case 5:
                    if (!"0.00".equals(m5)) {
                        itemsBean.setCid("5");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m5);
                        itemsBean.setTotalAmountDesc(m5);
                        list.add(itemsBean);
                    }

                    break;
                case 6:
                    if (!"0.00".equals(m6)) {
                        itemsBean.setCid("6");
                        itemsBean.setNumber(1+"");
                        itemsBean.setFeeId(i + 1+"");
                        itemsBean.setFeeType(i + 1+"");
                        itemsBean.setItemPriceDesc(m6);
                        itemsBean.setTotalAmountDesc(m6);
                        list.add(itemsBean);
                    }

                    break;
            }

        }
        upBean.setItems(list);
        String s = JSON.toJSONString(upBean);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().upInfo(token, f1, f2, f3, s, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                utils.showToast(bean.getMessage());
                if (bean.isSuccess()) {
                    mView.fs();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                m1(token, orderId);
            }
        });
    }

    private void m1(String token, String orderId) {

        HttpRequestPort.getInstance().ruleFee(token, orderId, "travel", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                FeeBean bean = JSONObject.parseObject(data, new TypeReference<FeeBean>() {
                });
                if (bean.isSuccess()) {
                    m2(token, orderId, bean.getModule().getItemPriceDesc());
                }
            }
        });
    }

    private void m2(String token, String orderId, String fee) {
        ArrayList<FeeListBean.ModuleBean> list = new ArrayList<>();
        HttpRequestPort.getInstance().ruleFee(token, orderId, "unlock", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                FeeListBean bean = JSONObject.parseObject(data, new TypeReference<FeeListBean>() {
                });
                if (bean.isSuccess()) {
                    List<FeeListBean.ModuleBean> module = bean.getModule();
                    list.clear();
                    list.addAll(module);
                    double m1 = Double.valueOf(fee);
                    double v = m1 + m2;
                    mView.fee(String.valueOf(v), fee, String.valueOf(m2),String.valueOf(m3),
                            String.valueOf(m4),String.valueOf(m5), String.valueOf(m6),list);
                }
            }
        });
    }

    @Override
    public void photo() {
        Matisse.from(act)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG)) // 选择 mime 的类型
                .countable(true)
                .crop(false)     //设置为true后，才会进入截图模式，默认为false，进入为知乎普通图片选择器
                // .cropOptions(options) //设置uCrop裁剪参数
                // .cropUri(uri)         //设置截图后的保存路径
                .maxSelectable(1) // 图片选择的最多数量
                .gridExpectedSize(act.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(1f) // 缩略图的比例
                .imageEngine(new MyGlideEngine()) // 使用的图片加载引擎
                .capture(true) //是否提供拍照功能
                .captureStrategy(new CaptureStrategy(true, "com.lock.file"))//存储到哪里
                .forResult(201); // 设置作为标记的请求码
    }

    @Override
    public void upPhoto() {

    }

    @Override
    public void call(String phone, TextView v) {
        showPop(act, phone);
        popup.showAtLocation(v, Gravity.NO_GRAVITY, 0, 0);
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

    @SuppressLint("WrongConstant")
    @Override
    public void pop(View view) {
        View v = utils.getView(act, R.layout.pop_money);
        PopupWindow popupWindow = new PopupWindow(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setClippingEnabled(true);
        popupWindow.setFocusable(true);
        ImageView close = v.findViewById(R.id.close);
        close.setOnClickListener(v12 -> popupWindow.dismiss());
        TextView save = v.findViewById(R.id.save);
        EditText et3 = v.findViewById(R.id.et3);
        EditText et4 = v.findViewById(R.id.et4);
        EditText et5 = v.findViewById(R.id.et5);
        EditText et6 = v.findViewById(R.id.et6);
        MoneyInputFilter.MAX_VALUE = 10000;
        MoneyInputFilter moneyInputFilter = new MoneyInputFilter(act);
        InputFilter data[] = new InputFilter[1];
        data[0] = moneyInputFilter;
        et3.setFilters(data);
        et4.setFilters(data);
        et5.setFilters(data);
        et6.setFilters(data);
        save.setOnClickListener(v1 -> {
                    String m3 = et3.getText().toString().trim();
                    String m4 = et4.getText().toString().trim();
                    String m5 = et5.getText().toString().trim();
                    String m6 = et6.getText().toString().trim();
                    if (TextUtils.isEmpty(m3)) {
                        m3 = "0";
                    }else {
                        m3 = utils.save2(Double.valueOf(m3));
                    }
                    if (TextUtils.isEmpty(m4)) {
                        m4 = "0";
                    }else {
                        m4 = utils.save2(Double.valueOf(m4));
                    }
                    if (TextUtils.isEmpty(m5)) {
                        m5 = "0";
                    }else {
                        m5 = utils.save2(Double.valueOf(m5));
                    }
                    if (TextUtils.isEmpty(m6)) {
                        m6 = "0";
                    }else {
                        m6 = utils.save2(Double.valueOf(m6));
                    }
                    mView.money(m3, m4, m5, m6);
                    popupWindow.dismiss();
                }
        );
        popupWindow.setContentView(v);
        popupWindow.showAsDropDown(view);
    }

    @Override
    public void feePop(View view, ArrayList<FeeListBean.ModuleBean> list) {
        View v = utils.getView(act, R.layout.pop_fee);
        PopupWindow popupWindow = new PopupWindow(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setClippingEnabled(true);
        popupWindow.setFocusable(true);
        ImageView close = v.findViewById(R.id.close);
        ListView feeList = v.findViewById(R.id.fee_list);
        FeeAdapter adapter = new FeeAdapter(act, list, R.layout.fee_item);
        feeList.setAdapter(adapter);
        close.setOnClickListener(v12 -> popupWindow.dismiss());
        feeList.setOnItemClickListener((parent, view1, position, id) -> {
            mView.feeMoney(list.get(position).getItemPriceDesc());
            popupWindow.dismiss();
        });
        popupWindow.setContentView(v);
        popupWindow.showAsDropDown(view);
    }
}
