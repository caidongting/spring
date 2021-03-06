package com.example.spring.jpa

import com.example.spring.entity.UserEntity
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserJpa : AbstractRepository<UserEntity, Int>, UserJpaPlus {

  /**
   * 使用Query方式
   */
  //  @Query(value = "select u from UserEntity u  where u.name = :name and u.password = :password")
  @Query(value = "from UserEntity u  where u.name = :name and u.password = :password")
  //  fun find(@Param("name") nm: String, @Param("password") pwd: String): UserEntity?
  // 当jpql中的参数与方法中的参数命名一致@param可以省略，@param主要用于别名
  fun find(name: String, password: String): UserEntity?

  /**
   * 使用NameQuery方式
   */
  fun getX(id: Int): UserEntity?

  /**
   * 使用spring data jpa命名规则自动解析生成sql
   */
  fun readById(id: Int): UserEntity?

  fun getById(id: Int): UserEntity?

  fun countById(id: Int): Int

  fun findByNameAndPassword(name: String, password: String): UserEntity?

  fun existsByNameAndPassword(name: String, password: String): Boolean
}


interface UserJpaPlus {
  fun myFun()
}

// 此方式可以正确运行，然而使用价值不高，不推荐使用
class UserJpaPlusImpl : UserJpaPlus {

  private val logger = LoggerFactory.getLogger(javaClass)

  override fun myFun() {
    logger.info("this method can work!")
  }
}