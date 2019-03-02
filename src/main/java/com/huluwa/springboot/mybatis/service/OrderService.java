package com.huluwa.springboot.mybatis.service;

import com.huluwa.springboot.mybatis.domain.Orders;
import com.huluwa.springboot.mybatis.domain.OrdersCustom;
import com.huluwa.springboot.mybatis.domain.User;

import java.util.List;

public interface OrderService {

    //查询订单并关联查询用户信息
    public List<OrdersCustom> findOrdersAndUser();

    public List<Orders> findOrdersAndUser1();

    public List<Orders> findOrdersAndUserAndOrderdetail();

    //查询用户购买商品信息
    public List<User> findUserAndItems();
}
