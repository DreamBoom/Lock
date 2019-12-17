package com.lock.bean;

import java.util.List;

public class BillBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : [{"id":39,"gmtCreate":1567602140000,"userId":2,"acctId":1,"billId":6,"billType":5,"bizOrderId":20,"tradeType":2,"amtIn":null,"amtOut":3000,"amtBalance":1847901,"memo":"交易费成功扣款","userName":null,"createTimeDesc":"2019-09-04 21:02:20","amtInDesc":"","amtOutDesc":"30.00","amtBalanceDesc":"18479.01","tradeTypeDesc":"出账","billTypeDesc":"扣款单"},{"id":38,"gmtCreate":1550749376000,"userId":2,"acctId":1,"billId":32,"billType":4,"bizOrderId":null,"tradeType":1,"amtIn":10000,"amtOut":null,"amtBalance":1850901,"memo":"转账失败退款","userName":null,"createTimeDesc":"2019-02-21 19:42:56","amtInDesc":"100.00","amtOutDesc":"","amtBalanceDesc":"18509.01","tradeTypeDesc":"入账","billTypeDesc":"提款单"},{"id":37,"gmtCreate":1550749348000,"userId":2,"acctId":1,"billId":32,"billType":4,"bizOrderId":null,"tradeType":2,"amtIn":null,"amtOut":10000,"amtBalance":1840901,"memo":"提款成功扣款","userName":null,"createTimeDesc":"2019-02-21 19:42:28","amtInDesc":"","amtOutDesc":"100.00","amtBalanceDesc":"18409.01","tradeTypeDesc":"出账","billTypeDesc":"提款单"},{"id":36,"gmtCreate":1550748820000,"userId":2,"acctId":1,"billId":31,"billType":4,"bizOrderId":null,"tradeType":1,"amtIn":10000,"amtOut":null,"amtBalance":1850901,"memo":"转账失败退款","userName":null,"createTimeDesc":"2019-02-21 19:33:40","amtInDesc":"100.00","amtOutDesc":"","amtBalanceDesc":"18509.01","tradeTypeDesc":"入账","billTypeDesc":"提款单"},{"id":35,"gmtCreate":1550748585000,"userId":2,"acctId":1,"billId":31,"billType":4,"bizOrderId":null,"tradeType":2,"amtIn":null,"amtOut":10000,"amtBalance":1840901,"memo":"提款成功扣款","userName":null,"createTimeDesc":"2019-02-21 19:29:45","amtInDesc":"","amtOutDesc":"100.00","amtBalanceDesc":"18409.01","tradeTypeDesc":"出账","billTypeDesc":"提款单"},{"id":34,"gmtCreate":1550748561000,"userId":2,"acctId":1,"billId":30,"billType":4,"bizOrderId":null,"tradeType":1,"amtIn":10000,"amtOut":null,"amtBalance":1850901,"memo":"转账失败退款","userName":null,"createTimeDesc":"2019-02-21 19:29:21","amtInDesc":"100.00","amtOutDesc":"","amtBalanceDesc":"18509.01","tradeTypeDesc":"入账","billTypeDesc":"提款单"},{"id":33,"gmtCreate":1550748528000,"userId":2,"acctId":1,"billId":30,"billType":4,"bizOrderId":null,"tradeType":2,"amtIn":null,"amtOut":10000,"amtBalance":1840901,"memo":"提款成功扣款","userName":null,"createTimeDesc":"2019-02-21 19:28:48","amtInDesc":"","amtOutDesc":"100.00","amtBalanceDesc":"18409.01","tradeTypeDesc":"出账","billTypeDesc":"提款单"},{"id":32,"gmtCreate":1550748514000,"userId":2,"acctId":1,"billId":29,"billType":4,"bizOrderId":null,"tradeType":1,"amtIn":10000,"amtOut":null,"amtBalance":1850901,"memo":"转账失败退款","userName":null,"createTimeDesc":"2019-02-21 19:28:34","amtInDesc":"100.00","amtOutDesc":"","amtBalanceDesc":"18509.01","tradeTypeDesc":"入账","billTypeDesc":"提款单"},{"id":31,"gmtCreate":1550748513000,"userId":2,"acctId":1,"billId":29,"billType":4,"bizOrderId":null,"tradeType":2,"amtIn":null,"amtOut":10000,"amtBalance":1840901,"memo":"提款成功扣款","userName":null,"createTimeDesc":"2019-02-21 19:28:33","amtInDesc":"","amtOutDesc":"100.00","amtBalanceDesc":"18409.01","tradeTypeDesc":"出账","billTypeDesc":"提款单"},{"id":30,"gmtCreate":1550748434000,"userId":2,"acctId":1,"billId":28,"billType":4,"bizOrderId":null,"tradeType":1,"amtIn":10000,"amtOut":null,"amtBalance":1850901,"memo":"转账失败退款","userName":null,"createTimeDesc":"2019-02-21 19:27:14","amtInDesc":"100.00","amtOutDesc":"","amtBalanceDesc":"18509.01","tradeTypeDesc":"入账","billTypeDesc":"提款单"}]
     * query : {"totalItem":38,"totalPage":4,"pageSize":10,"currentPage":1,"startRow":0,"startTime":null,"endTime":null,"userId":null,"statusList":null,"startTimeDesc":null,"endTimeDesc":null,"lastPage":false}
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
         * totalItem : 38
         * totalPage : 4
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

    public static class ModuleBean {
        /**
         * id : 39
         * gmtCreate : 1567602140000
         * userId : 2
         * acctId : 1
         * billId : 6
         * billType : 5
         * bizOrderId : 20
         * tradeType : 2
         * amtIn : null
         * amtOut : 3000
         * amtBalance : 1847901
         * memo : 交易费成功扣款
         * userName : null
         * createTimeDesc : 2019-09-04 21:02:20
         * amtInDesc :
         * amtOutDesc : 30.00
         * amtBalanceDesc : 18479.01
         * tradeTypeDesc : 出账
         * billTypeDesc : 扣款单
         */

        private int id;
        private long gmtCreate;
        private int userId;
        private int acctId;
        private int billId;
        private int billType;
        private int bizOrderId;
        private int tradeType;
        private Object amtIn;
        private int amtOut;
        private int amtBalance;
        private String memo;
        private Object userName;
        private String createTimeDesc;
        private String amtInDesc;
        private String amtOutDesc;
        private String amtBalanceDesc;
        private String tradeTypeDesc;
        private String billTypeDesc;

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

        public int getBillId() {
            return billId;
        }

        public void setBillId(int billId) {
            this.billId = billId;
        }

        public int getBillType() {
            return billType;
        }

        public void setBillType(int billType) {
            this.billType = billType;
        }

        public int getBizOrderId() {
            return bizOrderId;
        }

        public void setBizOrderId(int bizOrderId) {
            this.bizOrderId = bizOrderId;
        }

        public int getTradeType() {
            return tradeType;
        }

        public void setTradeType(int tradeType) {
            this.tradeType = tradeType;
        }

        public Object getAmtIn() {
            return amtIn;
        }

        public void setAmtIn(Object amtIn) {
            this.amtIn = amtIn;
        }

        public int getAmtOut() {
            return amtOut;
        }

        public void setAmtOut(int amtOut) {
            this.amtOut = amtOut;
        }

        public int getAmtBalance() {
            return amtBalance;
        }

        public void setAmtBalance(int amtBalance) {
            this.amtBalance = amtBalance;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
        }

        public String getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(String createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getAmtInDesc() {
            return amtInDesc;
        }

        public void setAmtInDesc(String amtInDesc) {
            this.amtInDesc = amtInDesc;
        }

        public String getAmtOutDesc() {
            return amtOutDesc;
        }

        public void setAmtOutDesc(String amtOutDesc) {
            this.amtOutDesc = amtOutDesc;
        }

        public String getAmtBalanceDesc() {
            return amtBalanceDesc;
        }

        public void setAmtBalanceDesc(String amtBalanceDesc) {
            this.amtBalanceDesc = amtBalanceDesc;
        }

        public String getTradeTypeDesc() {
            return tradeTypeDesc;
        }

        public void setTradeTypeDesc(String tradeTypeDesc) {
            this.tradeTypeDesc = tradeTypeDesc;
        }

        public String getBillTypeDesc() {
            return billTypeDesc;
        }

        public void setBillTypeDesc(String billTypeDesc) {
            this.billTypeDesc = billTypeDesc;
        }
    }
}
