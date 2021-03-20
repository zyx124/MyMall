package com.zyx.common.constant;

public class ProductConstant {

    public enum AttrEnum {
        ATTR_TYPE_BASE(1, "base attribute"), ATTR_TYPE_SALE(0, "attribute for sale");

        private int code;
        private String msg;

        AttrEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }


    }

    public enum StatusEnum {
        NEW_SPU(0, "new product"), SPU_UP(1, "launch product"), SPU_DOWN(2, "discontinue product");

        private int code;
        private String msg;

        StatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }


    }


}
