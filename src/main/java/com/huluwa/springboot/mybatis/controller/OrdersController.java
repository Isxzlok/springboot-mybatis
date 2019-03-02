package com.huluwa.springboot.mybatis.controller;


import com.huluwa.springboot.mybatis.domain.Orders;
import com.huluwa.springboot.mybatis.domain.OrdersCustom;
import com.huluwa.springboot.mybatis.domain.User;
import com.huluwa.springboot.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/select")
    public List<OrdersCustom> select(){
        return orderService.findOrdersAndUser();
    }

    @RequestMapping("/select1")
    public List<Orders> select1(){
        return orderService.findOrdersAndUser1();
    }

    @RequestMapping("/select2")
    public List<Orders> select2(){
        return orderService.findOrdersAndUserAndOrderdetail();
    }

    @RequestMapping("/select3")
    public List<User> select3(){
        return orderService.findUserAndItems();
    }
}
