/**
 * Filename:    UserService
 * Author:      zzz123
 * Date:        2022/3/4 13:54
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwj.demo.entity.User;
import com.zwj.demo.entity.dto.UserDto;
import com.zwj.demo.entity.dto.UserPasswordDTO;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/4 
 *@since 1.0.0
 */
public interface UserService extends IService<User> {
    UserDto login(UserDto userDto);

    User register(UserDto userDto);

    void updatePassword(UserPasswordDTO userPasswordDTO);

//    Page<User> findPage(Page<User> objectPage, String username, String email, String address);
}
