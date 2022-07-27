/**
 * Filename:    CategoryMapper
 * Author:      zzz123
 * Date:        2022/3/25 15:11
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwj.demo.entity.Category;
import com.zwj.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/25 
 *@since 1.0.0
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
