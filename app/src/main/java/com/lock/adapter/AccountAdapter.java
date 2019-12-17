package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lock.R;
import com.lock.bean.AccountBean;
import com.lock.bean.OrderListBean;

import java.util.ArrayList;

/**
 * @author wmx
 */
public class AccountAdapter extends CommonAdapter<AccountBean.ModuleBean> {
    private Activity act;

    public AccountAdapter(Activity act, ArrayList<AccountBean.ModuleBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, AccountBean.ModuleBean data) {
        RelativeLayout rl = holder.getView(R.id.rl_header);
        int payType= data.getPayType();
        if(payType == 1){
            rl.setBackground(ContextCompat.getDrawable(act,R.drawable.alpay));
        }else {
            rl.setBackground(ContextCompat.getDrawable(act,R.drawable.wx));
        }
        holder.setText(R.id.name,data.getRealName());
        holder.setText(R.id.phone,data.getAccount());
    }

}

