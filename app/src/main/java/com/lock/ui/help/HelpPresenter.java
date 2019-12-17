package com.lock.ui.help;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.BasePresenterImpl;
import com.lock.ui.help.learn.LearnFragment;
import com.lock.ui.help.question.QuestionFragment;

import java.util.ArrayList;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class HelpPresenter extends BasePresenterImpl<HelpContract.View> implements HelpContract.Presenter{

    @Override
    public ArrayList<Fragment> list() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new QuestionFragment());
        fragments.add(new LearnFragment());
        return fragments;
    }

    @Override
    public void call(Activity act,String phone, RelativeLayout view) {
        showPop(act, phone);
        popup.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
    }

    private PopupWindow popup;

    @SuppressLint("SetTextI18n")
    private void showPop(Activity act, String phone) {
        View view = LayoutInflater.from(act).inflate(R.layout.phone_dialog, null);
        TextView sure = view.findViewById(R.id.sure);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView title = view.findViewById(R.id.title);
        title.setText("拨打客服电话：" + phone);
        popup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popup.setTouchable(true);
        popup.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popup.setBackgroundDrawable(dw);
        sure.setOnClickListener(v -> {
            popup.dismiss();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            act.startActivity(intent);

        });
        cancel.setOnClickListener(v -> popup.dismiss());
    }

}
