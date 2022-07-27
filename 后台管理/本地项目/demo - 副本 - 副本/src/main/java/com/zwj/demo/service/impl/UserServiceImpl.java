/**
 * Filename:    UserServiceImpl
 * Author:      zzz123
 * Date:        2022/3/4 13:56
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;


import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.common.Constants;
import com.zwj.demo.entity.Menu;
import com.zwj.demo.entity.User;
import com.zwj.demo.entity.dto.UserDto;
import com.zwj.demo.entity.dto.UserPasswordDTO;
import com.zwj.demo.exception.ServiceException;
import com.zwj.demo.mapper.RoleMapper;
import com.zwj.demo.mapper.RoleMenuMapper;
import com.zwj.demo.mapper.UserMapper;
import com.zwj.demo.service.UserService;
import com.zwj.demo.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/4
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private static final Log LOG = Log.get();
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuServiceImpl menuService;

    @Override
    public UserDto login(UserDto userDto) {
        User one = getUserInfo(userDto);
        if (one != null) {
            BeanUtils.copyProperties(one, userDto);
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDto.setToken(token);

            String role = one.getRole();
            userDto.setMenus(getRoleMenu(role));
            return userDto;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或者密码错误");
        }
    }

    @Override
    public User register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if (one == null) {
            one = new User();
            BeanUtils.copyProperties(userDto, one);
            save(one);
            return one;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名已存在");
        }

    }

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

//    @Override
//    public Page<User> findPage(Page<User> page, String username, String email, String address) {
//        return userMapper.findPage(page, username, email, address);
//    }

    private User getUserInfo(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");

        }
        return one;
    }
//    获取当前角色的菜单列表
    private  List<Menu> getRoleMenu( String roleFlag){
        Integer roleId = roleMapper.selectByFlag(roleFlag);
        //当前角色的所有菜单id集合
        List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);
        //查出系统所有菜单
        List<Menu> menus = menuService.findMenus("");
        //new一个最后筛选完成之后的List
        List<Menu> roleMenus = new ArrayList();
        //筛选当前用户角色的菜单
        for (Menu menu : menus) {
            if (menuIds.contains(menu.getId())) {
                roleMenus.add(menu);
            }
            List<Menu> children=menu.getChildren();
            //removeif 移除不在children里面不在 menuids集合中的元素
            children.removeIf(child -> !menuIds.contains(child.getId()));
        }
        return  roleMenus;
    }
}
