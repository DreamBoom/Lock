package com.lock.net;

import android.app.Activity;

import com.lock.utils.ActivityUtils;
import com.lock.utils.LogUtil;

import org.xutils.common.Callback;


/**
 * @author Created by Dream
 */
public class BaseHttpCallBack implements Callback.CommonCallback<String> {
    //private final int CODE_0 = 0;//请求成功
   // private final int CODE_102 = 102;//token已失效

    private Activity aty;
    private ActivityUtils utils;

    public BaseHttpCallBack(Activity aty) {
        this.aty = aty;
        utils = new ActivityUtils(aty);
    }

    @Override
    public void onSuccess(String data) {
        LogUtil.i("TAG请求成功========>",data);

    }

    @Override
    public void onError(Throwable throwable, boolean b) {
        LogUtil.i("TAG加载失败",throwable.getMessage()+"========>");
        //utils.showToast("请求失败，请重试");
    }

    @Override
    public void onCancelled(CancelledException e) { }

    @Override
    public void onFinished() { }
}
