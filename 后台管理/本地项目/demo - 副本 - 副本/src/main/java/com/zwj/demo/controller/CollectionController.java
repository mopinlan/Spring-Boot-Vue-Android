/**
 * Filename:    CollectionController
 * Author:      zzz123
 * Date:        2022/4/10 9:25
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.controller;

import com.zwj.demo.service.CollectionService;
import com.zwj.demo.service.impl.CollectionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/4/10 
 *@since 1.0.0
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionServiceImpl collectionService;

}
