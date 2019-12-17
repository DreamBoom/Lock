package com.lock.bean;

public class ExitBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : null
     * query : null
     */
    private boolean success;
    private String code;
    private String message;
    private boolean module;
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

    public boolean getModule() {
        return module;
    }

    public void setModule(boolean module) {
        this.module = module;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }
}
