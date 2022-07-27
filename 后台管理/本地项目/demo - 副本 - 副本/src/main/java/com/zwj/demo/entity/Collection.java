/**
 * Filename:    Collection
 * Author:      zzz123
 * Date:        2022/4/10 9:16
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/4/10 
 *@since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_collection")
public class Collection {
    @TableId(type = IdType.AUTO)
    private int id;
    private  int newsid;
    private  int userid;
    private  Boolean flag;
}
