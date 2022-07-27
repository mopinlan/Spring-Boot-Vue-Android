package com.ttit.myapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-07-06
 **/
public class VideoListResponse implements Serializable {

    /**
     * msg : success
     * code : 0
     * page : {"totalCount":4,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"vid":1,"vtitle":"青龙战甲搭配机动兵，P城上空肆意1V4","author":"狙击手麦克","coverurl":"https://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/527d013205a74eb0a77202d7a9d5b511~tplv-crop-center:1041:582.jpg","headurl":"https://sf1-ttcdn-tos.pstatp.com/img/pgc-image/c783a73368fa4666b7842a635c63a8bf~360x360.image","commentNum":210,"likeNum":23,"collectNum":100},{"vid":2,"vtitle":"【仁王2】视频攻略 2-3 虚幻魔城","author":"黑桐谷歌","coverurl":"https://lf1-xgcdn-tos.pstatp.com/img/tos-cn-p-0000/9ff7fe6c89e44ca3a22aad5744e569e3~tplv-crop-center:1041:582.jpg","headurl":"https://sf6-ttcdn-tos.pstatp.com/img/mosaic-legacy/8110/752553978~360x360.image","commentNum":1300,"likeNum":500,"collectNum":120},{"vid":3,"vtitle":"最猛暴击吕布教学，这才是战神该有的样子","author":"小凡解说游戏","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/83cc11d5e26047c6b0ead149f41a8266~tplv-crop-center:1041:582.jpg","headurl":"https://p3.pstatp.com/large/a14a000405f16e51842f","commentNum":10,"likeNum":19,"collectNum":5},{"vid":4,"vtitle":"拳皇14：小孩输掉一分，印尼选手得意忘形","author":"E游未尽小E","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/b9553b7a28d94f27a7115157797b52ff~tplv-crop-center:1041:582.jpg","headurl":"https://sf3-ttcdn-tos.pstatp.com/img/pgc-image/f6b840d23f9e465bb5ac9e570b28321d~360x360.image","commentNum":22,"likeNum":180,"collectNum":963}]}
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
         * totalCount : 4
         * pageSize : 10
         * totalPage : 1
         * currPage : 1
         * list : [{"vid":1,"vtitle":"青龙战甲搭配机动兵，P城上空肆意1V4","author":"狙击手麦克","coverurl":"https://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/527d013205a74eb0a77202d7a9d5b511~tplv-crop-center:1041:582.jpg","headurl":"https://sf1-ttcdn-tos.pstatp.com/img/pgc-image/c783a73368fa4666b7842a635c63a8bf~360x360.image","commentNum":210,"likeNum":23,"collectNum":100},{"vid":2,"vtitle":"【仁王2】视频攻略 2-3 虚幻魔城","author":"黑桐谷歌","coverurl":"https://lf1-xgcdn-tos.pstatp.com/img/tos-cn-p-0000/9ff7fe6c89e44ca3a22aad5744e569e3~tplv-crop-center:1041:582.jpg","headurl":"https://sf6-ttcdn-tos.pstatp.com/img/mosaic-legacy/8110/752553978~360x360.image","commentNum":1300,"likeNum":500,"collectNum":120},{"vid":3,"vtitle":"最猛暴击吕布教学，这才是战神该有的样子","author":"小凡解说游戏","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/83cc11d5e26047c6b0ead149f41a8266~tplv-crop-center:1041:582.jpg","headurl":"https://p3.pstatp.com/large/a14a000405f16e51842f","commentNum":10,"likeNum":19,"collectNum":5},{"vid":4,"vtitle":"拳皇14：小孩输掉一分，印尼选手得意忘形","author":"E游未尽小E","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/b9553b7a28d94f27a7115157797b52ff~tplv-crop-center:1041:582.jpg","headurl":"https://sf3-ttcdn-tos.pstatp.com/img/pgc-image/f6b840d23f9e465bb5ac9e570b28321d~360x360.image","commentNum":22,"likeNum":180,"collectNum":963}]
         */

        private int totalCount;
        private int pageSize;
        private int totalPage;
        private int currPage;
        private List<VideoEntity> list;

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

        public List<VideoEntity> getList() {
            return list;
        }

        public void setList(List<VideoEntity> list) {
            this.list = list;
        }
    }
}
