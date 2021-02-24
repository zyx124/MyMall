package com.zyx.mall.warehouse.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PurchaseDoneVO {
    @NotNull
    private Long id;

    private List<PurchaseItemDoneVO> items;

}
