package com.ttit.myapp.entity;

import java.io.Serializable;

/**
 * @author: wei
 * @date: 2020-07-19
 **/
public class CategoryEntity implements Serializable {
    /**
     * categoryId : 1
     * categoryName : 游戏
     */

    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
