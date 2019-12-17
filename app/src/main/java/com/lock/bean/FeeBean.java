package com.lock.bean;

public class FeeBean {

    /**
     * success : true
     * code : 00
     * message : 操作成功
     * module : {"id":2,"gmtCreate":null,"gmtModify":null,"itemPrice1":5000,"itemPrice2":6000,"itemPrice3":10000,"provinceCode":"320000","cityCode":"320100","operId":null,"itemPrice":5000,"provinceName":null,"cityName":null,"operName":null,"createTimeDesc":null,"itemPrice1Desc":"50.00","itemPrice2Desc":"60.00","itemPrice3Desc":"100.00","itemPriceDesc":"50.00"}
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
         * id : 2
         * gmtCreate : null
         * gmtModify : null
         * itemPrice1 : 5000
         * itemPrice2 : 6000
         * itemPrice3 : 10000
         * provinceCode : 320000
         * cityCode : 320100
         * operId : null
         * itemPrice : 5000
         * provinceName : null
         * cityName : null
         * operName : null
         * createTimeDesc : null
         * itemPrice1Desc : 50.00
         * itemPrice2Desc : 60.00
         * itemPrice3Desc : 100.00
         * itemPriceDesc : 50.00
         */

        private int id;
        private Object gmtCreate;
        private Object gmtModify;
        private int itemPrice1;
        private int itemPrice2;
        private int itemPrice3;
        private String provinceCode;
        private String cityCode;
        private Object operId;
        private int itemPrice;
        private Object provinceName;
        private Object cityName;
        private Object operName;
        private Object createTimeDesc;
        private String itemPrice1Desc;
        private String itemPrice2Desc;
        private String itemPrice3Desc;
        private String itemPriceDesc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(Object gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public Object getGmtModify() {
            return gmtModify;
        }

        public void setGmtModify(Object gmtModify) {
            this.gmtModify = gmtModify;
        }

        public int getItemPrice1() {
            return itemPrice1;
        }

        public void setItemPrice1(int itemPrice1) {
            this.itemPrice1 = itemPrice1;
        }

        public int getItemPrice2() {
            return itemPrice2;
        }

        public void setItemPrice2(int itemPrice2) {
            this.itemPrice2 = itemPrice2;
        }

        public int getItemPrice3() {
            return itemPrice3;
        }

        public void setItemPrice3(int itemPrice3) {
            this.itemPrice3 = itemPrice3;
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

        public Object getOperId() {
            return operId;
        }

        public void setOperId(Object operId) {
            this.operId = operId;
        }

        public int getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(int itemPrice) {
            this.itemPrice = itemPrice;
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

        public Object getOperName() {
            return operName;
        }

        public void setOperName(Object operName) {
            this.operName = operName;
        }

        public Object getCreateTimeDesc() {
            return createTimeDesc;
        }

        public void setCreateTimeDesc(Object createTimeDesc) {
            this.createTimeDesc = createTimeDesc;
        }

        public String getItemPrice1Desc() {
            return itemPrice1Desc;
        }

        public void setItemPrice1Desc(String itemPrice1Desc) {
            this.itemPrice1Desc = itemPrice1Desc;
        }

        public String getItemPrice2Desc() {
            return itemPrice2Desc;
        }

        public void setItemPrice2Desc(String itemPrice2Desc) {
            this.itemPrice2Desc = itemPrice2Desc;
        }

        public String getItemPrice3Desc() {
            return itemPrice3Desc;
        }

        public void setItemPrice3Desc(String itemPrice3Desc) {
            this.itemPrice3Desc = itemPrice3Desc;
        }

        public String getItemPriceDesc() {
            return itemPriceDesc;
        }

        public void setItemPriceDesc(String itemPriceDesc) {
            this.itemPriceDesc = itemPriceDesc;
        }
    }
}
