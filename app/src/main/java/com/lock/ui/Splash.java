package com.lock.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.bean.LoginBean;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.login.LoginActivity;
import com.lock.ui.main.MainActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;
import com.tencent.mmkv.MMKV;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionNo;
import com.yanzhenjie.permission.PermissionYes;

import java.util.List;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Splash extends AppCompatActivity {
    private Context context;
    private ActivityUtils utils;
    private TextView proView;
    @SuppressLint("StaticFieldLeak")
    public static MMKV mk = MMKV.defaultMMKV();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        utils = new ActivityUtils(this);
        proView = findViewById(R.id.pro_view);
        context = this;
        AndPermission.with(this)
                .requestCode(300)
                .permission(
                        CAMERA,
                        READ_PHONE_STATE,
                        ACCESS_FINE_LOCATION,
                        ACCESS_COARSE_LOCATION,
                        WRITE_EXTERNAL_STORAGE,
                        READ_EXTERNAL_STORAGE)
                .callback(this)
                .start();
    }

    // 成功回调的方法，用注解即可，这里的300就是请求时的requestCode。
    @PermissionYes(300)
    private void getPermissionYes(List<String> grantedPermissions) {
        new Handler().postDelayed(() -> {
            String s = mk.decodeString(Tool.tokenId, "");
            if (TextUtils.isEmpty(s)) {
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                String phone = mk.decodeString(Tool.phone, "");
                String pass = mk.decodeString(Tool.pass, "");
                HttpRequestPort.getInstance().loginPassword(phone, pass, new BaseHttpCallBack(this) {
                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);
                        LoginBean bean = JSONObject.parseObject(data, new TypeReference<LoginBean>() {});
                        if (bean.isSuccess()) {
                            mk.encode(Tool.tokenId, bean.getModule().getTokenId());
                            mk.encode(Tool.tokenKey, bean.getModule().getTokenKey());
                            mk.encode(Tool.loginTime, bean.getModule().getLastLoginTime());
                            mk.encode(Tool.mstatus, bean.getModule().getMstatus());
                            mk.encode(Tool.name, bean.getModule().getRealName());
                            utils.startActivity(MainActivity.class);
                            finish();
                        }
                    }
                });
            }
        }, 2000);
    }

    @PermissionNo(300)
    private void getPermissionNo(List<String> deniedPermissions) {
        // 申请权限失败。
        // 是否有不再提示并拒绝的权限
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
            // 第一种：用AndPermission默认的提示语。
            // AndPermission.defaultSettingDialog(this, 400).show();
            promess();
        }
    }

    //存储权限被拒弹窗
    private void promess() {
        View v = utils.getView(this, R.layout.pop_prossmess);
        PopupWindow promess = new PopupWindow(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        promess.setContentView(v);
        promess.setBackgroundDrawable(new ColorDrawable(0x00000000));
        promess.setClippingEnabled(false);
        promess.showAsDropDown(proView);
        TextView tv_2 = v.findViewById(R.id.tv_2);
        tv_2.setText("权限被拒绝，请在设置中授权后重试");
        //存储权限被拒绝，请在设置中授权后重试
        TextView tv_3 = v.findViewById(R.id.tv_3);
        tv_3.setOnClickListener(v12 -> promess.dismiss());
        TextView tv_4 = v.findViewById(R.id.tv_4);
        tv_4.setOnClickListener(v1 -> promess.dismiss());
    }
}
