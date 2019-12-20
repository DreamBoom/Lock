package com.lock.ui.user;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.adapter.OrderAdapter;
import com.lock.base.App;
import com.lock.bean.ExitBean;
import com.lock.bean.OrderListBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.lockup.LockUpActivity;
import com.lock.ui.message.MessageActivity;
import com.lock.ui.money.MoneyActivity;
import com.lock.ui.order.OrderActivity;
import com.lock.ui.setting.SettingActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;

import java.util.ArrayList;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class UserPresenter extends BasePresenterImpl<UserContract.View> implements UserContract.Presenter{
    private int i = 0;
    private ActivityUtils utils;
    @Override
    public void init(Activity act) {
        utils = new ActivityUtils(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().OrderList(token, "service","", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                OrderListBean bean = JSONObject.parseObject(data, new TypeReference<OrderListBean>() {});
                if (bean.isSuccess()) {
                   mView.orderNum(bean.getQuery().getTotalItem()+"");
                }else {
                    Toast.makeText(act,"订单获取失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void Order(Activity act) {
        Intent intent = new Intent();
        intent.putExtra("site",0);
        intent.setClass(act, OrderActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void Order2(Activity act) {
        Intent intent = new Intent();
        intent.putExtra("site",1);
        intent.setClass(act, OrderActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void lockUp(Activity act) {
        utils.startActivity(LockUpActivity.class);
    }

    @Override
    public void setting(Activity act) {
        utils.startActivity(SettingActivity.class);
    }

    @Override
    public void message(Activity act) {
        utils.startActivity(MessageActivity.class);
    }

    @Override
    public void money(Activity act,TextView tv) {
        if(i ==0){
            pass(act,tv);
        }else {
            utils.startActivity(MoneyActivity.class);
        }
    }

    private int captchaTime = 600;
    private Runnable mRunnable;
    private Handler mHandler;
    private void getTime() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                captchaTime--;
                if (captchaTime == -1) {
                    // 异常处理
                    mHandler.removeCallbacks(mRunnable);
                    return;
                }
                if (captchaTime <= 0) {
                    // 停止。
                    mHandler.removeCallbacks(mRunnable);
                    i = 0;
                    captchaTime = 600;
                    return;
                }
                mHandler.postDelayed(this, 1000);
                // 延时时长
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
        // 打开定时器，执行操作
    }

    private void pass(Activity act,TextView tv) {
        View v = utils.getView(act, R.layout.pop_pass);
        PopupWindow promess = new PopupWindow(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        promess.setBackgroundDrawable(new ColorDrawable(0x00000000));
        promess.setClippingEnabled(true);
        promess.setFocusable(true);
        EditText et_2 = v.findViewById(R.id.et_2);
        TextView tv_3 = v.findViewById(R.id.tv_3);
        tv_3.setOnClickListener(v12 -> promess.dismiss());
        TextView tv_4 = v.findViewById(R.id.tv_4);
        tv_4.setOnClickListener(v1 -> {
            String trim = et_2.getText().toString().trim();
            String encrypt = MD5Utils.encrypt(trim + "hzhs_login");
            String pass = mk.decodeString("pass", "");
            if(pass.equals(encrypt)){
                getTime();
                i = 1;
                utils.startActivity(MoneyActivity.class);
                promess.dismiss();
            }else {
                utils.showToast("密码错误，请从新输入");
                et_2.setText("".toCharArray(), 0, "".length());
            }
        });
        promess.setContentView(v);
        promess.showAsDropDown(tv);
    }

    @Override
    public void checkRest(Activity act, boolean rest) {
        if (rest) {
            startService(act);
        } else {
            stopService(act);
        }
    }

    private void startService(Activity act) {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().startService(token, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    mView.startWork();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    private void stopService(Activity act) {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().stopService(token, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    mView.stopWork();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }
}
