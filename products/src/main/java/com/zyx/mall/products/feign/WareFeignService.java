package com.zyx.mall.products.feign;

import com.zyx.common.to.SkuHasStockVO;
import com.zyx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("warehouse")
public interface WareFeignService {

    @PostMapping("/warehouse/waresku/hasstock")
    R<List<SkuHasStockVO>> getSkuHasStock(@RequestBody List<Long> skuIds);
}
