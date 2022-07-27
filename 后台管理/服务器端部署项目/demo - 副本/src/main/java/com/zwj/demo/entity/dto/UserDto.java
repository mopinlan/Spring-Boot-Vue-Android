/**
 * Filename:    UserDto
 * Author:      zzz123
 * Date:        2022/3/4 13:58
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.entity.dto;

import com.zwj.demo.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/4 
 *@since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String address;
    private String token;
    private String role;
    private List<Menu> menus;
}
