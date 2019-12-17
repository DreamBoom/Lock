package com.lock.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.lock.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wmx
 */
public class MapAdapter extends CommonAdapter<PoiItem> {
    private Activity act;
    public HashMap<String, Boolean> map;

    public MapAdapter(Activity act, ArrayList<PoiItem> data, int layoutId) {
        super(act, data, layoutId);
        map = new HashMap<>();
        this.act = act;
        map.put("0", true);
        for (int j = 1; j < data.size(); j++) {
            map.put(j + "", false);
        }
    }

    @Override
    public void convert(ViewHolder holder, PoiItem data, int position) {
        holder.setText(R.id.map_address, data.getSnippet());
        LatLonPoint point = data.getLatLonPoint();
//        Log.i("getCityName===>", data.getCityName());
//        Log.i("getBusinessArea===>", data.getBusinessArea());
//        Log.i("getSnippet===>", data.getSnippet());
//        Log.i("===>", point.getLatitude() + "===" + point.getLatitude());
//        Log.i("getAdName===>", data.getAdName());
//        Log.i("getProvinceName===>", data.getProvinceName());
        LinearLayout llMap = holder.getView(R.id.ll_map);
        ImageView map_check = holder.getView(R.id.map_check);
        TextView map_address = holder.getView(R.id.map_address);
        if (map.get(position + "") != null && map.get(position + "")) {
            map_address.setTextColor(ContextCompat.getColor(act, R.color.blue));
            map_check.setVisibility(View.VISIBLE);
        } else {
            map_address.setTextColor(ContextCompat.getColor(act, R.color.text_yy));
            map_check.setVisibility(View.INVISIBLE);
        }
    }
}
