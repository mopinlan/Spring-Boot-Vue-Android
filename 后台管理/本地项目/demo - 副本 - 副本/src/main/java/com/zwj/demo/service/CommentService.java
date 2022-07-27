/**
 * Filename:    CommentService
 * Author:      zzz123
 * Date:        2022/3/24 10:17
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwj.demo.entity.Comment;
import com.zwj.demo.entity.News;

import java.util.List;


/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/24 
 *@since 1.0.0
 */
public interface CommentService extends IService<Comment> {
    IPage<Comment> findpage(Page<Comment> page, String username);

    List<Comment> findCommentDetail(Integer newsId);

    List<Comment> findCommentListAll(Integer userid);
}
