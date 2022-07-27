/**
 * Filename:    NewsServiceImpl
 * Author:      zzz123
 * Date:        2022/3/21 15:13
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwj.demo.entity.News;
import com.zwj.demo.entity.User;
import com.zwj.demo.mapper.NewsMapper;
import com.zwj.demo.mapper.UserMapper;
import com.zwj.demo.service.NewsService;
import com.zwj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/21
 * @since 1.0.0
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public Page<News> findpage(Page<News> page, String title) {
        return newsMapper.findPage(page,title);
    }

    public List<News> findAll(String title) {
        return newsMapper.findAll(title);
    }

    @Override
    public IPage<News> findpageByCategoryId(Page<News> page, String title, int categoryId) {
        return newsMapper.findPageByCategoryId(page,title,categoryId);
    }
}
