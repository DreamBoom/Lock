package com.lock.bean;

import java.util.List;

public class AccountBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : [{"id":7,"gmtCreate":1561690173000,"userId":53,"acctId":16,"payType":1,"account":"13462439645","realName":"急急急","bankId":null,"payTypeDesc":"支付宝"}]
     * query : null
     */

    private boolean success;
    private String code;
    private String message;
    private Object query;
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

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }

    public List<ModuleBean> getModule() {
        return module;
    }

    public void setModule(List<ModuleBean> module) {
        this.module = module;
    }

    public static class ModuleBean {
        /**
         * id : 7
         * gmtCreate : 1561690173000
         * userId : 53
         * acctId : 16
         * payType : 1
         * account : 13462439645
         * realName : 急急急
         * bankId : null
         * payTypeDesc : 支付宝
         */

        private int id;
        private long gmtCreate;
        private int userId;
        private int acctId;
        private int payType;
        private String account;
        private String realName;
        private String bankId;
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

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getBankId() {
            return bankId;
        }

        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        public String getPayTypeDesc() {
            return payTypeDesc;
        }

        public void setPayTypeDesc(String payTypeDesc) {
            this.payTypeDesc = payTypeDesc;
        }
    }
}
