package com.huluwa.springboot.mybatis.service;


import com.huluwa.springboot.mybatis.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public void add(User user);

    public void delete(String name);

    public void update(User user);

    public List<User> select(int id);

    //整合redis添加用户
    public void addUser(User user);
}
