package com.zwj.news.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CollectionEntity implements Serializable {

    @SerializedName("code")
    private String code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<DataDTO> data;

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

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("content")
        private String content;
        @SerializedName("userid")
        private Integer userid;
        @SerializedName("time")
        private String time;
        @SerializedName("pid")
        private Object pid;
        @SerializedName("newsid")
        private Integer newsid;
        @SerializedName("originid")
        private Object originid;
        @SerializedName("news")
        private Object news;
        @SerializedName("nickname")
        private Object nickname;
        @SerializedName("avatarUrl")
        private Object avatarUrl;
        @SerializedName("children")
        private Object children;
        @SerializedName("user")
        private Object user;
        @SerializedName("puserId")
        private Object puserId;
        @SerializedName("pnickname")
        private Object pnickname;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getUserid() {
            return userid;
        }

        public void setUserid(Integer userid) {
            this.userid = userid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Object getPid() {
            return pid;
        }

        public void setPid(Object pid) {
            this.pid = pid;
        }

        public Integer getNewsid() {
            return newsid;
        }

        public void setNewsid(Integer newsid) {
            this.newsid = newsid;
        }

        public Object getOriginid() {
            return originid;
        }

        public void setOriginid(Object originid) {
            this.originid = originid;
        }

        public Object getNews() {
            return news;
        }

        public void setNews(Object news) {
            this.news = news;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public Object getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(Object avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public Object getChildren() {
            return children;
        }

        public void setChildren(Object children) {
            this.children = children;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public Object getPuserId() {
            return puserId;
        }

        public void setPuserId(Object puserId) {
            this.puserId = puserId;
        }

        public Object getPnickname() {
            return pnickname;
        }

        public void setPnickname(Object pnickname) {
            this.pnickname = pnickname;
        }
    }
}
