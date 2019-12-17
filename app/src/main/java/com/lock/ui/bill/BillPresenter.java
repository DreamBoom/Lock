package com.lock.ui.bill;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.AccountAdapter;
import com.lock.adapter.BillAdapter;
import com.lock.adapter.ChooseAdapter;
import com.lock.base.App;
import com.lock.bean.AccountBean;
import com.lock.bean.BillBean;
import com.lock.bean.ChooseBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;

import java.util.ArrayList;
import java.util.List;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BillPresenter extends BasePresenterImpl<BillContract.View> implements BillContract.Presenter{

    private ArrayList<BillBean.ModuleBean> moduleList = new ArrayList<>();
    private ArrayList<ChooseBean> time = new ArrayList<>();
    private ArrayList<ChooseBean> type = new ArrayList<>();
    private ArrayList<ChooseBean> sx = new ArrayList<>();
    private Activity act;
    @Override
    public void initData(Activity act, ListView listView) {
        this.act = act;
        ChooseBean c1 = new ChooseBean();
        c1.setChoose(true);
        c1.setName("一周");
        ChooseBean c2 = new ChooseBean();
        c2.setChoose(false);
        c2.setName("一个月");
        ChooseBean c3 = new ChooseBean();
        c3.setChoose(false);
        c3.setName("三个月");
        ChooseBean c4 = new ChooseBean();
        c4.setChoose(false);
        c4.setName("半年");
        ChooseBean c5 = new ChooseBean();
        c5.setChoose(false);
        c5.setName("一年");
        time.add(c1);
        time.add(c2);
        time.add(c3);
        time.add(c4);
        time.add(c5);
        ChooseBean c6 = new ChooseBean();
        c6.setChoose(true);
        c6.setName("线上支付");
        ChooseBean c7 = new ChooseBean();
        c7.setChoose(false);
        c7.setName("线下支付");
        type.add(c6);
        type.add(c7);
        ChooseBean c8 = new ChooseBean();
        c8.setChoose(true);
        c8.setName("正序");
        ChooseBean c9 = new ChooseBean();
        c9.setChoose(false);
        c9.setName("倒序");
        sx.add(c8);
        sx.add(c9);
        BillAdapter adapter = new BillAdapter(act, moduleList, R.layout.bill_item);
        listView.setAdapter(adapter);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().billList(token,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                BillBean bean = JSONObject.parseObject(data, new TypeReference<BillBean>() {});
                if(bean.isSuccess()){
                    List<BillBean.ModuleBean> module = bean.getModule();
                    moduleList.addAll(module);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void pop1(ListView listView) {
        if(listView.getVisibility() == View.GONE){
            listView.setVisibility(View.VISIBLE);
            ChooseAdapter chooseAdapter = new ChooseAdapter(act, time, R.layout.choose_item);
            listView.setAdapter(chooseAdapter);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                for (int i = 0; i < time.size(); i++) {
                    time.get(i).setChoose(false);
                }
                time.get(position).setChoose(true);
                listView.setVisibility(View.GONE);
            });
        }else {
            listView.setVisibility(View.GONE);
        }
    }

    @Override
    public void pop2(ListView listView) {
        if(listView.getVisibility() == View.GONE){
            listView.setVisibility(View.VISIBLE);
            ChooseAdapter chooseAdapter = new ChooseAdapter(act, type, R.layout.choose_item);
            listView.setAdapter(chooseAdapter);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                for (int i = 0; i < type.size(); i++) {
                    type.get(i).setChoose(false);
                }
                type.get(position).setChoose(true);
                listView.setVisibility(View.GONE);
            });
        }else {
            listView.setVisibility(View.GONE);
        }
    }

    @Override
    public void pop3(ListView listView) {
        if(listView.getVisibility() == View.GONE){
            listView.setVisibility(View.VISIBLE);
            ChooseAdapter chooseAdapter = new ChooseAdapter(act, sx, R.layout.choose_item);
            listView.setAdapter(chooseAdapter);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                for (int i = 0; i < sx.size(); i++) {
                    sx.get(i).setChoose(false);
                }
                sx.get(position).setChoose(true);
                listView.setVisibility(View.GONE);
            });
        }else {
            listView.setVisibility(View.GONE);
        }
    }
}
