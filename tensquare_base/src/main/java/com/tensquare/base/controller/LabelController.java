package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/11 10:58
 * @Modified By：
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true, StatusCode.OK, "查询成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId){
        return new Result(true, StatusCode.OK, "删除成功");
    }


}
