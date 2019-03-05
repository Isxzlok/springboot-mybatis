package com.huluwa.springboot.mybatis.controller;

import com.huluwa.springboot.mybatis.domain.RedisModle;
import com.huluwa.springboot.mybatis.service.imp.RedisServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisServiceImp redisService; //注入redisService

    //添加
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public void test() {
        System.out.println("start.....");
        RedisModle m = new RedisModle();
        m.setName("张三");
        m.setTel("1111");
        m.setAddress("深圳1");
        m.setRedisKey("zhangsanKey01");
        redisService.put(m.getRedisKey(), m, -1);

        RedisModle m2 = new RedisModle();
        m2.setName("张三2");
        m2.setTel("2222");
        m2.setAddress("深圳2");
        m2.setRedisKey("zhangsanKey02");
        redisService.put(m2.getRedisKey(), m2, -1);

        RedisModle m3 = new RedisModle();
        m3.setName("张三3");
        m3.setTel("2222");
        m3.setAddress("深圳2");
        m3.setRedisKey("zhangsanKey03");
        redisService.put(m3.getRedisKey(), m3, -1);

        System.out.println("add success end...");
    }


    //查询所有对象
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getAll() {
        return redisService.getAll();
    }


    //查询所有key
    @RequestMapping("/getKeys")
    @ResponseBody
    public Object getKeys(){
        return redisService.getKeys();
    }

    //删除指定key的值
    @RequestMapping("/delKey")
    @ResponseBody
    public void delKey(){
        redisService.remove("zhangsanKey03");
    }

    //判断key是否存在redis中
    @RequestMapping("/isExistKey")
    @ResponseBody
    public boolean isExistKey(){
        return redisService.isKeyExists("zhangsanKey03");
    }

    //查询当前key下的缓存状态
    @RequestMapping("/count")
    @ResponseBody
    public long count(){
        return redisService.count();
    }


}
