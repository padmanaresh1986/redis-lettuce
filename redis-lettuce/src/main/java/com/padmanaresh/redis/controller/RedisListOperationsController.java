package com.padmanaresh.redis.controller;

import com.padmanaresh.redis.data.Person;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class RedisListOperationsController {
    // inject the template as ListOperations
    @Resource(name="redisTemplate")
    private ListOperations<Object, Object> listOps;
    // listOps.leftPush(userId, url.toExternalForm());

    /**
     * Input
     * [{"id":"123","name":"padma naresh","gender":"Male","age":32}
     * ,{"id":"124","name":"Punyasloka","gender":"Male","age":27}
     * ]
     *
     * @param
     * @return
     */
    @PostMapping("leftPush/{key}")
    public List<Object> leftPush(@PathVariable String key,  @RequestBody List<Person> persons){
        persons.forEach( person -> {
            listOps.leftPush(key,person);
        });
       return  listOps.range(key, 0, -1);
    }

    /**
     * Input
     * [{"id":"0","name":"John Doe","gender":"Male","age":11},
     *  {"id":"1","name":"John Doe1","gender":"Male","age":12},
     *  {"id":"2","name":"John Doe2","gender":"Male","age":13}]
     *
     * @param
     * @return
     */
    @PostMapping("leftPushAll/{key}")
    public List<Object> leftPushAll(@PathVariable String key,  @RequestBody List<Person> persons){
        listOps.leftPushAll(key,persons);
        return  listOps.range(key, 0, -1);
    }


    /**
     * Input
     * @param
     * @return
     */
    @GetMapping("rightPop/{key}")
    public Object rightPopAndLeftPush(@PathVariable String key){
        return  listOps.rightPop(key);
    }
}
