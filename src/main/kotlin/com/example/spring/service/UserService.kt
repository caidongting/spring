package com.example.spring.service

import com.example.spring.entity.UserEntity
import com.example.spring.jpa.UserJpa
import com.example.spring.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

interface UserService {

  fun findUser(id: Int): UserEntity?

  fun find(name: String, password: String): Boolean
}

@Primary
@Service
open class UserServiceImpl : UserService {

  @Autowired
  lateinit var userJpa: UserJpa

  @Transactional(readOnly = true, isolation = Isolation.DEFAULT)
  override fun findUser(id: Int): UserEntity? {
    userJpa.myFun()
    // return userJpa.getX(id)
    // val user = SpaceEntityPK::class.java.newInstance()
    return userJpa.findByIdOrNull(id)
  }

  @Transactional(readOnly = true)
  override fun find(name: String, password: String): Boolean {
    userJpa.existsByNameAndPassword(name, password)
    val user = userJpa.findByNameAndPassword(name, password)
    return user != null
  }
}

// @Primary
@Service
open class UserServiceImpl2 : UserService {

  // @Autowired
  @Resource
  lateinit var userMapper: UserMapper

  @Transactional(readOnly = true, isolation = Isolation.DEFAULT)
  override fun findUser(id: Int): UserEntity? {
    return userMapper.findById(id)
  }

  @Transactional(readOnly = true)
  override fun find(name: String, password: String): Boolean {
    val user = userMapper.find(name, password)
    return user != null
  }
}