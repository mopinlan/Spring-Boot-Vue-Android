/**
 * Filename:    Category
 * Author:      zzz123
 * Date:        2022/3/23 14:48
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/23 
 *@since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_category")
public class Category {
    private  int id;
    private  String type;
    private  String description;
}
