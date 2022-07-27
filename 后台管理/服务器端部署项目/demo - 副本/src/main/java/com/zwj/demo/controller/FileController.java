/**
 * Filename:    FileController
 * Author:      zzz123
 * Date:        2022/3/6 13:51
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.common.Constants;
import com.zwj.demo.service.impl.FileServiceImpl;
import com.zwj.demo.common.Result;
import com.zwj.demo.entity.Files;
import com.zwj.demo.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileMapper fileMapper;

    @Value("${server.ip}")
    private String serverIp;
    @Autowired
    private FileServiceImpl fileService;
    @Value("${files.upload.path}")
    private String fileuploadPath;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        System.out.println("文件-----------------------"+file);
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        //定义一个文件的标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUuid = uuid + StrUtil.DOT + type;
        File file1 = new File(fileuploadPath + fileUuid);
        //判断配置的文件夹是否存在，没有则创建
        File parentFile=file1.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        String url;
        //上传到磁盘
        File uploadFile = new File(fileuploadPath);
        file.transferTo(file1);
        //获取文件的MD5
       String md5 = SecureUtil.md5(file1);
       //从数据库中查询是否有相关记录
        Files one = getFileByMD5(md5);
        if (one != null) {
            url = one.getUrl();
            //由于文件存在，所以删除刚刚上传的
            file1.delete();
        }else {
        //    10.0.2.2:9091/file/230841c797184d74a90fb8be0fb326ff.jpg
            //数据库不存在则，不删除
            url = "http://" + serverIp + ":9091/file/" + fileUuid;
            //url = "http://localhost:9091/file/" + fileUuid;
        }

        //存储数据库
        Files files = new Files();
        files.setName(originalFilename);
        files.setType(type);
        files.setUrl(url);
        files.setSize(size / 1024);
//        files.setIsDelete(true);
//        files.setEnable(true);
        files.setMd5(md5);
        fileMapper.insert(files);
        // 从redis取出数据，操作完，再设置（不用查询数据库）
//        String json = stringRedisTemplate.opsForValue().get(Constants.FILES_KEY);
//        List<Files> files1 = JSONUtil.toBean(json, new TypeReference<List<Files>>() {
//        }, true);
//        files1.add(saveFile);
//        setCache(Constants.FILES_KEY, JSONUtil.toJsonStr(files1));


        // 从数据库查出数据
//        List<Files> files = fileMapper.selectList(null);
//        // 设置最新的缓存
//        setCache(Constants.FILES_KEY, JSONUtil.toJsonStr(files));

        // 最简单的方式：直接清空缓存
//        flushRedis(Constants.FILES_KEY);
        return url;
    }

    @GetMapping("/{fileUuid}")
    public void download(@PathVariable String fileUuid, HttpServletResponse response) throws IOException {
        //根据文件uuid获取文件
        File file = new File(fileuploadPath + fileUuid);
        //设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUuid, "UTF-8"));
        response.setContentType("application/octet-stream");
//读取文件字节流
        os.write(FileUtil.readBytes(file));
        os.flush();
        os.close();
    }
   //查询
   @GetMapping("/page")
   public Result returnpage(@RequestParam int pageNum, @RequestParam int pageSize,
                            @RequestParam(defaultValue = "") String name) {
       IPage<Files> iPage = new Page<>(pageNum, pageSize);
       QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
       //查询未删除的记录
//       queryWrapper.eq("is_delete",false);

       if (!"".equals(name)) {
           queryWrapper.like("name", name);
       }
       queryWrapper.orderByDesc("id");
       return Result.success(fileMapper.selectPage(iPage, queryWrapper));
   }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return Result.success(fileService.removeById(id));
    }

    //    批量删除
    @PostMapping("/delete/batch/")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(fileService.removeByIds(ids));
    }


    //更新
    @PostMapping("/insert")
    public Result save(@RequestBody  Files files) {
        return Result.success(fileService.updateById(files));
    }
    private Files getFileByMD5(String md5) {
        QueryWrapper<Files> queryWrapper = new QueryWrapper();
        queryWrapper.eq("md5", md5);
        List<Files> filesList = fileMapper.selectList(queryWrapper);
        return filesList.size()==0?null:filesList.get(0);
    }
    //富文本返回方法
    @PostMapping("/editor/upload")
    public JSON editorUpload(MultipartFile file) throws IOException {
        System.out.println("文件-----------------------"+file);
        String url;
        if(file!=null){
            url = upload(file);
            JSONObject json = new JSONObject();
            json.set("errno", 0);
            JSONArray arr = new JSONArray();
            JSONObject data = new JSONObject();
            arr.add(data);
            data.set("url", url);
            json.set("data", arr);
            return json;  // 返回结果 url
        }
        else {
            JSONObject json = new JSONObject();
            json.set("errno", 1);
            return json;
        }

    }
    // 设置缓存
    private void setCache(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    // 删除缓存
    private void flushRedis(String key) {
        stringRedisTemplate.delete(key);
    }
}
