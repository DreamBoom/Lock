package com.lock.bean;

public class MoneyResult {

    /**
     * success : false
     * code : 0028
     * message : 充值操作失败，查询充值结果出错、请稍后再试！
     * module : null
     * query : null
     */

    private boolean success;
    private String code;
    private String message;
    private Object module;
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

    public Object getModule() {
        return module;
    }

    public void setModule(Object module) {
        this.module = module;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }
}
