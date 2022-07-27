/**
 * Filename:    CategoryController
 * Author:      zzz123
 * Date:        2022/3/25 15:23
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.common.Constants;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.Category;
import com.zwj.demo.entity.Dict;
import com.zwj.demo.entity.Role;
import com.zwj.demo.mapper.CategoryMapper;
import com.zwj.demo.service.impl.CategoryServiceImpl;
import com.zwj.demo.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/25 
 *@since 1.0.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryServiceImpl categoryService;

    @GetMapping("/select")
    public Result returnCategory() {
        return Result.success(categoryService.list());
    }

    @PostMapping("/insert")
    public Result save(@RequestBody Category category) {
        return Result.success(categoryService.saveOrUpdate(category));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(categoryService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(categoryService.removeByIds(ids));
    }


    //分页+模糊查询 mybatis-plus版本
    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String name) {
        IPage<Category> iPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("type", name);
        }

        queryWrapper.orderByDesc("id");
        return Result.success(categoryService.page(iPage, queryWrapper));
    }


}
