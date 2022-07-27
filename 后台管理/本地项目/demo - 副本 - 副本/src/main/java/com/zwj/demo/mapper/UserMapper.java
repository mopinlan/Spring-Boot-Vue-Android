/**
 * Filename:    UserMapper
 * Author:      zzz123
 * Date:        2022/2/28 15:18
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.entity.User;
import com.zwj.demo.entity.dto.UserPasswordDTO;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/2/28
 * @since 1.0.0
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

//    Page<User> findPage(Page<User> page, String username, String email, String address);
//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values(#{username},#{password},#{nickname},#{email} ,#{phone},#{address})")
//    int insert(User user);
//
//    //@Update("update sys_user set username=#{username},password=#{password},nickname=#{nickname},email=#{email},phone=#{phone},address=#{address} where id= #{id}")
//    int update(User user);
//  @Delete("delete from  sys_user where id=#{id}")
//    int deleteById(@Param("id") int id);
// @Select("select * from sys_user where username like concat('%',#{username},'%') limit #{pageNum} ,#{pageSize} ")
//    List<User> selectPage(int pageNum, int pageSize,String username);
// @Select("select count(*) from sys_user where username like concat('%',#{username},'%')")
//    int selectTotal(String username);
}
