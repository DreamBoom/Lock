package com.lock.bean;

import java.io.Serializable;
import java.util.List;

public class UpBean implements Serializable {

    /**
     * id : 16
     * paymentType : 1
     * items : [{"cid":1,"feeType":1,"feeId":1,"number":1,"itemPriceDesc":"50.00","totalAmountDesc":"50.00"},{"cid":2,"feeType":2,"feeId":2,"number":1,"itemPriceDesc":"100.00","totalAmountDesc":"100.00"}]
     */

    private int id;
    private int paymentType;
    private List<ItemsBean> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * cid : 1
         * feeType : 1
         * feeId : 1
         * number : 1
         * itemPriceDesc : 50.00
         * totalAmountDesc : 50.00
         */

        private String cid;
        private String feeType;
        private String feeId;
        private String number;
        private String itemPriceDesc;
        private String totalAmountDesc;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public String getFeeId() {
            return feeId;
        }

        public void setFeeId(String feeId) {
            this.feeId = feeId;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
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
