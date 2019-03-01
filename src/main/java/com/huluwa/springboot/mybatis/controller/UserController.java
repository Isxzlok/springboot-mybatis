package com.huluwa.springboot.mybatis.controller;

import com.huluwa.springboot.mybatis.domain.User;
import com.huluwa.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //增加用户信息
    @GetMapping("/add")
    public String addUser(){
        try {
            User user = new User();
            user.setUsername("熊志龙");
            user.setAddress("抚州");
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-01"));
            user.setSex("男");
            userService.add(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    //根据用户名删除用户信息
    @GetMapping("delete")
    public String deleteUser(){
        userService.delete("张三丰");
        return "delete success";
    }

    //修改用户信息
    @GetMapping("/update")
    public String update(){
        try {
            User user = new User();
            user.setUsername("熊");
            user.setAddress("抚州");
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-01"));
            user.setSex("男");
            userService.update(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    //查询用户
    @GetMapping("/select")
    public List<User> select(){
        return userService.select(32);
    }

}
