package com.zyx.common.exception;

import sun.awt.SunHints;

public enum BizCode {
    UNKNOWN_EXCEPTION(10000, "Unknown Exception"),
    VALID_EXCEPTION(10001, "Data type not valid"),
    PRODUCT_UP_EXCEPTION(11000, "Launching product error.");

    private int code;
    private String msg;
    BizCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
