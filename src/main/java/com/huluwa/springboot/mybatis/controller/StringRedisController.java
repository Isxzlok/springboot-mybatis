package com.huluwa.springboot.mybatis.controller;

import com.huluwa.springboot.mybatis.service.imp.StringRedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("StringRedis")
public class StringRedisController {

    @Autowired
    private StringRedisTemplateService stringRedisTemplateService;

    @RequestMapping("/set")
    @ResponseBody
    public void set(){
        stringRedisTemplateService.set("num", "5");
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return stringRedisTemplateService.get("num");
    }

    @RequestMapping("/increment")
    @ResponseBody
    public void increment(){
         stringRedisTemplateService.increment("num");
    }

    @RequestMapping("/expire")
    @ResponseBody
    public Object expire(){
        return stringRedisTemplateService.expire("num");
    }

    @RequestMapping("/expire1")
    @ResponseBody
    public Object expire1(){
        return stringRedisTemplateService.expire1("num");
    }

    @RequestMapping("/del")
    @ResponseBody
    public void del(){
         stringRedisTemplateService.del("num");
    }

    @RequestMapping("/exist")
    @ResponseBody
    public boolean exist(){
        return stringRedisTemplateService.isKeyExist("name");
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(){
         stringRedisTemplateService.add_set("set1","1","2","3");
    }

    @RequestMapping("/get1")
    @ResponseBody
    public Set<String> get1(){
        return stringRedisTemplateService.get_set("set1");
    }
}
