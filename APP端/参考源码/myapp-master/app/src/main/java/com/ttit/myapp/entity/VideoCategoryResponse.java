package com.ttit.myapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-07-19
 **/
public class VideoCategoryResponse implements Serializable {

    /**
     * msg : success
     * code : 0
     * page : {"totalCount":8,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"categoryId":1,"categoryName":"游戏"},{"categoryId":2,"categoryName":"音乐"},{"categoryId":3,"categoryName":"美食"},{"categoryId":4,"categoryName":"农人"},{"categoryId":5,"categoryName":"vlog"},{"categoryId":6,"categoryName":"搞笑"},{"categoryId":7,"categoryName":"宠物"},{"categoryId":8,"categoryName":"军事"}]}
     */

    private String msg;
    private int code;
    private PageBean page;

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

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * totalCount : 8
         * pageSize : 10
         * totalPage : 1
         * currPage : 1
         * list : [{"categoryId":1,"categoryName":"游戏"},{"categoryId":2,"categoryName":"音乐"},{"categoryId":3,"categoryName":"美食"},{"categoryId":4,"categoryName":"农人"},{"categoryId":5,"categoryName":"vlog"},{"categoryId":6,"categoryName":"搞笑"},{"categoryId":7,"categoryName":"宠物"},{"categoryId":8,"categoryName":"军事"}]
         */

        private int totalCount;
        private int pageSize;
        private int totalPage;
        private int currPage;
        private List<CategoryEntity> list;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrPage() {
            return currPage;
        }

        public void setCurrPage(int currPage) {
            this.currPage = currPage;
        }

        public List<CategoryEntity> getList() {
            return list;
        }

        public void setList(List<CategoryEntity> list) {
            this.list = list;
        }
    }
}
