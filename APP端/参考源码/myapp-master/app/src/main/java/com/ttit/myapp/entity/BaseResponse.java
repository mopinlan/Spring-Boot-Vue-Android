package com.ttit.myapp.entity;

/**
 * @author: wei
 * @date: 2020-10-03
 **/
public class BaseResponse {

    /**
     * msg : success
     * code : 0
     */

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
