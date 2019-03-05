package com.huluwa.springboot.mybatis.service.imp;


import com.huluwa.springboot.mybatis.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImp extends RedisService {

    private static final String Redis_key = "test_redis_key";

    @Override
    protected String getRedisKey() {
        return this.Redis_key;
    }
}
