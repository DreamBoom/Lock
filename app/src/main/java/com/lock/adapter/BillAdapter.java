package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;

import com.lock.R;
import com.lock.bean.AccountBean;
import com.lock.bean.BillBean;

import java.util.ArrayList;

/**
 * @author wmx
 */
public class BillAdapter extends CommonAdapter<BillBean.ModuleBean> {
    private Activity act;

    public BillAdapter(Activity act, ArrayList<BillBean.ModuleBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, BillBean.ModuleBean data) {
        String substring = data.getCreateTimeDesc().substring(0, 10);
        holder.setText(R.id.time,substring);
        holder.setText(R.id.type,data.getMemo());
        if(data.getTradeType() == 1){
            holder.setText(R.id.money,"+"+data.getAmtInDesc()+"元");
        }else {
            holder.setText(R.id.money,"-"+data.getAmtOutDesc()+"元");
        }

    }

}

