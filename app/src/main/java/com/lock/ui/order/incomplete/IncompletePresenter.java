package com.lock.ui.order.incomplete;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.OrderAdapter;
import com.lock.base.App;
import com.lock.bean.OrderListBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.Splash;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;

import java.util.ArrayList;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class IncompletePresenter extends BasePresenterImpl<IncompleteContract.View> implements IncompleteContract.Presenter {
    private OrderAdapter adapter;
    private ArrayList<OrderListBean.ModuleBean> list;

    @Override
    public void getList(Activity act, int i, ListView listView,boolean refresh) {
        String key = mk.decodeString(Tool.tokenKey, "");
        String token = mk.decodeString(Tool.tokenId, "");
        String time = mk.decodeString(Tool.loginTime, "");
        String encrypt = MD5Utils.encrypt(key + token + time + key);

        HttpRequestPort.getInstance().OrderList(encrypt, "service", "" + i, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                OrderListBean bean = JSONObject.parseObject(data, new TypeReference<OrderListBean>() {});
                if (bean.isSuccess()) {
                    if( list == null){
                        list = new ArrayList<>();
                    }
                    if (bean.getModule().size()>0) {
                        if(i==1){
                            list.clear();
                            if (adapter == null) {
                                adapter = new OrderAdapter(act, list, R.layout.main_item);
                            }
                            listView.setAdapter(adapter);
                        }
                        list.addAll(bean.getModule());
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(act,"暂无更多订单",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(act, "请求失败，请刷新重试", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
