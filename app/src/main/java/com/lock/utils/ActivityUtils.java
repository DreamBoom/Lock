package com.lock.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lock.R;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Created by Dream
 */
public class ActivityUtils {
    private WeakReference<Activity> activityWeakReference;
    private WeakReference<Fragment> fragmentWeakReference;
    private Toast toast;
    private int y1 = 32767, y2 = 65536;

    public ActivityUtils(Activity activity) {
        activityWeakReference = new WeakReference<>(activity);
    }

    public ActivityUtils(Fragment fragment) {
        fragmentWeakReference = new WeakReference<>(fragment);
    }

    private
    @Nullable
    Activity getActivity() {
        if (activityWeakReference != null) {
            return activityWeakReference.get();
        }
        if (fragmentWeakReference != null) {
            Fragment fragment = fragmentWeakReference.get();
            return fragment == null ? null : fragment.getActivity();
        }
        return null;
    }

    @SuppressLint("ShowToast")
    public void showToast(CharSequence msg) {
        Activity activity = getActivity();
        if (activity != null) {
            if (toast == null) {
                toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
            }
            toast.setText(msg);
            toast.show();
        }
    }

    @SuppressWarnings("SameParameterValue")
    public void showToast(int resId) {
        Activity activity = getActivity();
        if (activity != null) {
            String msg = activity.getString(resId);
            showToast(msg);
        }
    }

    //获取显示进度条
    private Dialog dialog;

    @SuppressLint("InflateParams")
    public void getload(Context context) {
        dialog = new Dialog(context, R.style.MyDialog);
        dialog.show();
        dialog.getWindow().setContentView(LayoutInflater.from(context).inflate(R.layout.progress, null));
        dialog.setCancelable(true);
    }

    //隐藏进度条
    public void hindload() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }


    public void startActivity(Class<? extends Activity> clazz) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }

    public void startActivityForResult(Class<? extends Activity> clazz, int requestcode) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, clazz);
        activity.startActivityForResult(intent, requestcode);
    }

    public boolean checkIdCard(String idCard) {
        String regex = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";
        return Pattern.matches(regex, idCard);
    }


    public void toStartActivityForResult(Class<? extends Activity> clazz,
                                         int requestcode, Bundle bundle) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, clazz);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestcode);
    }

    public void hideSoftKeyboard() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public View getView(Context context, int viewId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(viewId, null);
        return view;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersion() {
        Activity activity = getActivity();
        try {
            assert activity != null;
            PackageManager manager = activity.getPackageManager();
            PackageInfo info = manager.getPackageInfo(activity.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断是否有sd卡
     *
     * @return
     */
    public boolean sdCardexit() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 安装apk
     *
     * @param path
     */
    public static void installAPK(Activity aty, String path) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
        aty.startActivity(intent);
    }

//    //获取显示进度条
//    Dialog dialog;
//
//    @SuppressLint("InflateParams")
//    public void getProgress(Context context) {
//        dialog = new Dialog(context, R.style.MyDialog);
//        dialog.show();
//        dialog.getWindow().setContentView(LayoutInflater.from(context).inflate(R.layout.progress, null));
//        dialog.setCancelable(true);
//    }
//
//    //隐藏进度条
//    public void hindProgress() {
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//    }

    //保留两位小数
    public String save2(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public String getUTF8XMLString(String xml) {
        // A StringBuffer Object
        StringBuffer sb = new StringBuffer();
        sb.append(xml);
        String xmString = "";
        String xmlUTF8 = "";
        try {
            xmString = new String(sb.toString().getBytes("UTF-8"));
            xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // return to String Formed
        return xmlUTF8;
    }

    public View getView(int layoutId) {
        Activity activity = getActivity();
        return LayoutInflater.from(activity).inflate(layoutId,
                new RelativeLayout(activity));
    }

    public int byteToInt(byte b) {
        int i = b;
        i = b & 0xff;
        return i;
    }

    /**
     * @return string
     */
    public String[] bytesToHexString(byte[] bArray) {
        StringBuilder sb = new StringBuilder(bArray.length);
        for (byte aBArray : bArray) {
            String sTemp = Integer.toHexString(0xFF & aBArray);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase()).append(",");
        }
        return sb.toString().split(",");
    }

    public String[] toSixString(byte[] b) {
        String[] p = new String[b.length];
        for (int i = 0; i < 10; i++) {
            //byte转16进制
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
//            LogUtils.i("=========>>>>>>"+Integer.parseInt(hex, 16)+"=======>>>>>>>");
//            //16进制转10进制
//            int i1 = Integer.parseInt(hex.toUpperCase(), 16);
//            //10进制转字符串添加进数组
//            p[i]=String.valueOf(i1);
        }
        return p;
    }

    public float toNum(String s) {
        // LogUtils.i("=====>"+ Integer.parseInt(String.valueOf("ff18"), 16)+"=======.......=======" );
        return (float) Integer.parseInt(s, 16);
    }

    public byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    public float backNum(float f) {
        float f1;
        if (f > y1) {
            f1 = (f - y2) / 10;
        } else {
            f1 = f / 10;
        }
        return f1;
    }

    public float backNum1(float f) {
        float f1;
        if (f > y1) {
            f1 = f - y2;
        } else {
            f1 = f;
        }
        return f1;
    }

    public float backNum2(float f) {
        float f1;
        if (f > y1) {
            f1 = (f - y2) / 1000f;
        } else {
            f1 = f / 1000;
        }
        return f1;
    }

    public String getCurProcessName() {
        Activity activity = getActivity();
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) activity
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    public boolean isMobile(String mobiles) {
        Pattern p = Pattern
                .compile("^1[3|4|5|6|7|8|9]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }

    /**
     * 获取旋转角度
     * @return
     */
    public Bitmap degree(Bitmap bitmap) {
        Matrix matrix = new Matrix();//旋转图片 动作
        matrix.setRotate(90f);//旋转角度
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();// 创建新的图片
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

}
