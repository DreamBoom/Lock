package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.bean.ChooseBean;
import com.lock.bean.OrderListBean;
import com.lock.ui.orderinfo.OrderInfoActivity;

import java.util.ArrayList;

/**
 * @author wmx
 */
public class ChooseAdapter extends CommonAdapter<ChooseBean> {
    private Activity act;

    public ChooseAdapter(Activity act, ArrayList<ChooseBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, ChooseBean data) {
        holder.setText(R.id.name,data.getName());
        ImageView view = holder.getView(R.id.choose);
        if(data.isChoose()){
            holder.setTextColor(R.id.name,R.color.text_yy);
            view.setVisibility(View.VISIBLE);
        }else {
            holder.setTextColor(R.id.name,R.color.blue);
            view.setVisibility(View.INVISIBLE);
        }
    }
}

