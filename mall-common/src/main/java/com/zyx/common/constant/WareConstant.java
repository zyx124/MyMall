package com.zyx.common.constant;

public class WareConstant {
    public enum PurchaseStatusEnum {
        CREATED(0, "create new"), ASSIGNED(1, "distributed"), RECEIVED(2, "received"),
        FINISHED(3, "finished"), HASERROR(4, "has an error");

        private int code;
        private String msg;

        PurchaseStatusEnum(int code, String msg) {
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

    public enum PurchaseDetailStatusEnum {
        CREATED(0, "create new"), ASSIGNED(1, "distributed"), BUYING(2, "buying"),
        FINISHED(3, "finished"), HASERROR(4, "buying error");

        private int code;
        private String msg;

        PurchaseDetailStatusEnum(int code, String msg) {
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
