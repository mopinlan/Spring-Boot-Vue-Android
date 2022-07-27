/**
 * Filename:    CategoryServiceImpl
 * Author:      zzz123
 * Date:        2022/3/25 15:19
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.Category;
import com.zwj.demo.entity.Comment;
import com.zwj.demo.mapper.CategoryMapper;
import com.zwj.demo.mapper.CommentMapper;
import com.zwj.demo.service.CategoryService;
import com.zwj.demo.service.CommentService;
import org.springframework.stereotype.Service;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/25 
 *@since 1.0.0
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
