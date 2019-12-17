package com.lock.ui.changepaypass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.base.App;
import com.lock.bean.ExitBean;
import com.lock.bean.MsgBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ChangePayPassPresenter extends BasePresenterImpl<ChangePayPassContract.View>
        implements ChangePayPassContract.Presenter {
    private int captchaTime = 60;
    private Runnable mRunnable;
    private Handler mHandler;
    private ActivityUtils utils;

    @Override
    public void getCode(Activity act, TextView send, TextView miao, EditText edit) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        send.setText("重新获取");
        getNum(act, edit);
        getCaptchaTime(send, miao);
    }

    @Override
    public void changePayPass(Activity act, String pass, String code) {
        if(validateInput(pass,code)){
            utils.getload(act);
            String encrypt = MD5Utils.encrypt(pass + "hzhs_auth");
            String token = mk.decodeString(Tool.tokenId, "");
            HttpRequestPort.getInstance().changePay(token,encrypt,code,new BaseHttpCallBack(act) {
                @Override
                public void onSuccess(String data) {
                    super.onSuccess(data);
                    ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                    if(bean.getCode().equals("00")){
                        utils.showToast(bean.getMessage());
                        mk.encode(Tool.payPass,encrypt);
                        mView.success();                    }
                }

                @Override
                public void onFinished() {
                    super.onFinished();
                    utils.hindload();
                }
            });
        }
    }

    private void getNum(Activity act, EditText edit) {
        HttpRequestPort.getInstance().payCode(new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MsgBean bean = JSONObject.parseObject(data, new TypeReference<MsgBean>() {
                });
                if (bean.isSuccess()) {
                    edit.setText(bean.getModule().toCharArray(), 0, bean.getModule().length());
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
            }

            @Override
            public void onFinished() {
                super.onFinished();
            }
        });
    }

    private void getCaptchaTime(TextView send, TextView miao) {
        send.setVisibility(View.GONE);
        miao.setVisibility(View.VISIBLE);
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
                    send.setVisibility(View.VISIBLE);
                    miao.setVisibility(View.GONE);
                    miao.setText("60秒后重试");
                    captchaTime = 60;
                    return;
                }
                miao.setText(captchaTime + "秒后重试");
                mHandler.postDelayed(this, 1000);
                // 延时时长
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
        // 打开定时器，执行操作
    }

    private boolean validateInput(String pass, String code) {
        if (TextUtils.isEmpty(pass) || pass.length() < 6) {
            utils.showToast("密码长度不能低于6位，请重新输入");
            return false;
        }
        if (TextUtils.isEmpty(code)) {
            utils.showToast("验证码输入有误，请重新输入");
            return false;
        }
        return true;
    }
}
