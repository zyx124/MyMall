package com.zyx.mall.search;

import com.alibaba.fastjson.JSON;
import com.zyx.mall.search.config.ElasticSearchConfig;
import lombok.Data;
import net.minidev.json.JSONArray;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
class SearchApplicationTests {

    @Qualifier("esRestClient")
    @Autowired
    private RestHighLevelClient client;

    @Test
    void contextLoads() {
        System.out.println(client);
    }

    /**
     * test storing data into es
     */
    @Test
    void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        // indexRequest.source("userName", "ricky", "age", 18, "gender", "male");
        User user = new User();
        user.setAge(19);
        user.setGender("male");
        user.setUserName("Ricky");
        String s = JSON.toJSONString(user);
        indexRequest.source(s, XContentType.JSON);

        // execution
        IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);

        // get the response data
        System.out.println(index);


    }

    @Data
    class User {
        private String userName;
        private String gender;
        private Integer age;
    }

}
