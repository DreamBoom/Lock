package com.lock.bean;

public class MoneyInBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : {"id":25,"gmtCreate":1565318344456,"gmtModify":1565318344457,"userId":2,"acctId":1,"amount":10000,"status":2,"account":1,"payType":1,"operId":null,"verifyOperId":null,"acctLogId":null,"paymentLogId":67,"memo":null,"userName":null,"operName":null,"verifyOperName":null,"chargeData":"alipay_sdk=alipay-sdk-java-3.1.0&app_id=2014072300007148&biz_content=%7B%22out_trade_no%22%3A%2267%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%222%E5%85%85%E5%80%BC%22%2C%22total_amount%22%3A%22100.00%22%7D&charset=utf-8&format=JSON&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fgw.kaihs.com%2Fnotify%2FalipayCharge%2F25.do&sign=1TVW5VMMaivJS%2BRyRDSG8QvM4dytrEirf3b9epi52S6S%2Fz4y432bZzbwbJQTEN7G6jm0yiXi0Mg0imO0Tc5BHOAN2V1F9wFL3MfrKqiPOlRAvTa2UpWiS9k56u6ACA%2FfjspQg0g8jV4x%2BG5cFPHpwtFALAB4Lv4WHdNjxSp9uPE%3D&sign_type=RSA2&timestamp=2019-08-09+10%3A39%3A04&version=1.0","statusDesc":"充值中、等待确认结果","createTimeDesc":"2019-08-09 10:39:04","amountDesc":"100.00","accountDesc":"创建、不用处理","payTypeDesc":"支付宝"}
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
         * id : 25
         * gmtCreate : 1565318344456
         * gmtModify : 1565318344457
         * userId : 2
         * acctId : 1
         * amount : 10000
         * status : 2
         * account : 1
         * payType : 1
         * operId : null
         * verifyOperId : null
         * acctLogId : null
         * paymentLogId : 67
         * memo : null
         * userName : null
         * operName : null
         * verifyOperName : null
         * chargeData : alipay_sdk=alipay-sdk-java-3.1.0&app_id=2014072300007148&biz_content=%7B%22out_trade_no%22%3A%2267%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%222%E5%85%85%E5%80%BC%22%2C%22total_amount%22%3A%22100.00%22%7D&charset=utf-8&format=JSON&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fgw.kaihs.com%2Fnotify%2FalipayCharge%2F25.do&sign=1TVW5VMMaivJS%2BRyRDSG8QvM4dytrEirf3b9epi52S6S%2Fz4y432bZzbwbJQTEN7G6jm0yiXi0Mg0imO0Tc5BHOAN2V1F9wFL3MfrKqiPOlRAvTa2UpWiS9k56u6ACA%2FfjspQg0g8jV4x%2BG5cFPHpwtFALAB4Lv4WHdNjxSp9uPE%3D&sign_type=RSA2&timestamp=2019-08-09+10%3A39%3A04&version=1.0
         * statusDesc : 充值中、等待确认结果
         * createTimeDesc : 2019-08-09 10:39:04
         * amountDesc : 100.00
         * accountDesc : 创建、不用处理
         * payTypeDesc : 支付宝
         */

        private int id;
        private long gmtCreate;
        private long gmtModify;
        private int userId;
        private int acctId;
        private int amount;
        private int status;
        private int account;
        private int payType;
        private Object operId;
        private Object verifyOperId;
        private Object acctLogId;
        private int paymentLogId;
        private Object memo;
        private Object userName;
        private Object operName;
        private Object verifyOperName;
        private String chargeData;
        private String statusDesc;
        private String createTimeDesc;
        private String amountDesc;
        private String accountDesc;
        private String payTypeDesc;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getAcctId() {
            return acctId;
        }

        public void setAcctId(int acctId) {
            this.acctId = acctId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getAccount() {
            return account;
        }

        public void setAccount(int account) {
            this.account = account;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public Object getOperId() {
            return operId;
        }

        public void setOperId(Object operId) {
            this.operId = operId;
        }

        public Object getVerifyOperId() {
            return verifyOperId;
        }

        public void setVerifyOperId(Object verifyOperId) {
            this.verifyOperId = verifyOperId;
        }

        public Object getAcctLogId() {
            return acctLogId;
        }

        public void setAcctLogId(Object acctLogId) {
            this.acctLogId = acctLogId;
        }

        public int getPaymentLogId() {
            return paymentLogId;
        }

        public void setPaymentLogId(int paymentLogId) {
            this.paymentLogId = paymentLogId;
        }

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
            this.memo = memo;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
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

        public String getChargeData() {
            return chargeData;
        }

        public void setChargeData(String chargeData) {
            this.chargeData = chargeData;
        }

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
        }

        public String getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(String createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getAmountDesc() {
            return amountDesc;
        }

        public void setAmountDesc(String amountDesc) {
            this.amountDesc = amountDesc;
        }

        public String getAccountDesc() {
            return accountDesc;
        }

        public void setAccountDesc(String accountDesc) {
            this.accountDesc = accountDesc;
        }

        public String getPayTypeDesc() {
            return payTypeDesc;
        }

        public void setPayTypeDesc(String payTypeDesc) {
            this.payTypeDesc = payTypeDesc;
        }
    }
}
