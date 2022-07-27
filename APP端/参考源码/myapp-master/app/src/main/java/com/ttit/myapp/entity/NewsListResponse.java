package com.ttit.myapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-08-01
 **/
public class NewsListResponse implements Serializable {

    /**
     * msg : success
     * code : 0
     * page : {"totalCount":8,"pageSize":4,"totalPage":2,"currPage":1,"list":[{"newsId":1,"newsTitle":"《忍者蛙》发售日公布 已上架Steam、支持简中","authorName":"3DMGAME","headerUrl":"https://p9.pstatp.com/thumb/6eed00026c4eac713a44","commentCount":3,"releaseDate":"2020-07-31 22:23:00","type":1,"thumbEntities":[{"thumbId":1,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/S6KR5958Y5X2Qt?from=pc","newsId":1}]},{"newsId":2,"newsTitle":"外媒爆料：育碧\u201c阿瓦隆\u201d项目胎死腹中，只因为他不喜欢奇幻游戏","authorName":"爱游戏的萌博士","headerUrl":"https://p3.pstatp.com/thumb/43310001daafa9723ddf","commentCount":1,"releaseDate":"2020-07-31 21:01:17","type":2,"thumbEntities":[{"thumbId":2,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/714415d37865444ca2bef51eb1706cda?from=pc","newsId":2},{"thumbId":3,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/33b9831739764bdb8a157efce048ec85?from=pc","newsId":2},{"thumbId":4,"thumbUrl":"http://p3-tt.byteimg.com/large/pgc-image/c8a4e737b54d41c1a84722fc1c6d191d?from=pc","newsId":2}]},{"newsId":3,"newsTitle":"索尼公布Ready for PlayStation 5电视阵容","authorName":"游戏时光VGtime","headerUrl":"https://p1.pstatp.com/thumb/dc0c0004c450216ab2f3","commentCount":6,"releaseDate":"2020-07-30 13:11:32","type":3,"thumbEntities":[{"thumbId":5,"thumbUrl":"http://p6-tt.byteimg.com/large/pgc-image/S6CLixgC4HSrXD?from=pc","newsId":3}]},{"newsId":4,"newsTitle":"一部不受关注的互动电影佳作\u2014\u2014解构《暴雨》","authorName":"瑾瑜游乐说","headerUrl":"https://sf3-ttcdn-tos.pstatp.com/img/pgc-image/e200b9de317b4e73af24299ea063bec2~120x256.image","commentCount":12,"releaseDate":"2020-07-30 13:11:32","type":3,"thumbEntities":[{"thumbId":6,"thumbUrl":"http://p6-tt.byteimg.com/large/pgc-image/17fe1be328e149c9aa400dcf8a8c4dd6?from=pc","newsId":4}]}]}
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
         * pageSize : 4
         * totalPage : 2
         * currPage : 1
         * list : [{"newsId":1,"newsTitle":"《忍者蛙》发售日公布 已上架Steam、支持简中","authorName":"3DMGAME","headerUrl":"https://p9.pstatp.com/thumb/6eed00026c4eac713a44","commentCount":3,"releaseDate":"2020-07-31 22:23:00","type":1,"thumbEntities":[{"thumbId":1,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/S6KR5958Y5X2Qt?from=pc","newsId":1}]},{"newsId":2,"newsTitle":"外媒爆料：育碧\u201c阿瓦隆\u201d项目胎死腹中，只因为他不喜欢奇幻游戏","authorName":"爱游戏的萌博士","headerUrl":"https://p3.pstatp.com/thumb/43310001daafa9723ddf","commentCount":1,"releaseDate":"2020-07-31 21:01:17","type":2,"thumbEntities":[{"thumbId":2,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/714415d37865444ca2bef51eb1706cda?from=pc","newsId":2},{"thumbId":3,"thumbUrl":"http://p1-tt.byteimg.com/large/pgc-image/33b9831739764bdb8a157efce048ec85?from=pc","newsId":2},{"thumbId":4,"thumbUrl":"http://p3-tt.byteimg.com/large/pgc-image/c8a4e737b54d41c1a84722fc1c6d191d?from=pc","newsId":2}]},{"newsId":3,"newsTitle":"索尼公布Ready for PlayStation 5电视阵容","authorName":"游戏时光VGtime","headerUrl":"https://p1.pstatp.com/thumb/dc0c0004c450216ab2f3","commentCount":6,"releaseDate":"2020-07-30 13:11:32","type":3,"thumbEntities":[{"thumbId":5,"thumbUrl":"http://p6-tt.byteimg.com/large/pgc-image/S6CLixgC4HSrXD?from=pc","newsId":3}]},{"newsId":4,"newsTitle":"一部不受关注的互动电影佳作\u2014\u2014解构《暴雨》","authorName":"瑾瑜游乐说","headerUrl":"https://sf3-ttcdn-tos.pstatp.com/img/pgc-image/e200b9de317b4e73af24299ea063bec2~120x256.image","commentCount":12,"releaseDate":"2020-07-30 13:11:32","type":3,"thumbEntities":[{"thumbId":6,"thumbUrl":"http://p6-tt.byteimg.com/large/pgc-image/17fe1be328e149c9aa400dcf8a8c4dd6?from=pc","newsId":4}]}]
         */

        private int totalCount;
        private int pageSize;
        private int totalPage;
        private int currPage;
        private List<NewsEntity> list;

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

        public List<NewsEntity> getList() {
            return list;
        }

        public void setList(List<NewsEntity> list) {
            this.list = list;
        }
    }
}
