package com.zyx.mall.products.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.zyx.mall.products.entity.AttrEntity;
import lombok.Data;

import java.util.List;

@Data
public class AttrGroupWithAttrsVO {

    private Long attrGroupId;
    /**
     *
     */
    private String attrGroupName;
    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private String descript;
    /**
     *
     */
    private String icon;
    /**
     *
     */

    private Long catelogId;

    private List<AttrEntity> attrs;
}
