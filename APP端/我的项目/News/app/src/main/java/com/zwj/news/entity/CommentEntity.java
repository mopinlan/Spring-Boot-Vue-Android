package com.zwj.news.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommentEntity implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("content")
    private String content;
    @SerializedName("userid")
    private Object userid;
    @SerializedName("time")
    private String time;
    @SerializedName("pid")
    private Object pid;
    @SerializedName("newsid")
    private Object newsid;
    @SerializedName("originid")
    private Object originid;
    @SerializedName("news")
    private NewsEntity news;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("avatarUrl")
    private String avatarUrl;
    @SerializedName("children")
    private Object children;
    @SerializedName("user")
    private UserEntity user;
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

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
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

    public Object getNewsid() {
        return newsid;
    }

    public void setNewsid(Object newsid) {
        this.newsid = newsid;
    }

    public Object getOriginid() {
        return originid;
    }

    public void setOriginid(Object originid) {
        this.originid = originid;
    }

    public NewsEntity getNews() {
        return news;
    }

    public void setNews(NewsEntity news) {
        this.news = news;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
