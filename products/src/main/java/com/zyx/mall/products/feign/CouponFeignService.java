package com.zyx.mall.products.feign;


import com.zyx.common.to.SkuReductionTO;
import com.zyx.common.to.SpuBoundTO;
import com.zyx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("coupons")
public interface CouponFeignService {

    @PostMapping("coupons/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTO spuBoundTO);

    @PostMapping("coupons/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTO skuReductionTO);

}
