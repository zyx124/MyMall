package com.zyx.mall.warehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.common.utils.PageUtils;
import com.zyx.mall.warehouse.entity.PurchaseEntity;
import com.zyx.mall.warehouse.vo.MergeVO;
import com.zyx.mall.warehouse.vo.PurchaseDoneVO;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 22:18:17
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceive(Map<String, Object> params);

    void mergePurchase(MergeVO mergeVO);

    void received(List<Long> ids);

    void finish(PurchaseDoneVO doneVO);

}

