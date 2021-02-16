package com.zyx.mall.coupons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.common.to.SkuReductionTO;
import com.zyx.common.utils.PageUtils;
import com.zyx.mall.coupons.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 21:23:29
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTO skuReductionTO);

}

