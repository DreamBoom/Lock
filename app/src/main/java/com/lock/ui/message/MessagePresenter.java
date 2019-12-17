package com.lock.ui.message;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import com.lock.R;
import com.lock.adapter.MessageAdapter;
import com.lock.mvp.BasePresenterImpl;
import com.lock.ui.setting.SettingActivity;
import com.lock.ui.zxing.activity.CaptureActivity;
import com.lock.utils.ActivityUtils;

import java.util.ArrayList;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MessagePresenter extends BasePresenterImpl<MessageContract.View> implements MessageContract.Presenter{

    private ActivityUtils utils;
    private Activity act;

    @Override
    public void init(Activity act,ListView listview) {
        this.act = act;
        utils = new ActivityUtils(act);
        ArrayList<String> list = new ArrayList<>();
        list.add("测试消息");
//        list.add("系统消息");
//        list.add("系统消息");
//        list.add("系统消息");
//        list.add("系统消息");
        MessageAdapter adapter = new MessageAdapter(act, list, R.layout.message_item);
        listview.addHeaderView(utils.getView(R.layout.header_ms));
        listview.setAdapter(adapter);
    }

    @Override
    public void toSetting() {
        utils.startActivity(SettingActivity.class);
    }

    @Override
    public void toSys() {
        if(utils == null){
            utils = new ActivityUtils(act);
        }
        utils.startActivity(CaptureActivity.class);
    }
}
