package com.huluwa.springboot.mybatis.service.imp;

import com.huluwa.springboot.mybatis.domain.User;
import com.huluwa.springboot.mybatis.domain.UserExample;
import com.huluwa.springboot.mybatis.mapper.UserMapper;
import com.huluwa.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void add(User user) {
        userMapper.insertSelective(user);

    }

    @Override
    public void delete(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        userMapper.deleteByExample(userExample);

    }

    @Override
    public void update(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(22);
        userMapper.updateByExampleSelective(user, userExample);

    }

    @Override
    public List<User> select(int id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
       return userMapper.selectByExample(userExample);

    }
}
