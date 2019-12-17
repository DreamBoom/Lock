package com.lock.bean;

import java.io.Serializable;
import java.util.List;

public class OrderListBean implements Serializable {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : [{"id":20,"gmtCreate":1549518384000,"gmtInit":1549975421000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":1549975505000,"status":1,"channel":2,"effective":1,"gmtPlan":null,"customId":null,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":2,"amount":null,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"秦淮区","address":"大中桥","house":"111","longitude":118.800954,"latitude":32.026346,"distance":null,"customMobile":"18888888888","customRate":null,"cancelType":1,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":"您所在区域目前没有可匹配的锁匠、请联系客服或手动选择！","memo":"11","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单、待锁匠出发","paymentTypeDesc":"线下","autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":false,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1549518384000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"语音客服下单","createTimeDesc":"2019-02-07 13:46:24"},{"id":19,"gmtCreate":1545558268000,"gmtInit":1545558268000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":2,"effective":1,"gmtPlan":null,"customId":null,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":401,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"","longitude":118.793037,"latitude":32.041821,"distance":"856米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":null,"memo":"","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单","paymentTypeDesc":null,"autoMatch":true,"keyCopy":true,"planOrder":false,"customOrder":false,"actionOrder":true,"dateOrder":false,"bizIdDesc":"配门钥匙","changeLock":false,"travelDate":1545558268000,"openLock":false,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"语音客服下单","createTimeDesc":"2018-12-23 17:44:28"},{"id":18,"gmtCreate":1544846010000,"gmtInit":1544846010000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":2,"effective":1,"gmtPlan":null,"customId":null,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":401,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":null,"memo":"","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单","paymentTypeDesc":null,"autoMatch":true,"keyCopy":true,"planOrder":false,"customOrder":false,"actionOrder":true,"dateOrder":false,"bizIdDesc":"配门钥匙","changeLock":false,"travelDate":1544846010000,"openLock":false,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"语音客服下单","createTimeDesc":"2018-12-15 11:53:30"},{"id":16,"gmtCreate":1544686843000,"gmtInit":1545999834000,"gmtStart":1553133554000,"gmtArrive":1556972955000,"gmtTarget":1546247737000,"gmtFinish":1550412834000,"gmtCancel":null,"status":4,"channel":1,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":null,"payOrderId":4,"matchType":1,"paymentType":1,"amount":100000,"fee":3000,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":5,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":"000001/bill1.16.JPG","imgBill2":"000001/bill2.16.JPG","imgBill3":null,"customMemo":"test","errorMemo":null,"memo":null,"feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"待客户审核服务项","paymentTypeDesc":"线上","autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":true,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544686843000,"openLock":true,"installMonitor":false,"feeDesc":"30.00","amountDesc":"1000.00","channelDesc":"客户下单","createTimeDesc":"2018-12-13 15:40:43"},{"id":15,"gmtCreate":1544686772000,"gmtInit":1544686776000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":8,"channel":1,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":null,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":null,"memo":null,"feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已付款、已成功完成","paymentTypeDesc":null,"autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":true,"actionOrder":false,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544686772000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"客户下单","createTimeDesc":"2018-12-13 15:39:32"},{"id":14,"gmtCreate":1544686645000,"gmtInit":1544686647000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":1,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":null,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":null,"memo":null,"feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单、待锁匠出发","paymentTypeDesc":null,"autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":true,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544686645000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"客户下单","createTimeDesc":"2018-12-13 15:37:25"},{"id":13,"gmtCreate":1544686548000,"gmtInit":1544686551000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":1,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":null,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":null,"memo":null,"feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单、待锁匠出发","paymentTypeDesc":null,"autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":true,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544686548000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"客户下单","createTimeDesc":"2018-12-13 15:35:48"},{"id":12,"gmtCreate":1544525314000,"gmtInit":1544930736000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":2,"effective":1,"gmtPlan":null,"customId":null,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":1,"amount":15000,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":1,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":"您所在区域目前没有可匹配的锁匠、请联系客服或手动选择！","memo":"","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单、待锁匠出发","paymentTypeDesc":"线上","autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":false,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544525314000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"150.00","channelDesc":"语音客服下单","createTimeDesc":"2018-12-11 18:48:34"},{"id":11,"gmtCreate":1544524621000,"gmtInit":1546000435000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":1,"channel":2,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":1,"amount":15000,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":1,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":"您所在区域目前没有可匹配的锁匠、请联系客服或手动选择！","memo":"","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"客户已下单、待锁匠出发","paymentTypeDesc":"线上","autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":false,"actionOrder":true,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544524621000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"150.00","channelDesc":"语音客服下单","createTimeDesc":"2018-12-11 18:37:01"},{"id":10,"gmtCreate":1544524526000,"gmtInit":1544948437000,"gmtStart":null,"gmtArrive":null,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":0,"channel":2,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":1,"payOrderId":null,"matchType":1,"paymentType":null,"amount":null,"fee":null,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":1,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":null,"imgBill2":null,"imgBill3":null,"customMemo":null,"errorMemo":"您所在区域目前没有可匹配的锁匠、请联系客服或手动选择！","memo":"","feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":null,"statusDesc":"语音下单匹配失败、订单暂存","paymentTypeDesc":null,"autoMatch":true,"keyCopy":false,"planOrder":false,"customOrder":false,"actionOrder":false,"dateOrder":false,"bizIdDesc":"开门锁","changeLock":false,"travelDate":1544524526000,"openLock":true,"installMonitor":false,"feeDesc":"未填写","amountDesc":"未填写","channelDesc":"语音客服下单","createTimeDesc":"2018-12-11 18:35:26"}]
     * query : {"totalItem":19,"totalPage":2,"pageSize":10,"currentPage":1,"startRow":0,"startTime":null,"endTime":null,"userId":null,"statusList":null,"startTimeDesc":null,"endTimeDesc":null,"lastPage":false}
     */

