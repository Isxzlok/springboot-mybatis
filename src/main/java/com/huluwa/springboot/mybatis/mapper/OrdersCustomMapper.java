package com.huluwa.springboot.mybatis.mapper;

import com.huluwa.springboot.mybatis.domain.Orders;
import com.huluwa.springboot.mybatis.domain.OrdersCustom;
import com.huluwa.springboot.mybatis.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersCustomMapper {

    public List<OrdersCustom> findOrdersAndUser();
    public List<Orders> findOrdersAndUser1();
    public List<Orders> findOrdersAndUserAndOrderDetail();
    public List<User> findUserAndItems();
}
