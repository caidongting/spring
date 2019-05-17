package com.example.spring.service

import com.example.spring.entity.User
import com.example.spring.mapper.UserDao
import com.example.spring.mapper.UserJpa
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

interface UserService {

  fun findUser(id: Int): User?

  fun find(name: String, password: String): Boolean
}

@Primary
@Service
open class UserServiceImpl : UserService {

  @Autowired
  lateinit var userJpa: UserJpa

  @Transactional(readOnly = true, isolation = Isolation.DEFAULT)
  override fun findUser(id: Int): User? {
    return userJpa.findById(id).orElse(null)
  }

  @Transactional(readOnly = true)
  override fun find(name: String, password: String): Boolean {
    val user = userJpa.find(name, password)
    return user != null
  }
}

@Qualifier
@Service
open class UserServiceImpl2 : UserService {

  @Autowired
  lateinit var userDao: UserDao

  @Transactional(readOnly = true, isolation = Isolation.DEFAULT)
  override fun findUser(id: Int): User? {
    return userDao.findById(id)
  }

  @Transactional(readOnly = true)
  override fun find(name: String, password: String): Boolean {
    val user = userDao.find(name, password)
    return user != null
  }
}