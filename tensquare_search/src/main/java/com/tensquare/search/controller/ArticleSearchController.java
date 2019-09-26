package com.tensquare.search.controller;

import com.tensquare.search.service.ArticleSearchService;
import com.tensquare.search.pojo.Article;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping(value = "/{key}/{page}/{size}")
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size){
        Page<Article> pageData = articleSearchService.findByKey(key, page, size);
        return new Result(true, StatusCode.OK,"查询成功", new PageResult<Article>(pageData.getTotalElements(), pageData.getContent()));
    }
}
