package com.lock.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;

import com.lock.utils.Tool;
import com.tencent.mmkv.MMKV;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 by yugai 时间 16/10/26.
 * ＊ 邮箱 784787081@qq.com
 */

public class App extends Application {
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        MMKV.initialize(this);
    }

    public static List<Activity> activitys = new ArrayList<Activity>();

    //向List中添加一个活动
    public static void addActivity( Activity activity ){
        activitys.add(activity);
    }

    //从List中移除活动
    public static void removeActivity( Activity activity ){
        activitys.remove(activity);
    }

    //将List中存储的活动全部销毁掉
    public static void finishAll(){
        for ( Activity activity : activitys ) {
            if ( !activity.isFinishing() ) {
                activity.finish();
            }
        }
    }
}
