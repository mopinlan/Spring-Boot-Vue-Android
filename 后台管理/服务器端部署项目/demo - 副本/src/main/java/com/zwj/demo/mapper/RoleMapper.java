/**
 * Filename:    RoleMapper
 * Author:      zzz123
 * Date:        2022/3/9 10:46
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zwj.demo.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/9 
 *@since 1.0.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select id from sys_role where flag=#{flag}")
    Integer selectByFlag(@Param("flag") String role);
}
