package com.lock.ui.moneyout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lock.R;
import com.lock.base.App;
import com.lock.mvp.BasePresenterImpl;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;

import static com.lock.ui.Splash.mk;
import static java.lang.Double.valueOf;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoneyOutPresenter extends BasePresenterImpl<MoneyOutContract.View> implements MoneyOutContract.Presenter {
    private int outType;
    private PopupWindow popup;

    @Override
    public void outType(int type) {
        outType = type;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPop(Activity act, View v1, String m, int type) {
        if (TextUtils.isEmpty(m)) {
            Toast.makeText(act, "请输入提现金额", Toast.LENGTH_LONG).show();
            return;
        }
        View view = LayoutInflater.from(act).inflate(R.layout.money_dialog, null);
        TextView money = view.findViewById(R.id.out_money);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView sure = view.findViewById(R.id.sure);
        money.setText("转出金额:" + m + "元");
        popup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popup.setTouchable(true);
        popup.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popup.setBackgroundDrawable(dw);
        cancel.setOnClickListener(v -> popup.dismiss());
        sure.setOnClickListener(v -> {
                    popup.dismiss();
                    outMoney(m, type);
                }
        );
        popup.showAtLocation(v1, Gravity.NO_GRAVITY, 0, 0);
    }

    private void outMoney(String m, int i) {
        mView.outMoney();
    }
}
