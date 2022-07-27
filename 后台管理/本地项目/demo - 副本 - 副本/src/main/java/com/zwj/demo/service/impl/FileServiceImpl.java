/**
 * Filename:    FileServiceImpl
 * Author:      zzz123
 * Date:        2022/3/7 13:27
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.Files;
import com.zwj.demo.mapper.FileMapper;
import com.zwj.demo.service.FileService;
import org.springframework.stereotype.Service;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/7 
 *@since 1.0.0
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements FileService {
}
