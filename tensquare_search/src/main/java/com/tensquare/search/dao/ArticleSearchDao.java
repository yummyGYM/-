package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/25 14:58
 * @Modified By：
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {
}
