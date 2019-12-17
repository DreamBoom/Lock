package com.lock.ui.lockup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.bean.ExitBean;
import com.lock.bean.LoginBean;
import com.lock.bean.MasterDealBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.lockup.person.PersonActivity;
import com.lock.ui.map.MapActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.LocationUtil;
import com.lock.utils.LogUtil;
import com.lock.utils.Tool;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LockUpPresenter extends BasePresenterImpl<LockUpContract.View>
        implements LockUpContract.Presenter {
    private ActivityUtils utils;
    private Activity act;
    @Override
    public void init(Activity act) {
        this.act = act;
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        getInfo();
    }

    private void getInfo() {
        String tokenId = mk.decodeString(Tool.tokenId, "");
        utils.getload(act);
        HttpRequestPort.getInstance().masterDeal(tokenId, "view", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MasterDealBean bean = JSONObject.parseObject(data, new TypeReference<MasterDealBean>() {});
                if(bean.isSuccess()){
                    MasterDealBean.ModuleBean module = bean.getModule();
                    mView.infoBack(module.getSex(),module.getDistrict(),module.getCityCode(),
                            module.getLongitude(),module.getLatitude(), module.getMobile(),
                            module.getNickname(),module.getIdCardNo(), module.getAddress(),
                            module.getHouse());
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
    public void showAddress(Activity act) {
        utils.startActivityForResult(MapActivity.class, Tool.forMap);
    }

    @Override
    public void next(Activity act, int sex, String phone, String name, String num, String address,
                     String addressInfo, String qu, String adCode, String lgt, String lat) {
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(act, "请输入您的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(act, "请输入您的姓名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(num)) {
            Toast.makeText(act, "请输入您的身份证号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(act, "请填写地区信息", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(addressInfo)) {
            Toast.makeText(act, "请填写街道门牌信息", Toast.LENGTH_SHORT).show();
            return;
        }
        checkKey(act, sex, phone, name, num, address, addressInfo, qu, adCode, lgt, lat);
    }

    private void checkKey(Activity act, int sex, String phone, String name, String num,
                          String address, String addressInfo, String qu, String adCode, String lgt, String lat) {
        String tokenId = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().checkKey(tokenId, num, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                if (bean.isSuccess()) {
                        Intent intent = new Intent();
                        intent.setClass(act, PersonActivity.class);
                        intent.putExtra("phone", phone);
                        intent.putExtra("qu", qu);
                        intent.putExtra("adCode", adCode);
                        intent.putExtra("lgt", lgt);
                        intent.putExtra("lat", lat);
                        intent.putExtra("sex", sex);
                        intent.putExtra("name", name);
                        intent.putExtra("num", num);
                        intent.putExtra("address", address);
                        intent.putExtra("addressInfo", addressInfo);
                        act.startActivity(intent);
                } else {
                    utils.showToast("请求失败，点击下一步重试");
                }
            }
        });
    }
}
