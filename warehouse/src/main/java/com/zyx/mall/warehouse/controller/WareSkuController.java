package com.zyx.mall.warehouse.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zyx.mall.warehouse.vo.SkuHasStockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zyx.mall.warehouse.entity.WareSkuEntity;
import com.zyx.mall.warehouse.service.WareSkuService;
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
@RequestMapping("warehouse/waresku")
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("warehouse:waresku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }

    // check whether out of stock or not
    @PostMapping("/hasstock")
    public R getSkuHasStock(@RequestBody List<Long> skuIds) {
        List<SkuHasStockVO> stockVOS = wareSkuService.getSkuHasStock(skuIds);

        return R.ok().setData(stockVOS);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("warehouse:waresku:info")
    public R info(@PathVariable("id") Long id){
		WareSkuEntity wareSku = wareSkuService.getById(id);

        return R.ok().put("wareSku", wareSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("warehouse:waresku:save")
    public R save(@RequestBody WareSkuEntity wareSku){
		wareSkuService.save(wareSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("warehouse:waresku:update")
    public R update(@RequestBody WareSkuEntity wareSku){
		wareSkuService.updateById(wareSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("warehouse:waresku:delete")
    public R delete(@RequestBody Long[] ids){
		wareSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
