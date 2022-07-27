package com.zwj.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.News;
import com.zwj.demo.entity.Role;
import com.zwj.demo.entity.User;
import com.zwj.demo.mapper.NewsMapper;
import com.zwj.demo.service.NewsService;
import com.zwj.demo.service.UserService;
import com.zwj.demo.service.impl.NewsServiceImpl;
import com.zwj.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/select")
    public Result returnRole() {
        return Result.success(newsService.list());
    }

    @PostMapping("/insert")
    public Result save(@RequestBody News news) {
        news.setTime(new Date());
        return Result.success(newsService.saveOrUpdate(news));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(newsService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(newsService.removeByIds(ids));
    }


    //分页+模糊查询 mybatis-plus版本
//    @GetMapping("/page")
//    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String name) {
//        IPage<News> iPage = new Page<>(pageNum, pageSize);
//        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
//        if (!"".equals(name)) {
//            queryWrapper.like("name", name);
//        }
//
//        queryWrapper.orderByDesc("id");
//        return Result.success(newsService.page(iPage, queryWrapper));
//    }
    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String title) {
        IPage<News> iPage =newsService.findpage(new Page<News>(pageNum,pageSize),title );
        return Result.success(iPage);

    }
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(newsService.getById(id));
    }
    @GetMapping("/all")
    public Result returnAll(@RequestParam(defaultValue = "") String title) {
       // IPage<News> iPage =newsService.findpage(new Page<News>(pageNum,pageSize),title );
        return Result.success(newsService.findAll(title));

    }
    @GetMapping("/ByCategoryId")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String title,@RequestParam(defaultValue="") int categoryId ) {
        IPage<News> iPage =newsService.findpageByCategoryId(new Page<News>(pageNum,pageSize),title,categoryId);
        return Result.success(iPage);

    }
}
