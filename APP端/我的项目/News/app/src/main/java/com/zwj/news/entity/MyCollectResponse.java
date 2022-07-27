package com.zwj.news.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-10-05
 **/
public class MyCollectResponse implements Serializable {


    @SerializedName("code")
    private String code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<CommentEntity> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CommentEntity> getData() {
        return data;
    }

    public void setData(List<CommentEntity> data) {
        this.data = data;
    }

}
