/**
 * Filename:    Comment
 * Author:      zzz123
 * Date:        2022/3/24 10:14
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/24
 * @since 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_comment")
public class Comment {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    private Integer userid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private Integer pid;
    private Integer newsid;

    private Integer originid;
    @TableField(exist = false)
    private News news;

    @TableField(exist = false)
    private String pNickname;  // 父节点的用户昵称
    @TableField(exist = false)
    private Integer pUserId;  // 父节点的用户id

    @TableField(exist = false)
    private String nickname;
    @TableField(exist = false)
    private String avatarUrl;

    @TableField(exist = false)
    private List<Comment> children;
    @TableField(exist = false)
    private User user;
}
