/**
 * Filename:    AuthAccess
 * Author:      zzz123
 * Date:        2022/3/28 9:34
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.config;

import java.lang.annotation.*;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/28 
 *@since 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthAccess {

}
