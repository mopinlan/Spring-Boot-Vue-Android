package com.zwj.news.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author: wei
 * @date: 2020-07-19
 **/
public class CategoryEntity implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("type")
    private String type;
    @SerializedName("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
