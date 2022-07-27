/**
 * Filename:    DictMapper
 * Author:      zzz123
 * Date:        2022/3/13 15:46
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwj.demo.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/13 
 *@since 1.0.0
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {
}
