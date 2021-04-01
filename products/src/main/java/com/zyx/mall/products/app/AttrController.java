package com.zyx.mall.products.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zyx.mall.products.entity.ProductAttrValueEntity;
import com.zyx.mall.products.service.ProductAttrValueService;
import com.zyx.mall.products.vo.AttrRespVO;
import com.zyx.mall.products.vo.AttrVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zyx.mall.products.service.AttrService;
import com.zyx.common.utils.PageUtils;
import com.zyx.common.utils.R;



/**
 * 
 *
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-01 11:12:48
 */
@RestController
@RequestMapping("products/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("/base/listforspu/{spuId}")
    public  R baseAttrListForSpu(@PathVariable("spuId") Long spuId) {
        List<ProductAttrValueEntity> entityList = productAttrValueService.baseAttrListForSpu(spuId);
        return R.ok().put("data", entityList);
    }

    @GetMapping("/{attrType}/list/{catelogId}")
    public  R baseAttrList(@RequestParam Map<String, Object> params,
                           @PathVariable("catelogId") Long catelogId,
                           @PathVariable("attrType") String type) {
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId, type);
        return R.ok().put("page", page);
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("products:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    // @RequiresPermissions("products:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
		AttrRespVO attrRespVO = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", attrRespVO);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("products:attr:save")
    public R save(@RequestBody AttrVO attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("products:attr:update")
    public R update(@RequestBody AttrVO attr){
		attrService.updateAttr(attr);

        return R.ok();
    }


    @PostMapping("/update/{spuId}")
    // @RequiresPermissions("products:attr:update")
    public R updateSpuAttr(@PathVariable("spuId") Long spuId,
                           @RequestBody List<ProductAttrValueEntity> entities){
        productAttrValueService.updateSpuAttr(spuId, entities);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("products:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
