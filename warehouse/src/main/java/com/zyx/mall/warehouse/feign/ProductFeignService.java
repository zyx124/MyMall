package com.zyx.mall.warehouse.feign;

import com.zyx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("products")
public interface ProductFeignService {

    @RequestMapping("products/spuinfo/info/{id}")
    public R info(@PathVariable("id") Long id);
}
