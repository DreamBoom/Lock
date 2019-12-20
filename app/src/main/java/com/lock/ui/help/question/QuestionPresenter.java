package com.lock.ui.help.question;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.HistoryAdapter;
import com.lock.bean.OrderListBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.Tool;

import java.util.ArrayList;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class QuestionPresenter extends BasePresenterImpl<QuestionContract.View> implements QuestionContract.Presenter{
    private HistoryAdapter adapter;
    private ArrayList<OrderListBean.ModuleBean> list;
    @Override
    public void getList(Activity act, int i, ListView listView, boolean refresh) {
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().OrderList(token, "all",""+i, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                OrderListBean bean = JSONObject.parseObject(data, new TypeReference<OrderListBean>() {});
                if (bean.isSuccess()) {
                    if (bean.getModule().size()>0) {
                        if( list == null){
                            list = new ArrayList<>();
                        }
                        if(i==1){
                            list.clear();
                            if(adapter == null){
                                adapter = new HistoryAdapter(act, list, R.layout.history_item);
                            }
                            listView.setAdapter(adapter);
                        }
                        list.addAll(bean.getModule());
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(act,"暂无更多订单",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(act,"请求失败，请刷新重试",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
