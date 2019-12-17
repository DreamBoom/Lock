package com.lock.net;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Dream
 * 网络接口
 */
public class HttpRequestPort {
    //http://msc.kaihs.com/test.jsp
    //http://mng.kaihs.com/index.html
    private final static  String BASEURL = "http://msc.kaihs.com/";
    public final static  String URL = "http://msc.kaihs.com/";
    private HttpUtil httpUtil;
    private Map<String, String> map;
    private static HttpRequestPort httpRequestPort;
    public static HttpRequestPort getInstance() {
        if (httpRequestPort == null) {
            httpRequestPort = new HttpRequestPort();
        }
        return httpRequestPort;
    }
    public HttpRequestPort() {
        httpUtil = new HttpUtil();
    }

    /**密码登录*/
    public void loginPassword(String user,String pwd,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("imei", "imei");
        map.put("user", user);
        map.put("pwd", pwd);
        httpUtil.get(BASEURL+ "pwdLogin.do", map, callBack);
    }

    /**验证码登录*/
    public void loginMessage(String user,String smsCode,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("imei", "imei");
        map.put("mobile", user);
        map.put("smsCode", smsCode);
        httpUtil.get(BASEURL+ "smsLogin.do", map, callBack);
    }

    /**获取登录验证码*/
    public void LoginCode(String phone,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("mobile", phone);
        httpUtil.get(BASEURL+ "code/getLoginCode.do", map, callBack);
    }

    /**获取交易密码验证码*/
    public void payCode(BaseHttpCallBack callBack) {
        map = new HashMap<>();
        httpUtil.get(BASEURL+ "code/getAuthCode.do", map, callBack);
    }

    /**订单列表*/
    public void OrderList(String token,String type,String page,BaseHttpCallBack callBack) {
//        "1、未完成：type=service、currentPage（page no）
//        2、所有：type=all、currentPage"
        map = new HashMap<>();
        map.put("type", type);
        map.put("token", token);
        map.put("currentPage", page);
        httpUtil.get(BASEURL+ "biz/bizOrderList.do", map, callBack);
    }

