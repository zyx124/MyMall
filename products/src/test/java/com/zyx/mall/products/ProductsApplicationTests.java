package com.zyx.mall.products;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyx.mall.products.entity.BrandEntity;
import com.zyx.mall.products.service.BrandService;
import com.zyx.mall.products.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsApplicationTests {

	@Autowired
	BrandService brandService;

	@Autowired
	OSSClient ossClient;

	@Autowired
	CategoryService categoryService;

	@Test
	public void testFindPath() {
		Long[] catelogPath = categoryService.findCatelogPath(225L);
		log.info("Full path: {}", Arrays.asList(catelogPath));
	}


	@Test
	public void upload() throws FileNotFoundException {
//		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
//// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。

//
//// 创建OSSClient实例。
//		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
		InputStream inputStream = new FileInputStream("/home/zyx/Nutstore/Nutstore/pig.jpg");
		ossClient.putObject("mymall-zyx", "pig.jpg", inputStream);

// 关闭OSSClient。
		ossClient.shutdown();

		System.out.println("Success upload!");
	}

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
