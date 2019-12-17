package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;

import com.lock.R;
import com.lock.bean.AccountBean;

import java.util.ArrayList;

/**
 * @author wmx
 */
public class MessageAdapter extends CommonAdapter<String> {
    private Activity act;

    public MessageAdapter(Activity act, ArrayList<String> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, String data) {
        holder.setText(R.id.info,data);
        holder.setText(R.id.data,"2019-01-01");
    }
}

