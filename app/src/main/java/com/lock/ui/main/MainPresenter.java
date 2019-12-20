package com.lock.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.drawable.ColorDrawable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.bean.ExitBean;
import com.lock.bean.MasterDealBean;
import com.lock.bean.OrderListBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.ui.News;
import com.lock.ui.lockup.LockUpActivity;
import com.lock.ui.moneyin.MoneyInActivity;
import com.lock.ui.order.OrderActivity;
import com.lock.ui.user.UserActivity;
import com.lock.utils.ActivityUtils;
import com.lock.utils.Tool;

import java.util.ArrayList;
import java.util.List;

import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {
    private ActivityUtils utils;
    private ArrayList<String> strs;

    @Override
    public List<View> setGg(Activity act) {
        utils = new ActivityUtils(act);
        strs = new ArrayList<>();
        ArrayList<View> views = new ArrayList<>();
        strs.add("您有新的锁匠权益待领取。");
        strs.add("欢迎加入好锁服务平台，更多服务需进行认证。点击查看认证流程。");
        strs.add("回馈老用户，限时免手续费。");
        strs.add("江干区新塘路和谐嘉园成交了新得开门锁订单。");
        strs.add("萧山区金鸡路知稼苑成交了新的开门锁订单。");
        strs.add("余杭区世纪大道西康城国际成交了新的换门锁订单。");
        strs.add("拱墅区通益路吉如家园成交了新得换门锁订单。");
        strs.add("下城区文晖路现代置业大厦成交了新的换车锁订单。");
        strs.add("上城区甘王路甘王路小区成交了新的开保险柜订单。");
        strs.add("限时免押金认证锁匠，享平台6大特权。");
        for (int i = 0; i < strs.size(); i++) {
            View view = utils.getView(R.layout.gg_item);
            TextView tv_gg = view.findViewById(R.id.tv_gg);
            tv_gg.setText(strs.get(i));
            views.add(view);
        }
        return views;
    }

    @Override
    public void headerShow(Activity act) {
        int s = mk.decodeInt(Tool.mstatus, -1);
        boolean b = mk.decodeBool(Tool.rest, false);
        if(b){
            mView.stopWork();
        }else {
            mView.startWork();
        }
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        switch (s) {
            case 0:
            case -1:
                mView.status0();
                break;
            case 1:
                mView.status1();
                break;
            case 2:
                orderList(act);
                break;
            case 3:
                mView.status3();
                break;
            case 8:
                mView.status8();
                break;
            case 9:
                mView.status9();
                break;
        }
    }

    @Override
    public void toUser(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.startActivity(UserActivity.class);
    }

    @Override
    public void toLockUp(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        utils.startActivity(LockUpActivity.class);
    }

    @Override
    public void toGg(Activity act, int i) {
        Intent intent = new Intent();
        intent.setClass(act, News.class);
        intent.putExtra("news", strs.get(i));
        act.startActivity(intent);
    }

    @Override
    public void toOrder(Activity act) {
        Intent intent = new Intent();
        intent.putExtra("site", 0);
        intent.setClass(act, OrderActivity.class);
        act.startActivity(intent);
    }

    @Override
    public void toTv1(Activity act) {
        int i = mk.decodeInt(Tool.mstatus, -1);
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        switch (i) {
            case 1:
                //审核中
                utils.startActivity(LockUpActivity.class);
                break;
            case 3:
                //未通过

                break;
            case 8:
                //账号异常，点击充值

                break;
            case 9:
                //账号违规

                break;
        }
    }

    @Override
    public void toTv2(Activity act, RelativeLayout view) {
        int i = mk.decodeInt(Tool.mstatus, -1);
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        switch (i) {
            case 1:
                //审核中
                masterDeal(act);
                break;
            case 3:
                //未通过
                utils.startActivity(LockUpActivity.class);
                break;
            case 8:
                //账号异常，点击充值
                utils.startActivity(MoneyInActivity.class);
                break;
            case 9:
                //账号违规
                showPop(act);
                popup.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
                break;
        }
    }

    @Override
    public void checkRest(Activity act, boolean rest) {
        if (rest) {
            startService(act);
        } else {
            stopService(act);
        }
    }

    private void startService(Activity act) {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().startService(token, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    mView.startWork();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    private void stopService(Activity act) {
        utils.getload(act);
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().stopService(token, new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {
                });
                if (bean.isSuccess()) {
                    mView.stopWork();
                }
            }

            @Override
            public void onFinished() {
                super.onFinished();
                utils.hindload();
            }
        });
    }

    private void masterDeal(Activity act) {
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().masterDeal(token, "view", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                MasterDealBean bean = JSONObject.parseObject(data, new TypeReference<MasterDealBean>() {
                });
                int s = bean.getModule().getMstatus();

                mk.encode(Tool.mstatus, s);
                switch (s) {
                    case -1:
                        mView.status0();
                        break;
                    case 1:
                        mView.status1();
                        break;
                    case 2:
                        orderList(act);
                        break;
                    case 3:
                        mView.status3();
                        break;
                    case 8:
                        mView.status8();
                        break;
                    case 9:
                        mView.status9();
                        break;
                }
            }
        });
    }

    private void orderList(Activity act) {
        if (utils == null) {
            utils = new ActivityUtils(act);
        }
        String token = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().OrderList(token, "all", "1", new BaseHttpCallBack(act) {
            @Override
            public void onSuccess(String data) {
                super.onSuccess(data);
                OrderListBean bean = JSONObject.parseObject(data, new TypeReference<OrderListBean>() {
                });
                if (bean.isSuccess()) {
                    if (bean.getModule().size() > 0) {
                        ArrayList<OrderListBean.ModuleBean> list = new ArrayList<>(bean.getModule());
                        mView.orderList(list);
                        mView.status2(1);
                    } else {
                        mView.status2(0);
                    }
                } else {
                    utils.showToast("请求失败，请刷新重试");
                }
            }
        });
    }

    private PopupWindow popup;

    private void showPop(Activity act) {
        View view = LayoutInflater.from(act).inflate(R.layout.phone_dialog, null);
        TextView sure = view.findViewById(R.id.sure);
        TextView cancel = view.findViewById(R.id.cancel);
        popup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popup.setTouchable(true);
        popup.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popup.setBackgroundDrawable(dw);
        sure.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:13462439645"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            act.startActivity(intent);
        });
        cancel.setOnClickListener(v -> popup.dismiss());
    }
}
