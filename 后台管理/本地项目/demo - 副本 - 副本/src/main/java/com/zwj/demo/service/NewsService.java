/**
 * Filename:    NewsService
 * Author:      zzz123
 * Date:        2022/3/21 15:12
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwj.demo.entity.News;
import com.zwj.demo.entity.User;

import java.util.List;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/21 
 *@since 1.0.0
 */
public interface NewsService extends IService<News> {

    Page<News> findpage(Page<News> objectPage, String title);

    List<News> findAll(String title);

    IPage<News> findpageByCategoryId(Page<News> page, String title, int categoryId);
}
