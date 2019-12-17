package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lock.R;
import com.lock.bean.OrderListBean;
import com.lock.net.HttpRequestPort;
import com.lock.ui.orderinfo.OrderInfoActivity;
import com.yanzhenjie.permission.AndPermission;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * @author wmx
 */
public class OrderAdapter extends CommonAdapter<OrderListBean.ModuleBean> {
    private Activity act;
    private static String DATE = "yyyy-MM-dd";
    public OrderAdapter(Activity act, ArrayList<OrderListBean.ModuleBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, OrderListBean.ModuleBean data) {
        TextView cancel = holder.getView(R.id.order_cancel);
        if(data.getStatus()==1){
            holder.setText(R.id.order_status,"正在开锁");
            cancel.setVisibility(View.GONE);
        }else {
            holder.setText(R.id.order_status,"开锁");
            cancel.setVisibility(View.GONE);
        }

        holder.setText(R.id.order_time,data.getCreateTimeDesc());
        holder.setText(R.id.order_point,data.getDistrict()+data.getAddress());
        holder.getView(R.id.order_info).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(act, OrderInfoActivity.class);
            intent.putExtra("orderId",""+data.getId());
            intent.putExtra("state",data.getStatus());
            intent.putExtra("startTime",data.getGmtStart());
            intent.putExtra("lat",data.getLatitude());
            intent.putExtra("lgt",data.getLongitude());
            intent.putExtra("mobile",data.getCustomMobile());
            intent.putExtra("addressName",data.getDistrict()+data.getAddress());
            intent.putExtra("createTime",data.getCreateTimeDesc());
            intent.putExtra("money",data.getAmountDesc());
            intent.putExtra("im1", HttpRequestPort.URL+"biz/bizOrderDeal.do?type=download&fileName="+data.getImgBill1());
            intent.putExtra("im2",HttpRequestPort.URL+"biz/bizOrderDeal.do?type=download&fileName="+data.getImgBill2());
            intent.putExtra("im3",HttpRequestPort.URL+"biz/bizOrderDeal.do?type=download&fileName="+data.getImgBill3());
            act.startActivity(intent);
        });
        holder.getView(R.id.order_cancel).setOnClickListener(v -> {

        });
    }

}

