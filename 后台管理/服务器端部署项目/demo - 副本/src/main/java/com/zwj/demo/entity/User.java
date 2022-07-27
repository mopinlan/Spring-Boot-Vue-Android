/**
 * Filename:    User
 * Author:      zzz123
 * Date:        2022/2/28 15:14
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/2/28 
 *@since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    @Alias("id")
    private Integer id;
    @Alias("用户名")
    private  String username;
    @JsonIgnore
    @Alias("密码")
    private  String password;
    @Alias("昵称")
    private String nickname;
    @Alias("邮箱")
    private  String email;
    @Alias("电话")
    private  String phone;
    @Alias("地址")
    private  String address;
    @Alias("头像")
   private String avatarUrl;
    @Alias("创建时间")
    private Date createTime;
    @Alias("角色")
    private String role;

}
