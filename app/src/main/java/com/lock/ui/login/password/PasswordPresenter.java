package com.lock.ui.login.password;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.base.App;
import com.lock.base.BaseActivity;
import com.lock.bean.LoginBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.mvp.BaseView;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.Splash;
import com.lock.ui.forget.ForgetActivity;
import com.lock.ui.login.LoginActivity;
import com.lock.ui.main.MainActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;
import java.io.File;

import static com.lock.ui.Splash.mk;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PasswordPresenter extends BasePresenterImpl<PasswordContract.View>
        implements PasswordContract.Presenter {
    private ActivityUtils utils;
    private boolean agree = true;
    private boolean canSee = false;

    @Override
    public void login(Activity act, String userName, String password) {
        utils = new ActivityUtils(act);
        if (!agree) {
            utils.showToast("请先阅读并同意本服务条例");
            return;
        }
        String pass = MD5Utils.encrypt(password + "hzhs_login");
        utils.getload(act);
        if (validateInput(userName, password)) {
            HttpRequestPort.getInstance().loginPassword(userName, pass, new BaseHttpCallBack(act) {
                @Override
                public void onSuccess(String data) {
                    super.onSuccess(data);
                    LoginBean bean = JSONObject.parseObject(data, new TypeReference<LoginBean>() {});
                    if (bean.isSuccess()) {
                        mk.encode(Tool.phone,userName);
                        mk.encode(Tool.tokenId, bean.getModule().getTokenId());
                        mk.encode(Tool.tokenKey, bean.getModule().getTokenKey());
                        mk.encode(Tool.loginTime, bean.getModule().getLastLoginTime());
                        mk.encode(Tool.mstatus, bean.getModule().getMstatus());
                        mk.encode(Tool.name, bean.getModule().getRealName());
                        mk.encode(Tool.pass,pass);
                        utils.startActivity(MainActivity.class);
                    } else {
                        if ("0004".equals(bean.getCode())) {//用户不存在,短信登录
                            utils.showToast(bean.getMessage());
                            LoginActivity.mTab.getTabAt(1).select();
                            //密码错误
                        } else {
                            utils.showToast(bean.getMessage());
                        }
                    }
                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    super.onError(throwable, b);
                    utils.showToast("登录失败，请稍后重试");
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
        if (agree) {
            agree = false;
            img.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yuan));
        } else {
            agree = true;
            img.setBackground(ContextCompat.getDrawable(act, R.drawable.ico_yes));
        }
    }

    @Override
    public void canSee(Activity act, EditText edit, ImageView img) {
        if (canSee) {
            canSee = false;
            edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            img.setImageDrawable(ContextCompat.getDrawable(act, R.drawable.close));
            String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
            Bitmap bm = BitmapFactory.decodeFile(path);
            img.setImageBitmap(bm);
            img.setImageResource(R.drawable.close);
        } else {
            canSee = true;
            edit.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            img.setImageDrawable(ContextCompat.getDrawable(act, R.drawable.open));
            String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
            Bitmap bm = BitmapFactory.decodeFile(path);
            img.setImageBitmap(bm);
            img.setImageResource(R.drawable.open);
        }
    }

    @Override
    public void forget(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.startActivity(ForgetActivity.class);
    }

    @Override
    public void web(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
    }

    private boolean validateInput(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || !utils.isMobile(userName)) {
            utils.showToast("帐号或密码有误，请重新输入");
            return false;
        }
        return true;
    }
}
