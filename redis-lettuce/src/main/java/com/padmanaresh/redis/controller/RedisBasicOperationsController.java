package com.padmanaresh.redis.controller;

import com.padmanaresh.redis.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class RedisBasicOperationsController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="stringRedisTemplate")
    private ValueOperations<String, String> opsForValue;

    /**
     * Input
     * setSimpleData/key1/value1
     *
     * @param key
     * @param value
     * @return
     */
    @GetMapping("set/{key}/{value}")
    public Set<String> setSimpleData(@PathVariable String key , @PathVariable String value){
        opsForValue.set(key,value);
        return stringRedisTemplate.keys("*");
    }

    /**
     * Input
     * {"id":"123","name":"padma naresh","gender":"Male","age":32}
     * @param person
     * @return
     */
    @PostMapping("setJson")
    public Person setJson(@RequestBody Person person){
        redisTemplate.opsForValue().set(person.getId(),person);
        return (Person)redisTemplate.opsForValue().get(person.getId());
    }

    /**
     * Input
     * [{"id":"123","name":"padma naresh","gender":"Male","age":32}
     * ,{"id":"124","name":"Punyasloka","gender":"Male","age":27}
     * ]
     *
     * @param person
     * @return
     */
    @PostMapping("multiSet")
    public List<Person> multiSet(@RequestBody List<Person> person){
        Map<String, Person> multipleData = person.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        List<String> multiKeys = person.stream().map(Person::getId).collect(Collectors.toList());
        redisTemplate.opsForValue().multiSet(multipleData);
        return (List<Person>)redisTemplate.opsForValue().multiGet(multiKeys);
    }


}
