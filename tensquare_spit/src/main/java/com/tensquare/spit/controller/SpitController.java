package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/23 15:50
 * @Modified By：
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    @GetMapping(value="/{spitId}")
    public Result findById(@PathVariable String spitId){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(spitId));
    }

    @PostMapping
    public Result add(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @PutMapping(value="/{id}")
    public Result update(@RequestBody Spit spit, @PathVariable String id ){
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value="/{id}")
    public Result delete(@PathVariable String id ){
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @GetMapping(value = "/comment/{parentid}/{page}/{size}")
    public Result findByParentid(@PathVariable String parentid, @PathVariable int page, @PathVariable int size){
        Page<Spit> pageDate = spitService.findByParentid(parentid, page, size);
        return new Result(true,StatusCode.OK,"查询成功", new PageResult<Spit>(pageDate.getTotalElements(), pageDate.getContent()));
    }

    @PutMapping(value = "/thumbup/{spitId}")
    public Result thumbup(@PathVariable String spitId){
        //判断当前用户是否已经点赞，先把userid先写死
        String userid = "111";
        //判断当前用户是否已经点赞
        if(redisTemplate.opsForValue().get("thumbup_" + userid)!=null){
            return new Result(true,StatusCode.OK,"不能重复点赞");
        }
        redisTemplate.opsForValue().set("thumbup_" + userid, 1);
        spitService.thumbup(spitId);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

}
