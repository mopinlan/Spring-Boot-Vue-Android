/**
 * Filename:    CommentController
 * Author:      zzz123
 * Date:        2022/3/24 10:26
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.Comment;
import com.zwj.demo.entity.News;
import com.zwj.demo.entity.User;
import com.zwj.demo.service.impl.CommentServiceImpl;
import com.zwj.demo.service.impl.NewsServiceImpl;
import com.zwj.demo.utils.TokenUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/24 
 *@since 1.0.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/select")
    public Result returnRole() {
        return Result.success(commentService.list());
    }

//    @PostMapping("/insert")
////    public Result save(@RequestBody Comment comment) {
////        comment.setTime(new Date());
////        return Result.success(commentService.saveOrUpdate(comment));
////    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(commentService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(commentService.removeByIds(ids));
    }

    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String username) {
        IPage<Comment> iPage =commentService.findpage(new Page<Comment>(pageNum,pageSize),username );
        return Result.success(iPage);

    }

    @PostMapping
    public Result save(@RequestBody Comment comment, @RequestParam int  userid) {
        System.out.println("comment----------------"+comment);
        if (comment.getId() == null) { // 新增评论
            comment.setUserid(userid);
            comment.setTime(new Date());

            if (comment.getPid() != null) {  // 判断如果是回复，进行处理
                Integer pid = comment.getPid();
                Comment pComment = commentService.getById(pid);
                if (pComment.getOriginid() != null) {  // 如果当前回复的父级有祖宗，那么就设置相同的祖宗
                    comment.setOriginid(pComment.getOriginid());
                } else {  // 否则就设置父级为当前回复的祖宗
                    comment.setOriginid(comment.getPid());
                }
            }

        }
        System.out.println("comment----------------"+comment);
        return Result.success(commentService.saveOrUpdate(comment));
    }

    @GetMapping("/tree/{newsId}")
    public Result findTree(@PathVariable Integer newsId) {
        List<Comment> articleComments = commentService.findCommentDetail(newsId);  // 查询所有的评论和回复数据
        // 查询评论数据（不包括回复）
        List<Comment> originList = articleComments.stream().filter(comment -> comment.getOriginid() == null).collect(Collectors.toList());

        // 设置评论数据的子节点，也就是回复内容
        for (Comment origin : originList) {
            List<Comment> comments = articleComments.stream().filter(comment -> origin.getId().equals(comment.getOriginid())).collect(Collectors.toList());  // 表示回复对象集合
            comments.forEach(comment -> {
                Optional<Comment> pComment = articleComments.stream().filter(c1 -> c1.getId().equals(comment.getPid())).findFirst();  // 找到当前评论的父级
                pComment.ifPresent((v -> {  // 找到父级评论的用户id和用户昵称，并设置给当前的回复对象
                    comment.setPUserId(v.getUserid());
                    comment.setPNickname(v.getNickname());
                }));
            });
            origin.setChildren(comments);
        }
        return Result.success(originList);
    }
    @GetMapping("/select/{userid}")
    public Result findAllByUserId(@PathVariable Integer userid) {
        System.out.println("userid"+userid);
       List<Comment> comments=commentService.findCommentListAll(userid);
        System.out.println("list数据++++++++++++++++"+comments);
        return Result.success(comments);
    }
}
