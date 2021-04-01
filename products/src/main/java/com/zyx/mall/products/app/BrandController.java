package com.zyx.mall.products.app;

import java.util.Arrays;
import java.util.Map;


import com.zyx.common.valid.AddGroup;
import com.zyx.common.valid.UpdateGroup;
import com.zyx.common.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyx.mall.products.entity.BrandEntity;
import com.zyx.mall.products.service.BrandService;
import com.zyx.common.utils.PageUtils;
import com.zyx.common.utils.R;


/**
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-01 11:12:48
 */
@RestController
@RequestMapping("products/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("products:brand:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    // @RequiresPermissions("products:brand:info")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("products:brand:save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand /*, BindingResult result*/) {
//        if (result.hasErrors()) {
//            Map<String, String> map = new HashMap<>();
//            result.getFieldErrors().forEach((item)->{
//                String message = item.getDefaultMessage();
//                String field = item.getField();
//                map.put(field, message);
//            });
//
//            return R.error(400, "not valid data").put("data", map);
//        } else {
//
//        }
        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("products:brand:update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Not Valid");
        } else {
            brandService.updateDetail(brand);
        }
        return R.ok();
    }

    @RequestMapping("/update/status")
    // @RequiresPermissions("products:brand:update")
    public R updateStatus(@Validated({UpdateStatusGroup.class}) @RequestBody BrandEntity brand, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Status Not Valid");
        } else {
            brandService.updateById(brand);
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("products:brand:delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
