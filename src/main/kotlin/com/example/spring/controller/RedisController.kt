package com.example.spring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class RedisController {


  @Autowired
  private lateinit var stringRedisTemplate: StringRedisTemplate

  @Autowired
  private lateinit var redisTemplate: RedisTemplate<String, Any>

  @RequestMapping("redis/get")
  fun get(): String {
    stringRedisTemplate.opsForValue().set("caidt", "hello world")
    return stringRedisTemplate.opsForValue()["caidt"].orEmpty()
  }

  @RequestMapping("redis/get2")
  fun get2(): Any? {
    redisTemplate.opsForValue().set("caidt", "hello world2")
    return redisTemplate.opsForValue()["caidt"]
  }

}