    private boolean success;
    private String code;
    private String message;
    private QueryBean query;
    private List<ModuleBean> module;

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

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public List<ModuleBean> getModule() {
        return module;
    }

    public void setModule(List<ModuleBean> module) {
        this.module = module;
    }

    public static class QueryBean {
        /**
         * totalItem : 19
         * totalPage : 2
         * pageSize : 10
         * currentPage : 1
         * startRow : 0
         * startTime : null
         * endTime : null
         * userId : null
         * statusList : null
         * startTimeDesc : null
         * endTimeDesc : null
         * lastPage : false
         */

        private int totalItem;
        private int totalPage;
        private int pageSize;
        private int currentPage;
        private int startRow;
        private Object startTime;
        private Object endTime;
        private Object userId;
        private Object statusList;
        private Object startTimeDesc;
        private Object endTimeDesc;
        private boolean lastPage;

        public int getTotalItem() {
            return totalItem;
        }

        public void setTotalItem(int totalItem) {
            this.totalItem = totalItem;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getStatusList() {
            return statusList;
        }

        public void setStatusList(Object statusList) {
            this.statusList = statusList;
        }

        public Object getStartTimeDesc() {
            return startTimeDesc;
        }

        public void setStartTimeDesc(Object startTimeDesc) {
            this.startTimeDesc = startTimeDesc;
        }

        public Object getEndTimeDesc() {
            return endTimeDesc;
        }

        public void setEndTimeDesc(Object endTimeDesc) {
            this.endTimeDesc = endTimeDesc;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }
    }

    public static class ModuleBean implements Serializable{
        /**
         * id : 20
         * gmtCreate : 1549518384000
         * gmtInit : 1549975421000
         * gmtStart : null
         * gmtArrive : null
         * gmtTarget : null
         * gmtFinish : null
         * gmtCancel : 1549975505000
         * status : 1
         * channel : 2
         * effective : 1
         * gmtPlan : null
         * customId : null
         * masterId : 2
         * adminId : 1
         * payOrderId : null
         * matchType : 1
         * paymentType : 2
         * amount : null
         * fee : null
         * bizId : 101
         * provinceCode : 320000
         * cityCode : 320100
         * areaCode : 025
         * district : 秦淮区
         * address : 大中桥
         * house : 111
         * longitude : 118.800954
         * latitude : 32.026346
         * distance : null
         * customMobile : 18888888888
         * customRate : null
         * cancelType : 1
         * cancelMemo : null
         * customDel : 0
         * masterDel : 0
         * imgBill1 : null
         * imgBill2 : null
         * imgBill3 : null
         * customMemo : null
         * errorMemo : 您所在区域目前没有可匹配的锁匠、请联系客服或手动选择！
         * memo : 11
         * feeOrderId : null
         * masterAcctId : null
         * mlng : null
         * mlat : null
         * maddress : null
         * mhouse : null
         * provinceName : null
         * cityName : null
         * items : null
         * statusDesc : 客户已下单、待锁匠出发
         * paymentTypeDesc : 线下
         * autoMatch : true
         * keyCopy : false
         * planOrder : false
         * customOrder : false
         * actionOrder : true
         * dateOrder : false
         * bizIdDesc : 开门锁
         * changeLock : false
         * travelDate : 1549518384000
         * openLock : true
         * installMonitor : false
         * feeDesc : 未填写
         * amountDesc : 未填写
         * channelDesc : 语音客服下单
         * createTimeDesc : 2019-02-07 13:46:24
         */

