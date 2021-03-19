package com.zyx.mall.search.controller;

import com.zyx.common.exception.BizCode;
import com.zyx.common.to.es.SkuEsModel;
import com.zyx.common.utils.R;
import com.zyx.mall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search/save")
public class ElasticSaveController {

    @Autowired
    ProductSaveService productSaveService;

    // put products onto shelf
    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels)  {
        boolean b = false;
        try {
            b = productSaveService.productStatusUp(skuEsModels);
        } catch (Exception e) {
            log.error("ElasticSaveController product launching error: {}", e);
            return R.error(BizCode.PRODUCT_UP_EXCEPTION.getCode(), BizCode.PRODUCT_UP_EXCEPTION.getMsg());
        }

        if (b) {
            return R.ok();
        } else {
            return R.error(BizCode.PRODUCT_UP_EXCEPTION.getCode(), BizCode.PRODUCT_UP_EXCEPTION.getMsg());
        }
    }

}
