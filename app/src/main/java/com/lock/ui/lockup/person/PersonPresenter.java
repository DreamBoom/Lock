package com.lock.ui.lockup.person;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lock.R;
import com.lock.bean.ExitBean;
import com.lock.mvp.BasePresenterImpl;
import com.lock.net.BaseHttpCallBack;
import com.lock.net.HttpRequestPort;
import com.lock.utils.ActivityUtils;
import com.lock.utils.BitmapUtils;
import com.lock.utils.MyGlideEngine;
import com.lock.utils.Tool;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.io.IOException;
import static com.lock.ui.Splash.mk;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonPresenter extends BasePresenterImpl<PersonContract.View>
        implements PersonContract.Presenter {
    private Activity act;
    private ActivityUtils utils;
    private TextView view;
    private File f0, f1, f2;

    @Override
    public void save(Activity act,String phone, String name, int sex, String num, String address, String addressInfo,
                     String qu, String adCode, String lgt, String lat) {
        String s;
        if (sex == 0) {
            s = "男";
        } else {
            s = "女";
        }
        this.act = act;
        utils = new ActivityUtils(act);
        String tokenId = mk.decodeString(Tool.tokenId, "");
        HttpRequestPort.getInstance().upload(tokenId, name, s, adCode, qu, address,
                addressInfo, lgt, lat, num, f0, f1, f2, new BaseHttpCallBack(act) {
                    @Override
                    public void onSuccess(String data) {
                        super.onSuccess(data);
                         ExitBean bean = JSONObject.parseObject(data, new TypeReference<ExitBean>() {});
                        utils.showToast(bean.getMessage());
                         if(bean.isSuccess()){
                             mView.success();
                         }
                    }
                });
    }

    @Override
    public void photo(Activity act, TextView view) {
        this.act = act;
        this.view = view;
        utils = new ActivityUtils(act);
        Matisse.from(act)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG)) // 选择 mime 的类型
                .countable(true)
                .crop(false)     //设置为true后，才会进入截图模式，默认为false，进入为知乎普通图片选择器
                // .cropOptions(options) //设置uCrop裁剪参数
                // .cropUri(uri)         //设置截图后的保存路径
                .maxSelectable(1) // 图片选择的最多数量
                .gridExpectedSize(act.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(1f) // 缩略图的比例
                .imageEngine(new MyGlideEngine()) // 使用的图片加载引擎
                .capture(true) //是否提供拍照功能
                .captureStrategy(new CaptureStrategy(true, "com.lock.file"))//存储到哪里
                .forResult(201); // 设置作为标记的请求码
    }

    @Override
    public void upPhoto(Uri uri, int i) {
        String mt = Build.BRAND;
        Bitmap bitm = null;
        try {
            bitm = BitmapUtils.uriToBitmap(act, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mt.equals("xiaomi") || mt.equals("Xiaomi")) {
            bitm = utils.degree(bitm);
        }
        //图片压缩
        Bitmap bitmap = BitmapUtils.compressScale(bitm);
        switch (i) {
            case 0:
                assert bitm != null;
                f0 = BitmapUtils.bitToFile(bitmap);
                break;
            case 1:
                assert bitm != null;
                f1 = BitmapUtils.bitToFile(bitmap);
                break;
            case 2:
                assert bitm != null;
                f2 = BitmapUtils.bitToFile(bitmap);
                break;
        }
    }
}
