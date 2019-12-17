package com.lock.bean;

import java.util.List;

public class ServiceBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : {"id":14,"gmtCreate":1544686645000,"gmtInit":1544686647000,"gmtStart":1567603790000,"gmtArrive":1567603796000,"gmtTarget":null,"gmtFinish":null,"gmtCancel":null,"status":4,"channel":1,"effective":1,"gmtPlan":null,"customId":5,"masterId":2,"adminId":null,"payOrderId":null,"matchType":1,"paymentType":1,"amount":15000,"fee":3000,"bizId":101,"provinceCode":"320000","cityCode":"320100","areaCode":"025","district":"玄武区","address":"大行宫","house":"1002","longitude":118.793037,"latitude":32.041821,"distance":"1000米","customMobile":"18888888888","customRate":null,"cancelType":0,"cancelMemo":null,"customDel":0,"masterDel":0,"imgBill1":"000001/bill1.14.jpg","imgBill2":"000001/bill2.14.jpg","imgBill3":"000001/bill3.14.jpg","customMemo":null,"errorMemo":null,"memo":null,"feeOrderId":null,"masterAcctId":null,"mlng":null,"mlat":null,"maddress":null,"mhouse":null,"provinceName":null,"cityName":null,"items":[{"cid":13,"bizOrderId":14,"feeType":1,"feeId":1,"number":1,"itemPrice":5000,"totalAmount":5000,"feeTypeDesc":"上门费","itemPriceDesc":"50.00","totalAmountDesc":"50.00"},{"cid":14,"bizOrderId":14,"feeType":2,"feeId":2,"number":1,"itemPrice":10000,"totalAmount":10000,"feeTypeDesc":"开锁费","itemPriceDesc":"100.00","totalAmountDesc":"100.00"},{"cid":15,"bizOrderId":14,"feeType":3,"feeId":3,"number":1,"itemPrice":1000,"totalAmount":1000,"feeTypeDesc":"安装费","itemPriceDesc":"10.00","totalAmountDesc":"10.00"}],"statusDesc":"待客户审核服务项","travelDate":1544686645000,"openLock":true,"changeLock":false,"installMonitor":false,"bizIdDesc":"开门锁","planOrder":false,"keyCopy":false,"customOrder":true,"autoMatch":true,"actionOrder":true,"dateOrder":false,"createTimeDesc":"2018-12-13 15:37:25","channelDesc":"客户下单","paymentTypeDesc":"线上","amountDesc":"150.00","feeDesc":"30.00"}
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
         * id : 14
         * gmtCreate : 1544686645000
         * gmtInit : 1544686647000
         * gmtStart : 1567603790000
         * gmtArrive : 1567603796000
         * gmtTarget : null
         * gmtFinish : null
         * gmtCancel : null
         * status : 4
         * channel : 1
         * effective : 1
         * gmtPlan : null
         * customId : 5
         * masterId : 2
         * adminId : null
         * payOrderId : null
         * matchType : 1
         * paymentType : 1
         * amount : 15000
         * fee : 3000
         * bizId : 101
         * provinceCode : 320000
         * cityCode : 320100
         * areaCode : 025
         * district : 玄武区
         * address : 大行宫
         * house : 1002
         * longitude : 118.793037
         * latitude : 32.041821
         * distance : 1000米
         * customMobile : 18888888888
         * customRate : null
         * cancelType : 0
         * cancelMemo : null
         * customDel : 0
         * masterDel : 0
         * imgBill1 : 000001/bill1.14.jpg
         * imgBill2 : 000001/bill2.14.jpg
         * imgBill3 : 000001/bill3.14.jpg
         * customMemo : null
         * errorMemo : null
         * memo : null
         * feeOrderId : null
         * masterAcctId : null
         * mlng : null
         * mlat : null
         * maddress : null
         * mhouse : null
         * provinceName : null
         * cityName : null
         * items : [{"cid":13,"bizOrderId":14,"feeType":1,"feeId":1,"number":1,"itemPrice":5000,"totalAmount":5000,"feeTypeDesc":"上门费","itemPriceDesc":"50.00","totalAmountDesc":"50.00"},{"cid":14,"bizOrderId":14,"feeType":2,"feeId":2,"number":1,"itemPrice":10000,"totalAmount":10000,"feeTypeDesc":"开锁费","itemPriceDesc":"100.00","totalAmountDesc":"100.00"},{"cid":15,"bizOrderId":14,"feeType":3,"feeId":3,"number":1,"itemPrice":1000,"totalAmount":1000,"feeTypeDesc":"安装费","itemPriceDesc":"10.00","totalAmountDesc":"10.00"}]
         * statusDesc : 待客户审核服务项
         * travelDate : 1544686645000
         * openLock : true
         * changeLock : false
         * installMonitor : false
         * bizIdDesc : 开门锁
         * planOrder : false
         * keyCopy : false
         * customOrder : true
         * autoMatch : true
         * actionOrder : true
         * dateOrder : false
         * createTimeDesc : 2018-12-13 15:37:25
         * channelDesc : 客户下单
         * paymentTypeDesc : 线上
         * amountDesc : 150.00
         * feeDesc : 30.00
         */

        private int id;
        private long gmtCreate;
        private long gmtInit;
        private long gmtStart;
        private long gmtArrive;
        private Object gmtTarget;
        private Object gmtFinish;
        private Object gmtCancel;
        private int status;
        private int channel;
        private int effective;
        private Object gmtPlan;
        private int customId;
        private int masterId;
        private Object adminId;
        private Object payOrderId;
        private int matchType;
        private int paymentType;
        private int amount;
        private int fee;
        private int bizId;
        private String provinceCode;
        private String cityCode;
        private String areaCode;
        private String district;
        private String address;
        private String house;
        private double longitude;
        private double latitude;
        private String distance;
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
        private Object errorMemo;
        private Object memo;
        private Object feeOrderId;
        private Object masterAcctId;
        private Object mlng;
        private Object mlat;
        private Object maddress;
        private Object mhouse;
        private Object provinceName;
        private Object cityName;
        private String statusDesc;
        private long travelDate;
        private boolean openLock;
        private boolean changeLock;
        private boolean installMonitor;
        private String bizIdDesc;
        private boolean planOrder;
        private boolean keyCopy;
        private boolean customOrder;
        private boolean autoMatch;
        private boolean actionOrder;
        private boolean dateOrder;
        private String createTimeDesc;
        private String channelDesc;
        private String paymentTypeDesc;
        private String amountDesc;
        private String feeDesc;
        private List<ItemsBean> items;

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

        public Object getGmtTarget() {
            return gmtTarget;
        }

        public void setGmtTarget(Object gmtTarget) {
            this.gmtTarget = gmtTarget;
        }

        public Object getGmtFinish() {
            return gmtFinish;
        }

        public void setGmtFinish(Object gmtFinish) {
            this.gmtFinish = gmtFinish;
        }

        public Object getGmtCancel() {
            return gmtCancel;
        }

        public void setGmtCancel(Object gmtCancel) {
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

        public int getCustomId() {
            return customId;
        }

        public void setCustomId(int customId) {
            this.customId = customId;
        }

        public int getMasterId() {
            return masterId;
        }

        public void setMasterId(int masterId) {
            this.masterId = masterId;
        }

        public Object getAdminId() {
            return adminId;
        }

        public void setAdminId(Object adminId) {
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

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
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

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
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

        public Object getCustomMemo() {
            return customMemo;
        }

        public void setCustomMemo(Object customMemo) {
            this.customMemo = customMemo;
        }

        public Object getErrorMemo() {
            return errorMemo;
        }

        public void setErrorMemo(Object errorMemo) {
            this.errorMemo = errorMemo;
        }

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
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

        public Object getMaddress() {
            return maddress;
        }

        public void setMaddress(Object maddress) {
            this.maddress = maddress;
        }

        public Object getMhouse() {
            return mhouse;
        }

        public void setMhouse(Object mhouse) {
            this.mhouse = mhouse;
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

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
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

        public boolean isChangeLock() {
            return changeLock;
        }

        public void setChangeLock(boolean changeLock) {
            this.changeLock = changeLock;
        }

        public boolean isInstallMonitor() {
            return installMonitor;
        }

        public void setInstallMonitor(boolean installMonitor) {
            this.installMonitor = installMonitor;
        }

        public String getBizIdDesc() {
            return bizIdDesc;
        }

        public void setBizIdDesc(String bizIdDesc) {
            this.bizIdDesc = bizIdDesc;
        }

        public boolean isPlanOrder() {
            return planOrder;
        }

        public void setPlanOrder(boolean planOrder) {
            this.planOrder = planOrder;
        }

        public boolean isKeyCopy() {
            return keyCopy;
        }

        public void setKeyCopy(boolean keyCopy) {
            this.keyCopy = keyCopy;
        }

        public boolean isCustomOrder() {
            return customOrder;
        }

        public void setCustomOrder(boolean customOrder) {
            this.customOrder = customOrder;
        }

        public boolean isAutoMatch() {
            return autoMatch;
        }

        public void setAutoMatch(boolean autoMatch) {
            this.autoMatch = autoMatch;
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

        public String getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(String createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getChannelDesc() {
            return channelDesc;
        }

        public void setChannelDesc(String channelDesc) {
            this.channelDesc = channelDesc;
        }

        public String getPaymentTypeDesc() {
            return paymentTypeDesc;
        }

        public void setPaymentTypeDesc(String paymentTypeDesc) {
            this.paymentTypeDesc = paymentTypeDesc;
        }

        public String getAmountDesc() {
            return amountDesc;
        }

        public void setAmountDesc(String amountDesc) {
            this.amountDesc = amountDesc;
        }

        public String getFeeDesc() {
            return feeDesc;
        }

        public void setFeeDesc(String feeDesc) {
            this.feeDesc = feeDesc;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * cid : 13
             * bizOrderId : 14
             * feeType : 1
             * feeId : 1
             * number : 1
             * itemPrice : 5000
             * totalAmount : 5000
             * feeTypeDesc : 上门费
             * itemPriceDesc : 50.00
             * totalAmountDesc : 50.00
             */

            private int cid;
            private int bizOrderId;
            private int feeType;
            private int feeId;
            private int number;
            private int itemPrice;
            private int totalAmount;
            private String feeTypeDesc;
            private String itemPriceDesc;
            private String totalAmountDesc;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getBizOrderId() {
                return bizOrderId;
            }

            public void setBizOrderId(int bizOrderId) {
                this.bizOrderId = bizOrderId;
            }

            public int getFeeType() {
                return feeType;
            }

            public void setFeeType(int feeType) {
                this.feeType = feeType;
            }

            public int getFeeId() {
                return feeId;
            }

            public void setFeeId(int feeId) {
                this.feeId = feeId;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getItemPrice() {
                return itemPrice;
            }

            public void setItemPrice(int itemPrice) {
                this.itemPrice = itemPrice;
            }

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getFeeTypeDesc() {
                return feeTypeDesc;
            }

            public void setFeeTypeDesc(String feeTypeDesc) {
                this.feeTypeDesc = feeTypeDesc;
            }

            public String getItemPriceDesc() {
                return itemPriceDesc;
            }

            public void setItemPriceDesc(String itemPriceDesc) {
                this.itemPriceDesc = itemPriceDesc;
            }

            public String getTotalAmountDesc() {
                return totalAmountDesc;
            }

            public void setTotalAmountDesc(String totalAmountDesc) {
                this.totalAmountDesc = totalAmountDesc;
            }
        }
    }
}
