package com.lock.ui.login.message;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.base.App;
import com.lock.base.BaseActivity;
import com.lock.bean.LoginBean;
import com.lock.bean.MsgBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.Splash;
import com.lock.ui.login.LoginActivity;
import com.lock.ui.main.MainActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;

import android.os.Handler;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MessagePresenter extends BasePresenterImpl<MessageContract.View> implements MessageContract.Presenter{
    private int captchaTime = 60;
    private Runnable mRunnable;
    private Handler mHandler;
    private ActivityUtils utils;
    private boolean agree = true;

    @Override
    public void login(Activity act, String userName, String code) {
        utils = new ActivityUtils(act);
        if(TextUtils.isEmpty(userName)){
            utils.showToast("请输入手机号");
            return;
        }
        if(TextUtils.isEmpty(code)){
            utils.showToast("请输入验证码");
            return;
        }
        if(!agree){
            utils.showToast("请先阅读并同意本服务条例");
            return;
        }
        utils.getload(act);
        if(validateInput(userName,code)){
            HttpRequestPort.getInstance().loginMessage(userName,code,new BaseHttpCallBack(act){
                @Override
                public void onSuccess(String data) {
                    super.onSuccess(data);
                    LoginBean bean = JSONObject.parseObject(data, new TypeReference<LoginBean>() {});
                    if (bean.isSuccess()) {
                        mk.encode(Tool.tokenId,bean.getModule().getTokenId());
                        mk.encode(Tool.mstatus,bean.getModule().getMstatus());
                        mk.encode(Tool.name, bean.getModule().getRealName());
                        utils.startActivity(MainActivity.class);
                    } else {
                        utils.hindload();
                        if ("0009".equals(bean.getCode())) {
                            //短信验证码错误或已过期
                            utils.showToast(bean.getMessage());
                        } else {
                            utils.showToast("登录失败，请稍后重试");
                        }
                    }
                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    super.onError(throwable, b);
                    utils.hindload();
                }

                @Override
                public void onFinished() {
                    super.onFinished();
                    utils.hindload();
                }
            });
        }
    }

    @Override
    public void agree(Activity act, ImageView img) {
        if(agree){
            agree = false;
            img.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yuan));
        }else {
            agree = true;
            img.setBackground(ContextCompat.getDrawable(act,R.drawable.ico_yes));
        }
    }

    @Override
    public void getCode(Activity act, TextView send, TextView miao, String phone, EditText edit) {
        if(utils == null){
            utils = new ActivityUtils(act);
        }
        if(TextUtils.isEmpty(phone)||!utils.isMobile(phone)){
            utils.showToast("请输入正确的手机号");
            return;
        }
        send.setText("重新获取");
        getNum(act,phone,edit);
        getCaptchaTime(send,miao);
    }

    private void getNum(Activity act,String phone,EditText edit) {
        HttpRequestPort.getInstance().LoginCode(phone,new BaseHttpCallBack(act){
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MsgBean bean = JSONObject.parseObject(data, new TypeReference<MsgBean>() {});
                if(bean.isSuccess()){
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

    private void getCaptchaTime(TextView send,TextView miao) {
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
                miao.setText(captchaTime +"秒后重试");
                mHandler.postDelayed(this, 1000);
                // 延时时长
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
        // 打开定时器，执行操作
    }

    private boolean validateInput(String userName, String code) {
        if (TextUtils.isEmpty(userName)||!utils.isMobile(userName)) {
            utils.showToast("帐号有误，请重新输入");
            return false;
        }
        if (TextUtils.isEmpty(code)) {
            utils.showToast("验证码输入有误，请重新输入");
            return false;
        }
        return true;
    }
}
