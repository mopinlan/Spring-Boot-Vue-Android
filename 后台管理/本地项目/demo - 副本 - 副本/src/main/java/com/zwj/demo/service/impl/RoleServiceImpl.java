/**
 * Filename:    RoleServiceImpl
 * Author:      zzz123
 * Date:        2022/3/9 10:48
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.Menu;
import com.zwj.demo.entity.Role;
import com.zwj.demo.entity.RoleMenu;
import com.zwj.demo.mapper.RoleMapper;
import com.zwj.demo.mapper.RoleMenuMapper;
import com.zwj.demo.service.RoleService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/9
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private  RoleMenuMapper roleMenuMapper;
    @Resource
    private MenuServiceImpl menuService;
    @Transactional
    @Override
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {
        //先删除当前id所绑定的关系
        roleMenuMapper.deleteByRoleId(roleId);
        //再把前端传过来的菜单id数组绑定到当前角色id上
        List<Integer> menuIdsCopy= CollUtil.newArrayList(menuIds);
        for (Integer menuId : menuIds) {
            Menu menu = menuService.getById(menuId);
            if(menu.getPid()!=null && !menuIdsCopy.contains(menu.getPid())){//二级菜单，并且传过来的menuId数组里面没有它的父级id
                RoleMenu roleMenu=new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getPid());
                roleMenuMapper.insert(roleMenu);
               menuIdsCopy.add(menu.getPid());
            }
            RoleMenu roleMenu=new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }
}
