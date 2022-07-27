/**
 * Filename:    CommentMapper
 * Author:      zzz123
 * Date:        2022/3/24 10:19
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.entity.Comment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/24 
 *@since 1.0.0
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    Page<Comment> findCommentPage(Page<Comment> page, @Param("username") String username);
    @Select("select c.*,u.nickname,u.avatar_url from sys_comment c left join sys_user u on c.userid = u.id " +
            "where c.newsid = #{newsId} order by id desc")
    List<Comment> findCommentDetail(@Param("newsId") Integer newsId);

    List<Comment> findCommentListAll(@Param("userid") Integer userid);
}
