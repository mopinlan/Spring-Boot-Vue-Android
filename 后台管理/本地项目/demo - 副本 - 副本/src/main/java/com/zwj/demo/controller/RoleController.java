/**
 * Filename:    RoleController
 * Author:      zzz123
 * Date:        2022/3/9 10:52
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.service.impl.RoleServiceImpl;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.Role;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleServiceImpl roleService;

    @GetMapping("/select")
    public Result returnRole() {
        return Result.success(roleService.list());
    }

    @PostMapping("/insert")
    public Result save(@RequestBody Role role) {
        return Result.success(roleService.saveOrUpdate(role));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(roleService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(roleService.removeByIds(ids));
    }


    //分页+模糊查询 mybatis-plus版本
    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String name) {
        IPage<Role> iPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }

        queryWrapper.orderByDesc("id");
        return Result.success(roleService.page(iPage, queryWrapper));
    }

    //绑定角色和菜单的关系
    @PostMapping("/roleMenu/{roleId}")
    public Result roleMenu(@PathVariable Integer roleId, @RequestBody List<Integer> menuIds) {
    roleService.setRoleMenu(roleId,menuIds);
        return Result.success();
    }

    @GetMapping("/roleMenu/{roleId}")
    public Result getRoleMenu(@PathVariable Integer roleId) {
        return Result.success(roleService.getRoleMenu(roleId));
    }
}
