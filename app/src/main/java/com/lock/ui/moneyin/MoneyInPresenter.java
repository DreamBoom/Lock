package com.lock.ui.moneyin;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.bean.MoneyInBean;
import com.lock.bean.MoneyResult;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;
import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MoneyInPresenter extends BasePresenterImpl<MoneyInContract.View> implements MoneyInContract.Presenter{

    private int inType = 1;
    private ActivityUtils utils;
    private int agree = 1;
    @Override
    public void agree(int i) {
        agree = i;
    }

    @Override
    public void inType(int type) {
        inType = type;
    }

    @Override
    public void init(EditText et, Activity act) {
        utils = new ActivityUtils(act);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                double aDouble = Double.parseDouble("" + s);
                mView.moneyBack(utils.save2(aDouble));
            }
        });
    }

    @Override
    public void moneyIn(Activity act, String money) {
        if(TextUtils.isEmpty(money)){
            Toast.makeText(act,"请选择充值金额",Toast.LENGTH_SHORT).show();
            return;
        }
        if(agree == 2){
            Toast.makeText(act,"请阅读并同意好锁相关协议",Toast.LENGTH_SHORT).show();
            return;
        }
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().moneyIn(token,money,inType+"", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MoneyInBean bean = JSONObject.parseObject(data, new TypeReference<MoneyInBean>() {});
                if(bean.isSuccess()){
                    result(act,bean.getModule().getId());
                }else {
                    Toast.makeText(act,bean.getMessage(),Toast.LENGTH_SHORT).show();
                    utils.hindload();
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                super.onError(throwable, b);
                utils.hindload();
            }
        });
    }

    private void result(Activity act,int id) {
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().moneyResult(token,id+"", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MoneyResult bean = JSONObject.parseObject(data, new TypeReference<MoneyResult>() {});
                Toast.makeText(act,bean.getMessage(),Toast.LENGTH_SHORT).show();
                if(bean.isSuccess()){
                    mView.success();
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
