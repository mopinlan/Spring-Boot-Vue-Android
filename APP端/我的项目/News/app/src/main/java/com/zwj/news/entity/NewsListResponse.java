package com.zwj.news.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NewsListResponse implements Serializable {

    @Override
    public String toString() {
        return "NewsListResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    @SerializedName("code")
    private String code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("records")
        private List<NewsEntity> records;
        @SerializedName("total")
        private Integer total;
        @SerializedName("size")
        private Integer size;
        @SerializedName("current")
        private Integer current;
        @SerializedName("orders")
        private List<?> orders;
        @SerializedName("optimizeCountSql")
        private Boolean optimizeCountSql;
        @SerializedName("hitCount")
        private Boolean hitCount;
        @SerializedName("countId")
        private Object countId;
        @SerializedName("maxLimit")
        private Object maxLimit;
        @SerializedName("searchCount")
        private Boolean searchCount;
        @SerializedName("pages")
        private Integer pages;

        public List<NewsEntity> getRecords() {
            return records;
        }

        public void setRecords(List<NewsEntity> records) {
            this.records = records;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getCurrent() {
            return current;
        }

        public void setCurrent(Integer current) {
            this.current = current;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public Boolean getOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(Boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public Boolean getHitCount() {
            return hitCount;
        }

        public void setHitCount(Boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public Boolean getSearchCount() {
            return searchCount;
        }

        public void setSearchCount(Boolean searchCount) {
            this.searchCount = searchCount;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }


        }
}
