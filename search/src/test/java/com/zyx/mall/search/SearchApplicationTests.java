package com.zyx.mall.search;

import com.alibaba.fastjson.JSON;
import com.zyx.mall.search.config.ElasticSearchConfig;
import lombok.Data;
import net.minidev.json.JSONArray;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.directory.SearchResult;
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

    @Test
    void searchData() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // 1. build the search conditions
        builder.query(QueryBuilders.matchQuery("address", "mill"));

        // 2. Aggregate with age
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        builder.aggregation(ageAgg);

        // 3. calculate avg salary
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        builder.aggregation(balanceAvg);

        System.out.println("search conditions: " + builder.toString());

        searchRequest.source(builder);

        // execute
        SearchResponse searchResponse = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);

        // analyse the result
        System.out.println(searchResponse.toString());
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit: searchHits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);

        }


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
