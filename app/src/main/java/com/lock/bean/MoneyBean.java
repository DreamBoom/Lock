package com.lock.bean;

public class MoneyBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : {"balance":0,"margin":0,"cash":0,"marginDesc":"0.00","cashDesc":"0.00","balanceDesc":"0.00"}
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
         * balance : 0
         * margin : 0
         * cash : 0
         * marginDesc : 0.00
         * cashDesc : 0.00
         * balanceDesc : 0.00
         */

        private int balance;
        private int margin;
        private int cash;
        private String marginDesc;
        private String cashDesc;
        private String balanceDesc;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getMargin() {
            return margin;
        }

        public void setMargin(int margin) {
            this.margin = margin;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public String getMarginDesc() {
            return marginDesc;
        }

        public void setMarginDesc(String marginDesc) {
            this.marginDesc = marginDesc;
        }

        public String getCashDesc() {
            return cashDesc;
        }

        public void setCashDesc(String cashDesc) {
            this.cashDesc = cashDesc;
        }

        public String getBalanceDesc() {
            return balanceDesc;
        }

        public void setBalanceDesc(String balanceDesc) {
            this.balanceDesc = balanceDesc;
        }
    }
}
