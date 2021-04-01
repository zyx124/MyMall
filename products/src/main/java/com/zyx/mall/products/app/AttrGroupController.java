package com.zyx.mall.products.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zyx.mall.products.entity.AttrEntity;
import com.zyx.mall.products.service.AttrAttrgroupRelationService;
import com.zyx.mall.products.service.AttrService;
import com.zyx.mall.products.service.CategoryService;
import com.zyx.mall.products.vo.AttrGroupRelationVO;
import com.zyx.mall.products.vo.AttrGroupWithAttrsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zyx.mall.products.entity.AttrGroupEntity;
import com.zyx.mall.products.service.AttrGroupService;
import com.zyx.common.utils.PageUtils;
import com.zyx.common.utils.R;


/**
 * @author yuxinzhao
 * @email zhaoyuxin124@gmail.com
 * @date 2020-11-01 11:12:48
 */
@RestController
@RequestMapping("products/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttrService attrService;

    @Autowired
    AttrAttrgroupRelationService relationService;

    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId) {
        List<AttrEntity> entityList = attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data", entityList);
    }

    @GetMapping("/{attrgroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                            @RequestParam Map<String, Object> params) {
        PageUtils page = attrService.getNoRelationAttr(attrgroupId, params);
        return R.ok().put("data", page);
    }

    @PostMapping("/attr/relation/delete")
    public R deleRelation(@RequestBody AttrGroupRelationVO[] vos) {
        attrService.deleteRelation(vos);
        return R.ok();
    }

    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVO> vos) {
        relationService.saveBatch(vos);
        return R.ok();
    }

    @GetMapping("/{catalogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable("catalogId") Long catalogId ) {
        List<AttrGroupWithAttrsVO> vos = attrGroupService.getAttrGroupWithAttrsByCatalogId(catalogId);

        return R.ok().put("data", vos);
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/list/{catalogId}")
    // @RequiresPermissions("products:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("catalogId") Long catalogId) {
//        PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params, catalogId);
        

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    // @RequiresPermissions("products:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCatelogPath(catelogId);
        attrGroup.setCatelogPath(path);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("products:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("products:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("products:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
