package com.lock.adapter;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.lock.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchAdapter extends CommonAdapter<PoiItem> {
    private Activity act;

    public SearchAdapter(Activity act, ArrayList<PoiItem> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @Override
    public void convert(ViewHolder holder, PoiItem data, int position) {
        holder.setText(R.id.search_address, data.getSnippet());
    }
}
