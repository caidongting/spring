package com.example.spring

import com.example.spring.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class HomeController {

  @Autowired
  lateinit var userService: UserService

  private val logger: Logger = LoggerFactory.getLogger(javaClass)


  @GetMapping("/")
  fun home(): String {
    return "login"
  }

  @RequestMapping("/login")
  fun getLoginCl(@RequestParam("name") name: String,
                 @RequestParam("password") password: String): String {
    val isExist = userService.find(name, password)
    return if (isExist)
      "wel"
    else
      "login"
  }

  @GetMapping("/index")
  fun index(model: Model): String {
    model.addAttribute("name", "world")
    return "home"
  }

  @GetMapping("/{id}")
  fun findById(model: Model, @PathVariable(value = "id") id: Int): String {
    val user = userService.findUser(id)
    logger.info("$user")
    model.addAttribute("name", user?.name)
    return "home"
  }
}