package me.lm.elasticsearch;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;

/**
 * Created by blue_ann on 15/03/2019.
 */
public class ElasticSearch {
    @Test
    public void test() {


        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.filter(QueryBuilders.termQuery("a", 1));
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("status").gte(1).lt(1));
        System.out.println(boolQueryBuilder.toString());
    }
}