        private int id;
        private long gmtCreate;
        private long gmtInit;
        private long gmtStart;
        private long gmtArrive;
        private long gmtTarget;
        private long gmtFinish;
        private long gmtCancel;
        private int status;
        private int channel;
        private int effective;
        private Object gmtPlan;
        private Object customId;
        private int masterId;
        private int adminId;
        private Object payOrderId;
        private int matchType;
        private int paymentType;
        private Object amount;
        private Object fee;
        private int bizId;
        private String provinceCode;
        private String cityCode;
        private String areaCode;
        private String district;
        private String address;
        private String house;
        private double longitude;
        private double latitude;
        private Object distance;
        private String customMobile;
        private Object customRate;
        private int cancelType;
        private Object cancelMemo;
        private int customDel;
        private int masterDel;
        private String imgBill1;
        private String imgBill2;
        private String imgBill3;
        private Object customMemo;
        private String errorMemo;
        private String memo;
        private Object feeOrderId;
        private Object masterAcctId;
        private Object mlng;
        private Object mlat;
        private String maddress;
        private String mhouse;
        private String provinceName;
        private String cityName;
        private Object items;
        private String statusDesc;
        private String paymentTypeDesc;
        private boolean autoMatch;
        private boolean keyCopy;
        private boolean planOrder;
        private boolean customOrder;
        private boolean actionOrder;
        private boolean dateOrder;
        private String bizIdDesc;
        private boolean changeLock;
        private long travelDate;
        private boolean openLock;
        private boolean installMonitor;
        private String feeDesc;
        private String amountDesc;
        private String channelDesc;
        private String createTimeDesc;

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

        public long getGmtInit() {
            return gmtInit;
        }

        public void setGmtInit(long gmtInit) {
            this.gmtInit = gmtInit;
        }

        public long getGmtStart() {
            return gmtStart;
        }

        public void setGmtStart(long gmtStart) {
            this.gmtStart = gmtStart;
        }

        public long getGmtArrive() {
            return gmtArrive;
        }

        public void setGmtArrive(long gmtArrive) {
            this.gmtArrive = gmtArrive;
        }

        public long getGmtTarget() {
            return gmtTarget;
        }

        public void setGmtTarget(long gmtTarget) {
            this.gmtTarget = gmtTarget;
        }

        public long getGmtFinish() {
            return gmtFinish;
        }

        public void setGmtFinish(long gmtFinish) {
            this.gmtFinish = gmtFinish;
        }

        public long getGmtCancel() {
            return gmtCancel;
        }

