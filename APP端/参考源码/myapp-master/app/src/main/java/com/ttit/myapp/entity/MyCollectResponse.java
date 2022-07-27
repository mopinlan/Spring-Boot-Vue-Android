package com.ttit.myapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-10-05
 **/
public class MyCollectResponse implements Serializable {

    /**
     * msg : success
     * code : 0
     * list : [{"vid":1,"vtitle":"青龙战甲搭配机动兵，P城上空肆意1V4","author":"狙击手麦克","coverurl":"http://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/527d013205a74eb0a77202d7a9d5b511~tplv-crop-center:1041:582.jpg","headurl":"https://sf1-ttcdn-tos.pstatp.com/img/pgc-image/c783a73368fa4666b7842a635c63a8bf~360x360.image","commentNum":121,"likeNum":123,"collectNum":122,"playurl":"http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4","createTime":"2020-07-14 11:21:45","updateTime":"2020-07-19 12:05:33","categoryId":1,"categoryName":null,"videoSocialEntity":null},{"vid":3,"vtitle":"最猛暴击吕布教学，这才是战神该有的样子","author":"小凡解说游戏","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/83cc11d5e26047c6b0ead149f41a8266~tplv-crop-center:1041:582.jpg","headurl":"https://p3.pstatp.com/large/a14a000405f16e51842f","commentNum":10,"likeNum":19,"collectNum":5,"playurl":"http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4","createTime":null,"updateTime":"2020-07-19 12:05:35","categoryId":1,"categoryName":null,"videoSocialEntity":null},{"vid":4,"vtitle":"拳皇14：小孩输掉一分，印尼选手得意忘形","author":"E游未尽小E","coverurl":"https://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0004/b9553b7a28d94f27a7115157797b52ff~tplv-crop-center:1041:582.jpg","headurl":"https://sf3-ttcdn-tos.pstatp.com/img/pgc-image/f6b840d23f9e465bb5ac9e570b28321d~360x360.image","commentNum":22,"likeNum":180,"collectNum":963,"playurl":"http://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4","createTime":null,"updateTime":"2020-07-19 12:05:37","categoryId":1,"categoryName":null,"videoSocialEntity":null}]
     */

    private String msg;
    private int code;
    private List<VideoEntity> list;

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

    public List<VideoEntity> getList() {
        return list;
    }

    public void setList(List<VideoEntity> list) {
        this.list = list;
    }
}
