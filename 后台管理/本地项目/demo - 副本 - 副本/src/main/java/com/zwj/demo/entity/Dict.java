/**
 * Filename:    Dict
 * Author:      zzz123
 * Date:        2022/3/13 15:45
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
 *@create 2022/3/13 
 *@since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dict")
public class Dict {
    private String name;
    private String value;
    private String type;
}
