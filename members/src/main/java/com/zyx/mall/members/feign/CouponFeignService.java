package com.zyx.mall.members.feign;

import com.zyx.common.utils.R;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("coupons")
public interface CouponFeignService {

    @RequestMapping("coupons/coupon/member/list")
    public R memberCoupons();
}
