package com.zyx.mall.products.dao;

import com.zyx.mall.products.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-10-31 22:01:40
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {


    void updateCat(@Param("name") String name, @Param("catId") Long catId);
}
