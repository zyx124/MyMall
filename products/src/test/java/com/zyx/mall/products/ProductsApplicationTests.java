package com.zyx.mall.products;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyx.mall.products.entity.BrandEntity;
import com.zyx.mall.products.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsApplicationTests {

	@Autowired
	BrandService brandService;

	@Test
	void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("Apple");
//		brandService.updateById(brandEntity);
//		brandEntity.setName("Apple");
//		brandService.save(brandEntity);
//		System.out.println("Success saving!");

		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		list.forEach(System.out::println);
	}

}
