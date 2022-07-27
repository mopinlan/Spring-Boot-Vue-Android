package com.zwj.news.api;

public class ApiConfig {
    public static final int PAGE_SIZE = 5; 
    public static final String BASE_URl = "http://47.116.21.234:9091";
    public static final String LOGIN = "/user/login"; //登录
    public static final String REGISTER = "/user/register";//注册
    public static final String Comment_List = "/comment/select/";//所有的评论参数为用户id?
    public static final String News_LIST_BY_CATEGORY = "/news/ByCategoryId";//按照分类id查找新闻
    public static final String News_CATEGORY_LIST = "/category/select";//新闻类型列表



}
