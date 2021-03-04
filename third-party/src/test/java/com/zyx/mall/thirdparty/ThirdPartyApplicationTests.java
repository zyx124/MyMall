package com.zyx.mall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsApplicationTests {

    @Autowired
    OSSClient ossClient;

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

}
