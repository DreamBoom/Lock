package com.lock.bean;

import java.util.List;

public class FeeListBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : [{"id":1,"bizId":101,"itemType":1,"itemPrice":5000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"50.00","itemTypeDesc":"普通门锁A级"},{"id":2,"bizId":101,"itemType":2,"itemPrice":10000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"100.00","itemTypeDesc":"普通门锁B级"},{"id":3,"bizId":101,"itemType":3,"itemPrice":15000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"150.00","itemTypeDesc":"普通门锁C级"},{"id":4,"bizId":101,"itemType":4,"itemPrice":10000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"100.00","itemTypeDesc":"智能门锁A级"},{"id":5,"bizId":101,"itemType":5,"itemPrice":15000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"150.00","itemTypeDesc":"智能门锁B级"},{"id":6,"bizId":101,"itemType":6,"itemPrice":20000,"operId":null,"operName":null,"bizIdDesc":"开门锁","itemPriceDesc":"200.00","itemTypeDesc":"智能门锁C级"}]
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
         * id : 1
         * bizId : 101
         * itemType : 1
         * itemPrice : 5000
         * operId : null
         * operName : null
         * bizIdDesc : 开门锁
         * itemPriceDesc : 50.00
         * itemTypeDesc : 普通门锁A级
         */

        private int id;
        private int bizId;
        private int itemType;
        private int itemPrice;
        private Object operId;
        private Object operName;
        private String bizIdDesc;
        private String itemPriceDesc;
        private String itemTypeDesc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBizId() {
            return bizId;
        }

        public void setBizId(int bizId) {
            this.bizId = bizId;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public int getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(int itemPrice) {
            this.itemPrice = itemPrice;
        }

        public Object getOperId() {
            return operId;
        }

        public void setOperId(Object operId) {
            this.operId = operId;
        }

        public Object getOperName() {
            return operName;
        }

        public void setOperName(Object operName) {
            this.operName = operName;
        }

        public String getBizIdDesc() {
            return bizIdDesc;
        }

        public void setBizIdDesc(String bizIdDesc) {
            this.bizIdDesc = bizIdDesc;
        }

        public String getItemPriceDesc() {
            return itemPriceDesc;
        }

        public void setItemPriceDesc(String itemPriceDesc) {
            this.itemPriceDesc = itemPriceDesc;
        }

        public String getItemTypeDesc() {
            return itemTypeDesc;
        }

        public void setItemTypeDesc(String itemTypeDesc) {
            this.itemTypeDesc = itemTypeDesc;
        }
    }
}
