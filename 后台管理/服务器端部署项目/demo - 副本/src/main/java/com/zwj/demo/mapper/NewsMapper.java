package com.zwj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwj.demo.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface NewsMapper extends BaseMapper<News> {
    Page<News> findPage(Page<News> page, @Param("title") String title);

    List<News> findAll(@Param("title")String title);

    IPage<News> findPageByCategoryId(Page<News> page, String title, int categoryId);
}
