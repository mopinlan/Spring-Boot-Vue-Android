/**
 * Filename:    MenuService
 * Author:      zzz123
 * Date:        2022/3/13 9:55
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwj.demo.entity.Menu;

import java.util.List;


/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/13 
 *@since 1.0.0
 */
public interface MenuService extends IService<Menu> {


    List<Menu> findMenus(String name);
}
