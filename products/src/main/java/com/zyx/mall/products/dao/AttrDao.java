package com.zyx.mall.products.dao;

import com.zyx.mall.products.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-10-31 22:01:40
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {

    List<Long> selectSearchAttrIds(@Param("attrIds") List<Long> attrIds);

}
