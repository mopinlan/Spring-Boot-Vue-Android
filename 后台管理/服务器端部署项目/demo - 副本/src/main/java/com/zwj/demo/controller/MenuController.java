/**
 * Filename:    MenuController
 * Author:      zzz123
 * Date:        2022/3/13 10:00
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.service.impl.MenuServiceImpl;
import com.zwj.demo.common.Constants;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.Dict;
import com.zwj.demo.entity.Menu;
import com.zwj.demo.mapper.DictMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuServiceImpl menuService;
    @Resource
    private DictMapper dictMapper;

    @GetMapping("/select")
    public List<Menu> returnRole() {
        return menuService.list();
    }

    @PostMapping("/insert")
    public Result save(@RequestBody Menu menu) {
        return Result.success(menuService.saveOrUpdate(menu));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(menuService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(menuService.removeByIds(ids));
    }


    //分页+模糊查询 mybatis-plus版本
    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String name) {
        IPage<Menu> iPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }

        queryWrapper.orderByDesc("id");
        return Result.success(menuService.page(iPage, queryWrapper));
    }

    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "") String name) {
        return Result.success( menuService.findMenus(name));
    }
    @GetMapping("/icons")
     public Result getIcons() {
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("type", Constants.DICT_TYPE_ICON);
        return Result.success(dictMapper.selectList(dictQueryWrapper));
    }
    @GetMapping("/ids")
    public Result findAllIds() {
        return Result.success(menuService.list().stream().map(Menu::getId));
    }
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(menuService.getById(id));
    }
}
