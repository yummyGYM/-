package com.tensquare.base.controller;

import entity.Result;
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

    @GetMapping("")
    public Result findAll(){
        return new Result();
    }

}
