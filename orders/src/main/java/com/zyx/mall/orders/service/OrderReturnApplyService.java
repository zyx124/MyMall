package com.zyx.mall.orders.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.common.utils.PageUtils;
import com.zyx.mall.orders.entity.OrderReturnApplyEntity;

import java.util.Map;

/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 22:13:29
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

