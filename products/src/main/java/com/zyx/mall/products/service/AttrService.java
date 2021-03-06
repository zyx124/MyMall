package com.zyx.mall.products.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.common.utils.PageUtils;
import com.zyx.mall.products.entity.AttrEntity;
import com.zyx.mall.products.vo.AttrGroupRelationVO;
import com.zyx.mall.products.vo.AttrRespVO;
import com.zyx.mall.products.vo.AttrVO;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-10-31 22:01:40
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVO attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVO getAttrInfo(Long attrId);

    void updateAttr(AttrVO attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);


    void deleteRelation(AttrGroupRelationVO[] vos);

    PageUtils getNoRelationAttr(Long attrgroupId, Map<String, Object> params);

    List<Long> selectSearchAttrIds(List<Long> attrIds);
}

