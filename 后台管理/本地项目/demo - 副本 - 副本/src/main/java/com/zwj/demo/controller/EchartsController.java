/**
 * Filename:    EchartsController
 * Author:      zzz123
 * Date:        2022/3/8 17:14
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.zwj.demo.common.Constants;
import com.zwj.demo.config.AuthAccess;
import com.zwj.demo.entity.Files;
import com.zwj.demo.mapper.FileMapper;
import com.zwj.demo.service.impl.*;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/8 
 *@since 1.0.0
 */
@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private FileMapper fileMapper;
    @GetMapping("/example")
    public Result get(){
        Map<String,Object> map=new HashMap<>();
        map.put("x", CollUtil.newArrayList());
        map.put("y", CollUtil.newArrayList());
        return Result.success(map);
    }
    @GetMapping("/members")
    public Result members(){
        List<User> list=userService.list();
        int q1=0;
        int q2=0;
        int q3=0;
        int q4=0;
        for(User user:list){
            Date creatTime=user.getCreateTime();
            Quarter quarter = DateUtil.quarterEnum(creatTime);
            switch (quarter){
                case Q1:q1 +=1;break;
                case Q2:q2 +=1;break;
                case Q3:q3 +=1;break;
                case Q4:q4 +=1;break;
                default:break;
            }
        }
        return Result.success(CollUtil.newArrayList(q1,q2,q3,q4));
    }
    //用户总数
    //新闻总数
    //新闻类别总数
    //评论总数
    @GetMapping("/getAll")
    public Result getAll(){
        int userCount = userService.count();
        int newsCount = newsService.count();
        int categoryCount = categoryService.count();
        int commentCount = commentService.count();
        return  Result.success(CollUtil.newArrayList(userCount,newsCount,categoryCount,commentCount));
    }
    @AuthAccess
    @GetMapping("/file/front/all")
//   @Cacheable(value = "files" ,key = "'frontAll'")
    public Result frontAll() {
        // 1. 从缓存获取数据
        String jsonStr = stringRedisTemplate.opsForValue().get(Constants.FILES_KEY);
        List<Files> files;
        if (StrUtil.isBlank(jsonStr)) {  // 2. 取出来的json是空的
            files = fileMapper.selectList(null);  // 3. 从数据库取出数据
            // 4. 再去缓存到redis
            stringRedisTemplate.opsForValue().set(Constants.FILES_KEY, JSONUtil.toJsonStr(files));
        } else {
            // 减轻数据库的压力
            // 5. 如果有, 从redis缓存中获取数据
            files = JSONUtil.toBean(jsonStr, new TypeReference<List<Files>>() {
            }, true);
        }
        return Result.success(files);
    }
}
