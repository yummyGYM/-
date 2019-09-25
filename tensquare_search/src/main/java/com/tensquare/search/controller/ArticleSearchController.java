package com.tensquare.search.controller;

import com.tensquare.search.service.ArticleSearchService;
import com.tensquare.search.pojo.Article;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/25 15:00
 * @Modified By：
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    @PostMapping
    public Result save(@RequestBody Article article){
        articleSearchService.save(article);
        return new Result(true, StatusCode.OK,"操作成功");
    }
}
