package com.example.spring.controller

import com.example.spring.TestProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

  @Autowired
  lateinit var properties: TestProperties

  @RequestMapping("/")
  fun hello(): String {
    return "Hello Spring Boot!"
  }

  @RequestMapping("/getUser")
  fun getUser(): String {
    return "name:${properties.name}, age:${properties.age}"
  }
}