    /**订单处理*/
    public void order(String token,String type,String orderId,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", type);
        map.put("orderId", orderId);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do", map, callBack);
    }
    /**订单取消*/
    public void orderCancel(String token,String orderId,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "cancel");
        map.put("orderId", orderId);
        map.put("cancelMemo", "");
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do", map, callBack);
    }


    /**绑定账户*/
    public void addAccount(String token,String accountType,String account,String realName,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("account",account);
        map.put("payType",accountType);
        map.put("type", "cnadd");
        map.put("realName", realName);
        httpUtil.get(BASEURL+ "fund/acctDeal.do", map, callBack);
    }

    /**账户列表*/
    public void accountList(String token,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "cnlist");
        httpUtil.get(BASEURL+ "fund/acctDeal.do", map, callBack);
    }

    /**退出*/
    public void exit(String token,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        httpUtil.get(BASEURL+ "logout.do", map, callBack);
    }

    /**查询余额*/
    public void money(String token,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "balance");
        httpUtil.get(BASEURL+ "fund/acctDeal.do", map, callBack);
    }

    /**修改登录密码*/
    public void changePass(String token,String pass,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("pwd",pass);
        httpUtil.get(BASEURL+ "setpwd.do", map, callBack);
    }

    /**修改交易密码*/
    public void changePay(String token,String pass,String code,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("smsCode", code);
        map.put("pwd",pass);
        httpUtil.get(BASEURL+ "setauth.do", map, callBack);
    }

    /**交易密码核验*/
    public void payPassCheck(String token,String pass,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "acctpwd");
        map.put("pwd",pass);
        httpUtil.get(BASEURL+ "utils/authCheck.do", map, callBack);
    }

    /**账单列表*/
    public void billList(String token,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        httpUtil.get(BASEURL+ "fund/acctLogList.do", map, callBack);
    }

    /**身份证检查*/
    public void checkKey(String token,String idCardNo,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "idCardNo");
        map.put("idCardNo", idCardNo);
        httpUtil.get(BASEURL+ "utils/uniqueCheck.do", map, callBack);
    }

    /**锁匠详情*/
    public void masterDeal(String token,String type,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", type);
        httpUtil.get(BASEURL+ "user/masterDeal.do", map, callBack);
    }

    /**锁匠信息上传*/
    public void upload(String token, String nickname, String sex, String areaCode, String district, String address,
                       String house, String longitude, String latitude, String idCardNo, File f1,File f2,File f3,
                       BaseHttpCallBack callBack) {
        httpUtil.upload(BASEURL+ "user/masterDeal.do", f1,f2,f3,token,nickname,sex,
                areaCode,district,address,house,longitude,latitude,idCardNo,callBack);
    }

    /**服务费信息上传*/
    public void upInfo(String token, File f1,File f2,File f3, String json, BaseHttpCallBack callBack) {
        httpUtil.upInfo(BASEURL+ "biz/bizOrderDeal.do", f1,f2,f3,token,json,callBack);
    }


    /**开始服务*/
    public void startService(String token,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        httpUtil.get(BASEURL+ "startService.do", map,callBack);
    }
    /**停止服务*/
    public void stopService(String token, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        httpUtil.get(BASEURL+ "stopService.do",map,callBack);
    }

    /**在线充值*/
    public void moneyIn(String token,String amountDesc,String payType, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "charge");
        map.put("orderId", "");
        map.put("amountDesc", amountDesc);
        map.put("payType", payType);
        httpUtil.get(BASEURL+ "charge/deposit.do",map,callBack);
    }

    /**充值结果*/
    public void moneyResult(String token,String orderId, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "result");
        map.put("orderId",orderId);
        httpUtil.get(BASEURL+ "charge/deposit.do",map,callBack);
    }

    /**提现*/
    public void moneyOut(String token,String amountDesc,String payType, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "charge");
        map.put("orderId", "");
        map.put("amountDesc", amountDesc);
        map.put("payType", payType);
        httpUtil.get(BASEURL+ "cash/withdraw.do",map,callBack);
    }

    /**提现结果*/
    public void moneyResult1(String token,String orderId, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "result");
        map.put("orderId",orderId);
        httpUtil.get(BASEURL+ "cash/withdraw.do",map,callBack);
    }

    /**订单信息 结束 刷新 删除 催付款*/
    public void orderState(String token,String orderId,String type, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", type);
        map.put("orderId", orderId);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do",map,callBack);
    }

    /**订单开始*/
    public void orderStart(String token,String orderId,String latitude,String longitude, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "start");
        map.put("orderId", orderId);
        map.put("longitude", longitude);
        map.put("latitude", latitude);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do",map,callBack);
    }

    /**订单30秒上传位置*/
    public void orderLocation(String token,String orderId,String latitude,String longitude, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "location");
        map.put("orderId", orderId);
        map.put("longitude", longitude);
        map.put("latitude", latitude);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do",map,callBack);
    }

    /**订单已到达*/
    public void orderArrive(String token,String orderId,String latitude,String longitude, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "arrive");
        map.put("orderId", orderId);
        map.put("longitude", longitude);
        map.put("latitude", latitude);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do",map,callBack);
    }

    /**订单服务完成*/
    public void orderEnd(String token,String orderId,BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", "target");
        map.put("orderId", orderId);
        httpUtil.get(BASEURL+ "biz/bizOrderDeal.do",map,callBack);
    }

    /**系统收费*/
    public void ruleFee(String token,String orderId,String type, BaseHttpCallBack callBack) {
        map = new HashMap<>();
        map.put("token", token);
        map.put("type", type);
        map.put("orderId", orderId);
        httpUtil.get(BASEURL+ "utils/ruleFee.do",map,callBack);
    }
}