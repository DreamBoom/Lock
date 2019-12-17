package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.lock.R;
import com.lock.bean.ChooseBean;
import com.lock.bean.FeeListBean;

import java.util.ArrayList;

/**
 * @author wmx
 */
public class FeeAdapter extends CommonAdapter<FeeListBean.ModuleBean> {
    private Activity act;

    public FeeAdapter(Activity act, ArrayList<FeeListBean.ModuleBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, FeeListBean.ModuleBean data) {
        holder.setText(R.id.info,data.getItemTypeDesc());
        holder.setText(R.id.money,data.getItemPriceDesc());
    }
}