        public void setGmtCancel(long gmtCancel) {
            this.gmtCancel = gmtCancel;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public int getEffective() {
            return effective;
        }

        public void setEffective(int effective) {
            this.effective = effective;
        }

        public Object getGmtPlan() {
            return gmtPlan;
        }

        public void setGmtPlan(Object gmtPlan) {
            this.gmtPlan = gmtPlan;
        }

        public Object getCustomId() {
            return customId;
        }

        public void setCustomId(Object customId) {
            this.customId = customId;
        }

        public int getMasterId() {
            return masterId;
        }

        public void setMasterId(int masterId) {
            this.masterId = masterId;
        }

        public int getAdminId() {
            return adminId;
        }

        public void setAdminId(int adminId) {
            this.adminId = adminId;
        }

        public Object getPayOrderId() {
            return payOrderId;
        }

        public void setPayOrderId(Object payOrderId) {
            this.payOrderId = payOrderId;
        }

        public int getMatchType() {
            return matchType;
        }

        public void setMatchType(int matchType) {
            this.matchType = matchType;
        }

        public int getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(int paymentType) {
            this.paymentType = paymentType;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getFee() {
            return fee;
        }

        public void setFee(Object fee) {
            this.fee = fee;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
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

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
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

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public String getCustomMobile() {
            return customMobile;
        }

        public void setCustomMobile(String customMobile) {
            this.customMobile = customMobile;
        }

        public Object getCustomRate() {
            return customRate;
        }

        public void setCustomRate(Object customRate) {
            this.customRate = customRate;
        }

        public int getCancelType() {
            return cancelType;
        }

        public void setCancelType(int cancelType) {
            this.cancelType = cancelType;
        }

        public Object getCancelMemo() {
            return cancelMemo;
        }

        public void setCancelMemo(Object cancelMemo) {
            this.cancelMemo = cancelMemo;
        }

        public int getCustomDel() {
            return customDel;
        }

        public void setCustomDel(int customDel) {
            this.customDel = customDel;
        }

        public int getMasterDel() {
            return masterDel;
        }

        public void setMasterDel(int masterDel) {
            this.masterDel = masterDel;
        }

        public Object getCustomMemo() {
            return customMemo;
        }

        public void setCustomMemo(Object customMemo) {
            this.customMemo = customMemo;
        }

        public String getErrorMemo() {
            return errorMemo;
        }

        public void setErrorMemo(String errorMemo) {
            this.errorMemo = errorMemo;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Object getFeeOrderId() {
            return feeOrderId;
        }

        public void setFeeOrderId(Object feeOrderId) {
            this.feeOrderId = feeOrderId;
        }

        public Object getMasterAcctId() {
            return masterAcctId;
        }

        public void setMasterAcctId(Object masterAcctId) {
            this.masterAcctId = masterAcctId;
        }

        public Object getMlng() {
            return mlng;
        }

        public void setMlng(Object mlng) {
            this.mlng = mlng;
        }

        public Object getMlat() {
            return mlat;
        }

        public void setMlat(Object mlat) {
            this.mlat = mlat;
        }

        public Object getItems() {
            return items;
        }

        public void setItems(Object items) {
            this.items = items;
        }

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
        }

        public String getPaymentTypeDesc() {
            return paymentTypeDesc;
        }

        public void setPaymentTypeDesc(String paymentTypeDesc) {
            this.paymentTypeDesc = paymentTypeDesc;
        }

        public boolean isAutoMatch() {
            return autoMatch;
        }

        public void setAutoMatch(boolean autoMatch) {
            this.autoMatch = autoMatch;
        }

        public boolean isKeyCopy() {
            return keyCopy;
        }

        public void setKeyCopy(boolean keyCopy) {
            this.keyCopy = keyCopy;
        }

        public boolean isPlanOrder() {
            return planOrder;
        }

        public void setPlanOrder(boolean planOrder) {
            this.planOrder = planOrder;
        }

        public boolean isCustomOrder() {
            return customOrder;
        }

        public void setCustomOrder(boolean customOrder) {
            this.customOrder = customOrder;
        }

        public boolean isActionOrder() {
            return actionOrder;
        }

        public void setActionOrder(boolean actionOrder) {
            this.actionOrder = actionOrder;
        }

        public boolean isDateOrder() {
            return dateOrder;
        }

        public void setDateOrder(boolean dateOrder) {
            this.dateOrder = dateOrder;
        }

        public String getBizIdDesc() {
            return bizIdDesc;
        }

        public void setBizIdDesc(String bizIdDesc) {
            this.bizIdDesc = bizIdDesc;
        }

        public boolean isChangeLock() {
            return changeLock;
        }

        public void setChangeLock(boolean changeLock) {
            this.changeLock = changeLock;
        }

        public long getTravelDate() {
            return travelDate;
        }

        public void setTravelDate(long travelDate) {
            this.travelDate = travelDate;
        }

        public boolean isOpenLock() {
            return openLock;
        }

        public void setOpenLock(boolean openLock) {
            this.openLock = openLock;
        }

        public boolean isInstallMonitor() {
            return installMonitor;
        }

        public void setInstallMonitor(boolean installMonitor) {
            this.installMonitor = installMonitor;
        }

        public String getFeeDesc() {
            return feeDesc;
        }

        public void setFeeDesc(String feeDesc) {
            this.feeDesc = feeDesc;
        }

        public String getAmountDesc() {
            return amountDesc;
        }

        public void setAmountDesc(String amountDesc) {
            this.amountDesc = amountDesc;
        }

        public String getChannelDesc() {
            return channelDesc;
        }

        public void setChannelDesc(String channelDesc) {
            this.channelDesc = channelDesc;
        }

        public String getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(String createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getImgBill1() {
            return imgBill1;
        }

        public void setImgBill1(String imgBill1) {
            this.imgBill1 = imgBill1;
        }

        public String getImgBill2() {
            return imgBill2;
        }

        public void setImgBill2(String imgBill2) {
            this.imgBill2 = imgBill2;
        }

        public String getImgBill3() {
            return imgBill3;
        }

        public void setImgBill3(String imgBill3) {
            this.imgBill3 = imgBill3;
        }

        public String getMaddress() {
            return maddress;
        }

        public void setMaddress(String maddress) {
            this.maddress = maddress;
        }

        public String getMhouse() {
            return mhouse;
        }

        public void setMhouse(String mhouse) {
            this.mhouse = mhouse;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }
}
