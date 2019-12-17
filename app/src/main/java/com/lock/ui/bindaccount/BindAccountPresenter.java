package com.lock.ui.bindaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.AccountAdapter;
import com.lock.base.App;
import com.lock.bean.AccountBean;
import com.lock.bean.ExitBean;
import com.lock.bean.OrderListBean;
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
 * 邮箱 784787081@qq.com
 */

public class BindAccountPresenter extends BasePresenterImpl<BindAccountContract.View> implements BindAccountContract.Presenter {

    private PopupWindow popup;
    private ActivityUtils utils;
    private ArrayList<AccountBean.ModuleBean> moduleList = new ArrayList<>();

    @Override
    public void showPop(Activity act,View v1) {
        final String[] type = {"1"};
        utils = new ActivityUtils(act);
        View view = LayoutInflater.from(act).inflate(R.layout.add_dialog, null);
        ImageView close = view.findViewById(R.id.im_close);
        ImageView im_zfb = view.findViewById(R.id.im_zfb);
        ImageView im_wx = view.findViewById(R.id.im_wx);
        LinearLayout ll_zfb = view.findViewById(R.id.ll_zfb);
        LinearLayout ll_wx = view.findViewById(R.id.ll_wx);
        EditText et_account = view.findViewById(R.id.et_account);
        TextView bt_add = view.findViewById(R.id.bt_add);
        popup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popup.setTouchable(true);
        popup.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popup.setBackgroundDrawable(dw);
        bt_add.setOnClickListener(v -> {
            String account = et_account.getText().toString().trim();
            if (TextUtils.isEmpty(account)) {
                utils.showToast("请输入账号");
            } else if (!utils.isMobile(account)) {
                utils.showToast("请输入正确的账号");
            } else {
                check(act,account, type[0],null);
            }
        });
        ll_zfb.setOnClickListener(v -> {
            im_zfb.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yes));
            im_wx.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yuan));
            type[0] = "1";
        });
        ll_wx.setOnClickListener(v -> {
            im_zfb.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yuan));
            im_wx.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yes));
            type[0] = "2";
        });
        close.setOnClickListener(v -> popup.dismiss());
        popup.showAtLocation(v1, Gravity.NO_GRAVITY, 0, 0);
    }

    @Override
    public void initData(Activity act, ListView listView) {
        check(act,"", "",listView);
    }

    private void check(Activity act,String account, String type,ListView listView) {
        String pass = mk.decodeString(Tool.payPass, "");
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().payPassCheck(token, pass,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                if(bean.getCode().equals("00")){
                    if(TextUtils.isEmpty(account)){
                        getList(act,listView);
                    }else {
                        addAccount(act,account,type);
                    }
                }else {
                    utils.showToast(bean.getMessage());
                }
            }
        });
    }

    private void addAccount(Activity act,String account, String type) {
        String token = mk.decodeString(Tool.tokenId, "");
        String name = mk.decodeString(Tool.name, "");
        HttpRequestPort.getInstance().addAccount(token, type, account, name,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                if(bean.getCode().equals("00")){
                    addAccount(act,account,type);
                    popup.dismiss();
                }else {
                    utils.showToast(bean.getMessage());
                }
            }
        });
    }

    private void getList(Activity act, ListView listView) {
        AccountAdapter adapter = new AccountAdapter(act, moduleList, R.layout.account_item);
        listView.setAdapter(adapter);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().accountList(token,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                AccountBean bean = JSONObject.parseObject(data, new TypeReference<AccountBean>() {});
                List<AccountBean.ModuleBean> module = bean.getModule();
                moduleList.addAll(module);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
