package com.ttit.myapp.api;

public class ApiConfig {
    public static final int PAGE_SIZE = 5;
    public static final String BASE_URl = "http://192.168.31.32:8080/renren-fast";
    public static final String LOGIN = "/app/login"; //登录
    public static final String REGISTER = "/app/register";//注册
    public static final String VIDEO_LIST_ALL = "/app/videolist/listAll";//所有类型视频列表
    public static final String VIDEO_LIST_BY_CATEGORY = "/app/videolist/getListByCategoryId";//各类型视频列表
    public static final String VIDEO_CATEGORY_LIST = "/app/videocategory/list";//视频类型列表
    public static final String NEWS_LIST = "/app/news/api/list";//资讯列表
    public static final String VIDEO_UPDATE_COUNT = "/app/videolist/updateCount";//更新点赞,收藏,评论
    public static final String VIDEO_MYCOLLECT = "/app/videolist/mycollect";//我的收藏

}
