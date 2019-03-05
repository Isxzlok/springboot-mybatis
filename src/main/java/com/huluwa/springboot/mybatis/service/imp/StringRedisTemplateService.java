package com.huluwa.springboot.mybatis.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class StringRedisTemplateService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存入数据
     * @param key
     * @param value
     */
    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key值得到value
     * @param key
     * @return
     */
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }


    /**
     * 给指定key值进行递增加1操作
     * @param key
     * @param
     */
    public void increment(String key){
        stringRedisTemplate.boundValueOps(key).increment(1);
    }

    /**
     * 获取一个键值得过期时间
     * @param key
     * @return
     */
    public long expire(String key){
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * 根据key获取过期时间并转换成指定单位
     * @param key
     * @return
     */
    public long expire1(String key){
        return stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 根据指定key值删除缓存
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 检查key是否存在，返回boolean值
     * @param key
     * @return
     */
    public boolean isKeyExist(String key){
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 向指定key中添加一个set集合
     * @param key
     * @param value
     */
    public void add_set(String key, String... value){
        stringRedisTemplate.opsForSet().add(key, value);
    }

    /**
     * 根据指定key值获取set集合
     * @param key
     * @return
     */
    public Set<String> get_set(String key){
        return stringRedisTemplate.opsForSet().members(key);
    }
}
