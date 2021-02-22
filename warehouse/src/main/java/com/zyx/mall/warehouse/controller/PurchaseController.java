package com.zyx.mall.warehouse.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.zyx.mall.warehouse.vo.MergeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zyx.mall.warehouse.entity.PurchaseEntity;
import com.zyx.mall.warehouse.service.PurchaseService;
import com.zyx.common.utils.PageUtils;
import com.zyx.common.utils.R;



/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-02 22:18:17
 */
@RestController
@RequestMapping("warehouse/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/merge")
    // @RequiresPermissions("warehouse:purchase:list")
    public R merge(@RequestBody MergeVO mergeVO){

        purchaseService.mergePurchase(mergeVO);

        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/unreceive/list")
    // @RequiresPermissions("warehouse:purchase:list")
    public R unreceiveList(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnreceive(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list")
    // @RequiresPermissions("warehouse:purchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("warehouse:purchase:info")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("warehouse:purchase:save")
    public R save(@RequestBody PurchaseEntity purchase){
        purchase.setUpdateTime(new Date());
        purchase.setCreateTime(new Date());
		purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("warehouse:purchase:update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("warehouse:purchase:delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
