package com.lock.ui.setting;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.amap.api.maps2d.AMap;
import com.lock.base.App;
import com.lock.bean.ExitBean;
import com.lock.bean.MasterDealBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.area.AreaActivity;
import com.lock.ui.help.HelpActivity;
import com.lock.ui.login.LoginActivity;

import com.lock.utils.ActivityUtils;
import com.lock.utils.CleanUtils;
import com.lock.utils.Tool;

import java.lang.reflect.Method;
import java.util.List;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SettingPresenter extends BasePresenterImpl<SettingContract.View> implements SettingContract.Presenter {

    private ActivityUtils utils;

    @Override
    public void exit(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().exit(token, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    if (bean.getCode().equals("00")) {
                        utils.showToast("退出成功");
                        mk.clear();
                        App.finishAll();
                        utils.startActivity(LoginActivity.class);
                    }
                } else {
                    utils.showToast("网络异常，请稍后重试");
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    @Override
    public void help(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.startActivity(HelpActivity.class);
    }

    @Override
    public void setArea(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.startActivity(AreaActivity.class);
    }

    @Override
    public void clean(Activity act) {
        CleanUtils.cleanCache(act);
        mView.getMemory(CleanUtils.getMemory(act),1);
    }

    @Override
    public void initMemory(Activity act) {
        mView.getMemory(CleanUtils.getMemory(act),0);
    }
}
