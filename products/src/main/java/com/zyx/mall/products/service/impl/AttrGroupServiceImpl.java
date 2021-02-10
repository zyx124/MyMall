package com.zyx.mall.products.service.impl;

import com.zyx.mall.products.entity.AttrEntity;
import com.zyx.mall.products.service.AttrService;
import com.zyx.mall.products.vo.AttrGroupWithAttrsVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.common.utils.PageUtils;
import com.zyx.common.utils.Query;

import com.zyx.mall.products.dao.AttrGroupDao;
import com.zyx.mall.products.entity.AttrGroupEntity;
import com.zyx.mall.products.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catalogId) {
        String key = (String) params.get("key");

        QueryWrapper<AttrGroupEntity> attrGroupEntityQueryWrapper = new QueryWrapper<AttrGroupEntity>();

        if (!StringUtils.isEmpty(key)) {
            attrGroupEntityQueryWrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }
        if (catalogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    attrGroupEntityQueryWrapper);
            return new PageUtils(page);
        } else {
            attrGroupEntityQueryWrapper.eq("catelog_id", catalogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    attrGroupEntityQueryWrapper);
            return new PageUtils(page);
        }

    }

    @Override
    public List<AttrGroupWithAttrsVO> getAttrGroupWithAttrsByCatalogId(Long catalogId) {
        // get group info
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catalogId));
        List<AttrGroupWithAttrsVO> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrsVO attrsVO = new AttrGroupWithAttrsVO();
            BeanUtils.copyProperties(group, attrsVO);
            List<AttrEntity> attrs = attrService.getRelationAttr(attrsVO.getAttrGroupId());
            attrsVO.setAttrs(attrs);
            return attrsVO;
        }).collect(Collectors.toList());

        return collect;
    }

}