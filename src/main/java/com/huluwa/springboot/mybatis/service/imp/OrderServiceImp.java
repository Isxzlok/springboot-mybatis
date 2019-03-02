package com.huluwa.springboot.mybatis.service.imp;

import com.huluwa.springboot.mybatis.domain.Orders;
import com.huluwa.springboot.mybatis.domain.OrdersCustom;
import com.huluwa.springboot.mybatis.domain.User;
import com.huluwa.springboot.mybatis.mapper.OrdersCustomMapper;
import com.huluwa.springboot.mybatis.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrdersCustomMapper ordersCustomMapper;

    @Override
    public List<OrdersCustom> findOrdersAndUser() {


        List<OrdersCustom> list = ordersCustomMapper.findOrdersAndUser();
        return list;


    }

    @Override
    public List<Orders> findOrdersAndUser1() {
        List<Orders> list = ordersCustomMapper.findOrdersAndUser1();
        return list;
    }

    @Override
    public List<Orders> findOrdersAndUserAndOrderdetail() {
        return ordersCustomMapper.findOrdersAndUserAndOrderDetail();
    }

    @Override
    public List<User> findUserAndItems() {
        return ordersCustomMapper.findUserAndItems();    }


}
