/**
 * Filename:    UserController
 * Author:      zzz123
 * Date:        2022/2/28 15:22
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.entity.dto.UserPasswordDTO;
import com.zwj.demo.service.UserService;
import com.zwj.demo.service.impl.UserServiceImpl;
import com.zwj.demo.common.Constants;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.User;
import com.zwj.demo.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/2/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    //    @Value("${files.upload.path}")
//    private String fileUploadPath;
    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceimpl;

    @GetMapping("/select")
    public List<User> returnuser() {
        return userService.list();
    }

    @PostMapping("/insert")
    public Result save(@RequestBody User user) {
        return Result.success(userServiceimpl.saveOrUpdate(user));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(userServiceimpl.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(userServiceimpl.removeByIds(ids));
    }

    //分页查询 //分页模糊查询
//    @GetMapping("/page")
// public  Map<String,Object> returnpage(@RequestParam int pageNum ,@RequestParam int pageSize,@RequestParam String username){
//        pageNum=(pageNum-1)*pageSize;
//        List<User> userList = userMapper.selectPage(pageNum, pageSize,username);
//        int i = userMapper.selectTotal(username);
//        Map<String,Object> res=new HashMap<>();
//        res.put("data",userList);
//        res.put("total",i);
//        return res;
//    }
    //分页+模糊查询 mybatis-plus版本
    @GetMapping("/page")
    public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String address) {
        IPage<User> iPage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        queryWrapper.orderByDesc("id");
        return Result.success(userService.page(iPage, queryWrapper));
//        return Result.success(userService.findPage(new Page<>(pageNum, pageSize), username, email, address));
    }

    /*
        excel导出接口i
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<User> list = userService.list();
        //通过工具类 写出到硬盘
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
//    writer.addHeaderAlias("id","id");
//    writer.addHeaderAlias("username","用户名");
//    writer.addHeaderAlias("password","密码");
//    writer.addHeaderAlias("nickname","昵称");
//    writer.addHeaderAlias("email","邮箱");
//    writer.addHeaderAlias("phone","电话");
//    writer.addHeaderAlias("address","地址");
//    writer.addHeaderAlias("createTime","创建时间");
//    writer.addHeaderAlias("avatarUrl","头像");

        writer.write(list, true);
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    // excel 导入
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<User> list = reader.readAll(User.class);
        return Result.success(userService.saveBatch(list));
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "返回参数错误");
        }
        UserDto dto = userServiceimpl.login(userDto);
       // System.out.println(Result.success(dto));
        return Result.success(dto);
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "返回参数错误");
        }
        return Result.success(userServiceimpl.register(userDto));
    }

    //
    @GetMapping("/username/{username}")
    public Result findone(@PathVariable String username) {
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username", username);
        return  Result.success(userServiceimpl.getOne(objectQueryWrapper));
    }
    /**
     * 修改密码
     * @param userPasswordDTO
     * @return
     */
    @PostMapping("/password")
    public Result password(@RequestBody UserPasswordDTO userPasswordDTO) {
        userService.updatePassword(userPasswordDTO);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }
}
