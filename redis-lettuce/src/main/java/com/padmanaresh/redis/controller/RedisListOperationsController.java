package com.padmanaresh.redis.controller;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class RedisListOperationsController {

    // inject the template as ListOperations
    @Resource(name="stringRedisTemplate")
    private ListOperations<String, String> listOps;
    // listOps.leftPush(userId, url.toExternalForm());

}
