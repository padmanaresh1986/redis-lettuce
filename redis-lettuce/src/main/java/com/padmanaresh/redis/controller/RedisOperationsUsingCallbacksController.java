package com.padmanaresh.redis.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisOperationsUsingCallbacksController {

    /*
    redisTemplate.execute(new RedisCallback<Object>() {
    public Object doInRedis(RedisConnection connection) throws DataAccessException {
      Long size = connection.dbSize();
      // Can cast to StringRedisConnection if using a StringRedisTemplate
      ((StringRedisConnection)connection).set("key", "value");
    }
   });
     */

}
