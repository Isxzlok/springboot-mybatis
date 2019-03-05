package com.huluwa.springboot.mybatis.service.imp;

import com.alibaba.druid.support.json.JSONUtils;
import com.huluwa.springboot.mybatis.domain.User;
import com.huluwa.springboot.mybatis.domain.UserExample;
import com.huluwa.springboot.mybatis.mapper.UserMapper;
import com.huluwa.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;




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
//整合redis添加用户
    @Override
    public void addUser(User user) {
        int i = userMapper.insert(user);
        if (i > 0){
            stringRedisTemplate.opsForValue().set("1", user.getUsername());
        }
    }
}
