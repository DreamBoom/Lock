package com.lock.net;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Created by Dream
 */
public class HttpUtil {
    /**
     * get请求
     *
     * @param url
     * @param map
     * @param callBack
     * @param <T>
     * @return
     */
    public <T> Callback.Cancelable get(String url, Map<String, String> map, Callback.CommonCallback<T> callBack) {
        RequestParams params = new RequestParams(url);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setConnectTimeout(3000);
        return x.http().get(params, callBack);
    }

    /**
     * post请求
     *
     * @param url
     * @param map
     * @param callback
     * @param <T>
     * @return
     */
    public <T> Callback.Cancelable post(String url, Map<String, String> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setConnectTimeout(4000);
        return x.http().post(params, callback);
    }

    /**
     * 上传文件
     *
     * @param url
     * @param callback
     * @param <T>
     * @return
     */
    public <T> Callback.Cancelable upload(String url, File file1, File file2, File file3, String token, String nickname, String sex, String areaCode, String district, String address,
                                          String house, String longitude, String latitude, String idCardNo, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        params.setMultipart(true);
        List<KeyValue> list = new ArrayList<>();
        list.add(new KeyValue("nocrime", file1));
        list.add(new KeyValue("idfront", file2));
        list.add(new KeyValue("idback", file3));
        params.addParameter("tokenId", token);
        params.addParameter("type", "apply");
        params.addParameter("nickname", nickname);
        params.addParameter("sex", sex);
        params.addParameter("areaCode", areaCode);
        params.addParameter("district", district);
        params.addParameter("address", address);
        params.addParameter("house", house);
        params.addParameter("longitude", longitude);
        params.addParameter("latitude", latitude);
        params.addParameter("idCardNo", idCardNo);
        params.addParameter("imgIdBack", "");
        //设置编码格式为UTF-8，保证参数不乱码
        MultipartBody body = new MultipartBody(list, "UTF-8");
        params.setRequestBody(body);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    /**
     * 上传文件
     *
     * @param url
     * @param callback
     * @param <T>
     * @return
     */
    public <T> Callback.Cancelable upInfo(String url, File file1, File file2, File file3, String token, String json, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        params.setMultipart(true);
        List<KeyValue> list = new ArrayList<>();
        list.add(new KeyValue("bill1", file1));
        list.add(new KeyValue("bill2", file2));
        list.add(new KeyValue("bill3", file3));
        params.addParameter("tokenId", token);
        params.addParameter("type", "bill");
        params.addParameter("bills", json);
        //设置编码格式为UTF-8，保证参数不乱码
        MultipartBody body = new MultipartBody(list, "UTF-8");
        params.setRequestBody(body);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }


    public Callback.Cancelable download(String url, String path, Callback.ProgressCallback<File> callback) {
        RequestParams params = new RequestParams(url);
        params.setSaveFilePath(path);
        params.setAutoRename(true);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    public <T> Callback.Cancelable postJson(String url, String json, BaseHttpCallBack callBack) {
        RequestParams params = new RequestParams(url);
        params.setBodyContent(json);
        Callback.Cancelable cancelable = x.http().post(params, callBack);
        return cancelable;
    }
}
