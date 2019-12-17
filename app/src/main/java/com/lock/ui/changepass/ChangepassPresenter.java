package com.lock.ui.changepass;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
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

public class ChangepassPresenter extends BasePresenterImpl<ChangepassContract.View>
        implements ChangepassContract.Presenter {

    private ActivityUtils utils;

    @Override
    public void changePass(Activity act, String oldPass, String newPass) {
        utils = new ActivityUtils(act);
        utils.hideSoftKeyboard();
        if(validateInput(oldPass,newPass)){
            utils.getload(act);
            String token = mk.decodeString(Tool.tokenId, "");
            String encrypt = MD5Utils.encrypt(newPass + "hzhs_login");
            HttpRequestPort.getInstance().changePass(token,encrypt,new BaseHttpCallBack(act) {
                @Override
                public void onSuccess(String data) {
                    super.onSuccess(data);
                    ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                    });
                    if (bean.isSuccess()) {
                        utils.showToast(bean.getMessage());
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

    private boolean validateInput(String pass, String newPass) {
        String encrypt = MD5Utils.encrypt(pass + "hzhs_login");
        String p = mk.decodeString(Tool.pass, "");
        assert encrypt != null;
        if (TextUtils.isEmpty(pass) || !encrypt.equals(p)) {
            utils.showToast("原密码输入错误，请重新输入");
            return false;
        }
        if (TextUtils.isEmpty(newPass) || newPass.length() < 6) {
            utils.showToast("新密码长度不能低于6位");
            return false;
        }
        return true;
    }
}
