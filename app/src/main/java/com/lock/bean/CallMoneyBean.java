package com.lock.bean;

public class CallMoneyBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : 已发送付款提醒给用户
     * query : null
     */

    private boolean success;
    private String code;
    private String message;
    private String module;
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }
}
