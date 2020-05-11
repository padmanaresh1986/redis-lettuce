package com.padmanaresh.redis.controller;

import com.padmanaresh.redis.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

@RestController
public class RedisBasicOperationsController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="stringRedisTemplate")
    private ValueOperations<String, String> opsForValue;

    @GetMapping("setSimpleData/{key}/{value}")
    public Set<String> setSimpleData(@PathVariable String key , @PathVariable String value){
        opsForValue.set(key,value);
        return stringRedisTemplate.keys("*");
    }

    @PostMapping("setJsonData")
    public Person setJsonData(@RequestBody Person person){
        redisTemplate.opsForValue().set(person.getId(),person);
        return (Person)redisTemplate.opsForValue().get(person.getId());
    }

}
