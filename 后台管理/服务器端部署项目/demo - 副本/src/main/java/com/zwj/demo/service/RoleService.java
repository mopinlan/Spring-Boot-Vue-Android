/**
 * Filename:    RoleService
 * Author:      zzz123
 * Date:        2022/3/9 10:47
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwj.demo.entity.Role;

import java.util.List;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/9 
 *@since 1.0.0
 */
public interface RoleService  extends IService<Role> {

    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
