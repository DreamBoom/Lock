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

        private int cid;
        private int feeType;
        private int feeId;
        private int number;
        private String itemPriceDesc;
        private String totalAmountDesc;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getFeeType() {
            return feeType;
        }

        public void setFeeType(int feeType) {
            this.feeType = feeType;
        }

        public int getFeeId() {
            return feeId;
        }

        public void setFeeId(int feeId) {
            this.feeId = feeId;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
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
