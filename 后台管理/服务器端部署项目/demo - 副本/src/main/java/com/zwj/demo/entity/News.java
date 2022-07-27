/**
 * Filename:    News
 * Author:      zzz123
 * Date:        2022/3/21 15:06
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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/21 
 *@since 1.0.0
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_news")
public class News {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private String content;
   // private String author;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private  int cid;
    @TableField(exist = false)
    private Category category;
    private int uid;
    @TableField(exist = false)
    private User user;
    //封面图
    private String coverimg;

}
