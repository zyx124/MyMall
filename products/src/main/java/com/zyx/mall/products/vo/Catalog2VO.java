package com.zyx.mall.products.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Catalog2VO {
    private String catalogId;
    private List<Catalog3VO> catalog3List;
    private String id;
    private String name;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Catalog3VO {
        private String catalog2Id; // second category
        private String id;
        private String name;
    }

}
