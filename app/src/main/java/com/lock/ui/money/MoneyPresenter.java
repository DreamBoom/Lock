package com.lock.ui.money;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.base.App;
import com.lock.bean.MoneyBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.bill.BillActivity;
import com.lock.ui.bindaccount.BindAccountActivity;
import com.lock.ui.changepass.ChangepassActivity;
import com.lock.ui.changepaypass.ChangePayPassActivity;
import com.lock.ui.moneyin.MoneyInActivity;
import com.lock.ui.moneyout.MoneyOutActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.MD5Utils;
import com.lock.utils.Tool;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MoneyPresenter extends BasePresenterImpl<MoneyContract.View> implements MoneyContract.Presenter{
    private ActivityUtils utils;
    private Activity act;

    @Override
    public void setMoney(Activity act) {
        utils = new ActivityUtils(act);
        this.act = act;
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().money(token,new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MoneyBean bean = JSONObject.parseObject(data, new TypeReference<MoneyBean>() {});
                mView.money(bean.getModule().getBalanceDesc(),bean.getModule().getCashDesc(),
                        bean.getModule().getMarginDesc());
                mk.encode(Tool.money,bean.getModule().getCash());
            }
        });
    }

    @Override
    public void bindAccount() { utils.startActivity(BindAccountActivity.class); }
    @Override
    public void moneyIn() { utils.startActivity(MoneyInActivity.class); }
    @Override
    public void moneyOut(TextView tv) {pass(tv); }
    @Override
    public void changePass() { utils.startActivity(ChangepassActivity.class); }
    @Override
    public void changePayPass() { utils.startActivity(ChangePayPassActivity.class); }
    @Override
    public void bill() { utils.startActivity(BillActivity.class); }

    private void pass(TextView tv) {
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
                utils.startActivity(MoneyOutActivity.class);
                promess.dismiss();
            }else {
                utils.showToast("密码错误，请从新输入");
                et_2.setText("".toCharArray(), 0, "".length());
            }
        });
        promess.setContentView(v);
        promess.showAsDropDown(tv);
    }
}
