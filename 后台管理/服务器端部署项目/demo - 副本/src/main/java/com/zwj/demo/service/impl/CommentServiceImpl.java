/**
 * Filename:    CommentServiceImpl
 * Author:      zzz123
 * Date:        2022/3/24 10:18
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.Comment;
import com.zwj.demo.entity.News;
import com.zwj.demo.mapper.CommentMapper;

import com.zwj.demo.service.CommentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/24 
 *@since 1.0.0
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public Page<Comment> findpage(Page<Comment> page, String username) {
        return commentMapper.findCommentPage(page,username);
    }

    @Override
    public List<Comment> findCommentDetail(Integer newsId) {
        return commentMapper.findCommentDetail(newsId);
    }

    @Override
    public List<Comment> findCommentListAll(Integer userid) {
        return (List<Comment>) commentMapper.findCommentListAll(userid);
    }
}
