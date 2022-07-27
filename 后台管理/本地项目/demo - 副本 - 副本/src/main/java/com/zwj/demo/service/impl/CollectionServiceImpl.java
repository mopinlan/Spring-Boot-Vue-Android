/**
 * Filename:    CollectionServiceImpl
 * Author:      zzz123
 * Date:        2022/4/10 9:19
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.Collection;
import com.zwj.demo.mapper.CollectionMapper;
import com.zwj.demo.service.CollectionService;
import org.springframework.stereotype.Service;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/4/10 
 *@since 1.0.0
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService{

}
