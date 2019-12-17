package com.lock.bean;

public class MasterDealBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : {"id":2,"gmtCreate":1542629026000,"gmtModify":1550141456000,"mobile":"18012975720","pwd":"672a9b27061b910447adf19e2c570798","type":2,"status":1,"nickname":"锁匠01","sex":0,"acctId":1,"acctPwd":"672a9b27061b910447adf19e2c570798","headImgUrl":null,"weixinUnionid":null,"tokenId":"2f441e5f7f12398497249bc96c944092","tokenKey":"f7f2aef847b8b1096ee5a06322b416e013645832356398d5470013835699629d","lastLoginWay":3,"lastWeixinOpenid":null,"lastLoginIp":"42.234.57.9","lastLoginTime":1572940870000,"provinceCode":"320000","cityCode":"320100","memo":null,"imei":null,"openid":null,"provinceName":null,"cityName":null,"mid":1,"mstatus":2,"channel":null,"level":1,"district":"秦淮区","address":"大行宫地铁站","house":"111","longitude":118.786937,"latitude":32.036121,"realName":"锁匠01","areaCode":"025","orderTimes":0,"orderBalance":0,"rateSum":0,"idCardNo":"111111111111111111","imgIdFront":"000001/idfront.2.JPG","imgIdBack":"000001/idback.2.JPG","imgNoCrime":"000001/nocrime.2.JPG","startService":1,"operId":1,"verifyOperId":1,"mmemo":"资金帐户操作失败，账户余额低于押金限额！","operName":null,"verifyOperName":null,"distance":null,"statusDesc":"正常","custom":false,"master":true,"admin":false,"mstatusDesc":"审核通过","sexDesc":"未知","createTimeDesc":"2018-11-19 20:03:46","loginTimeDesc":"2019-11-05 16:01:10","loginWayDesc":"APP","levelDesc":"金牌","startServiceDesc":"开始接单","orderBalanceDesc":"0.00"}
     * query : null
     */

    private boolean success;
    private String code;
    private String message;
    private ModuleBean module;
    private Object query;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModuleBean getModule() {
        return module;
    }

    public void setModule(ModuleBean module) {
        this.module = module;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }

    public static class ModuleBean {
        /**
         * id : 2
         * gmtCreate : 1542629026000
         * gmtModify : 1550141456000
         * mobile : 18012975720
         * pwd : 672a9b27061b910447adf19e2c570798
         * type : 2
         * status : 1
         * nickname : 锁匠01
         * sex : 0
         * acctId : 1
         * acctPwd : 672a9b27061b910447adf19e2c570798
         * headImgUrl : null
         * weixinUnionid : null
         * tokenId : 2f441e5f7f12398497249bc96c944092
         * tokenKey : f7f2aef847b8b1096ee5a06322b416e013645832356398d5470013835699629d
         * lastLoginWay : 3
         * lastWeixinOpenid : null
         * lastLoginIp : 42.234.57.9
         * lastLoginTime : 1572940870000
         * provinceCode : 320000
         * cityCode : 320100
         * memo : null
         * imei : null
         * openid : null
         * provinceName : null
         * cityName : null
         * mid : 1
         * mstatus : 2
         * channel : null
         * level : 1
         * district : 秦淮区
         * address : 大行宫地铁站
         * house : 111
         * longitude : 118.786937
         * latitude : 32.036121
         * realName : 锁匠01
         * areaCode : 025
         * orderTimes : 0
         * orderBalance : 0
         * rateSum : 0
         * idCardNo : 111111111111111111
         * imgIdFront : 000001/idfront.2.JPG
         * imgIdBack : 000001/idback.2.JPG
         * imgNoCrime : 000001/nocrime.2.JPG
         * startService : 1
         * operId : 1
         * verifyOperId : 1
         * mmemo : 资金帐户操作失败，账户余额低于押金限额！
         * operName : null
         * verifyOperName : null
         * distance : null
         * statusDesc : 正常
         * custom : false
         * master : true
         * admin : false
         * mstatusDesc : 审核通过
         * sexDesc : 未知
         * createTimeDesc : 2018-11-19 20:03:46
         * loginTimeDesc : 2019-11-05 16:01:10
         * loginWayDesc : APP
         * levelDesc : 金牌
         * startServiceDesc : 开始接单
         * orderBalanceDesc : 0.00
         */

        private int id;
        private long gmtCreate;
        private long gmtModify;
        private String mobile;
        private String pwd;
        private int type;
        private int status;
        private String nickname;
        private int sex;
        private int acctId;
        private String acctPwd;
        private Object headImgUrl;
        private Object weixinUnionid;
        private String tokenId;
        private String tokenKey;
        private int lastLoginWay;
        private Object lastWeixinOpenid;
        private String lastLoginIp;
        private long lastLoginTime;
        private String provinceCode;
        private String cityCode;
        private Object memo;
        private Object imei;
        private Object openid;
        private Object provinceName;
        private Object cityName;
        private int mid;
        private int mstatus;
        private Object channel;
        private int level;
        private String district;
        private String address;
        private String house;
        private double longitude;
        private double latitude;
        private String realName;
        private String areaCode;
        private int orderTimes;
        private int orderBalance;
        private int rateSum;
        private String idCardNo;
        private String imgIdFront;
        private String imgIdBack;
        private String imgNoCrime;
        private int startService;
        private int operId;
        private int verifyOperId;
        private String mmemo;
        private Object operName;
        private Object verifyOperName;
        private Object distance;
        private String statusDesc;
        private boolean custom;
        private boolean master;
        private boolean admin;
        private String mstatusDesc;
        private String sexDesc;
        private String createTimeDesc;
        private String loginTimeDesc;
        private String loginWayDesc;
        private String levelDesc;
        private String startServiceDesc;
        private String orderBalanceDesc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(long gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public long getGmtModify() {
            return gmtModify;
        }

        public void setGmtModify(long gmtModify) {
            this.gmtModify = gmtModify;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getAcctId() {
            return acctId;
        }

        public void setAcctId(int acctId) {
            this.acctId = acctId;
        }

        public String getAcctPwd() {
            return acctPwd;
        }

        public void setAcctPwd(String acctPwd) {
            this.acctPwd = acctPwd;
        }

        public Object getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(Object headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public Object getWeixinUnionid() {
            return weixinUnionid;
        }

        public void setWeixinUnionid(Object weixinUnionid) {
            this.weixinUnionid = weixinUnionid;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public String getTokenKey() {
            return tokenKey;
        }

        public void setTokenKey(String tokenKey) {
            this.tokenKey = tokenKey;
        }

        public int getLastLoginWay() {
            return lastLoginWay;
        }

        public void setLastLoginWay(int lastLoginWay) {
            this.lastLoginWay = lastLoginWay;
        }

        public Object getLastWeixinOpenid() {
            return lastWeixinOpenid;
        }

        public void setLastWeixinOpenid(Object lastWeixinOpenid) {
            this.lastWeixinOpenid = lastWeixinOpenid;
        }

        public String getLastLoginIp() {
            return lastLoginIp;
        }

        public void setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
            this.memo = memo;
        }

        public Object getImei() {
            return imei;
        }

        public void setImei(Object imei) {
            this.imei = imei;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public Object getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(Object provinceName) {
            this.provinceName = provinceName;
        }

        public Object getCityName() {
            return cityName;
        }

        public void setCityName(Object cityName) {
            this.cityName = cityName;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getMstatus() {
            return mstatus;
        }

        public void setMstatus(int mstatus) {
            this.mstatus = mstatus;
        }

        public Object getChannel() {
            return channel;
        }

        public void setChannel(Object channel) {
            this.channel = channel;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public int getOrderTimes() {
            return orderTimes;
        }

        public void setOrderTimes(int orderTimes) {
            this.orderTimes = orderTimes;
        }

        public int getOrderBalance() {
            return orderBalance;
        }

        public void setOrderBalance(int orderBalance) {
            this.orderBalance = orderBalance;
        }

        public int getRateSum() {
            return rateSum;
        }

        public void setRateSum(int rateSum) {
            this.rateSum = rateSum;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public String getImgIdFront() {
            return imgIdFront;
        }

        public void setImgIdFront(String imgIdFront) {
            this.imgIdFront = imgIdFront;
        }

        public String getImgIdBack() {
            return imgIdBack;
        }

        public void setImgIdBack(String imgIdBack) {
            this.imgIdBack = imgIdBack;
        }

        public String getImgNoCrime() {
            return imgNoCrime;
        }

        public void setImgNoCrime(String imgNoCrime) {
            this.imgNoCrime = imgNoCrime;
        }

        public int getStartService() {
            return startService;
        }

        public void setStartService(int startService) {
            this.startService = startService;
        }

        public int getOperId() {
            return operId;
        }

        public void setOperId(int operId) {
            this.operId = operId;
        }

        public int getVerifyOperId() {
            return verifyOperId;
        }

        public void setVerifyOperId(int verifyOperId) {
            this.verifyOperId = verifyOperId;
        }

        public String getMmemo() {
            return mmemo;
        }

        public void setMmemo(String mmemo) {
            this.mmemo = mmemo;
        }

        public Object getOperName() {
            return operName;
        }

        public void setOperName(Object operName) {
            this.operName = operName;
        }

        public Object getVerifyOperName() {
            return verifyOperName;
        }

        public void setVerifyOperName(Object verifyOperName) {
            this.verifyOperName = verifyOperName;
        }

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
        }

        public boolean isCustom() {
            return custom;
        }

        public void setCustom(boolean custom) {
            this.custom = custom;
        }

        public boolean isMaster() {
            return master;
        }

        public void setMaster(boolean master) {
            this.master = master;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getMstatusDesc() {
            return mstatusDesc;
        }

        public void setMstatusDesc(String mstatusDesc) {
            this.mstatusDesc = mstatusDesc;
        }

        public String getSexDesc() {
            return sexDesc;
        }

        public void setSexDesc(String sexDesc) {
            this.sexDesc = sexDesc;
        }

        public String getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(String createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getLoginTimeDesc() {
            return loginTimeDesc;
        }

        public void setLoginTimeDesc(String loginTimeDesc) {
            this.loginTimeDesc = loginTimeDesc;
        }

        public String getLoginWayDesc() {
            return loginWayDesc;
        }

        public void setLoginWayDesc(String loginWayDesc) {
            this.loginWayDesc = loginWayDesc;
        }

        public String getLevelDesc() {
            return levelDesc;
        }

        public void setLevelDesc(String levelDesc) {
            this.levelDesc = levelDesc;
        }

        public String getStartServiceDesc() {
            return startServiceDesc;
        }

        public void setStartServiceDesc(String startServiceDesc) {
            this.startServiceDesc = startServiceDesc;
        }

        public String getOrderBalanceDesc() {
            return orderBalanceDesc;
        }

        public void setOrderBalanceDesc(String orderBalanceDesc) {
            this.orderBalanceDesc = orderBalanceDesc;
        }
    }
}
