package com.example.spring.mapper

import com.example.spring.entity.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

interface AbstractDao {

}

@Mapper
@Repository
interface UserDao : AbstractDao {
  @Select("SELECT * FROM users where id = #{id}")
  @Results(
     Result(property = "id", column = "id"),
     Result(property = "name", column = "name"),
     Result(property = "password", column = "password")
  )
  fun findById(@Param("id") id: Int): User?

  @Select("SELECT * FROM users where name = #{name} AND password = #{password}")
  /**
   * 当字段满足下划线转驼峰命名法时，[@Results]可以省略
   * @Results(
      Result(property = "id", column = "id"),
      Result(property = "name", column = "name"),
      Result(property = "password", column = "password")
      )
   */
  fun find(@Param("name") name: String, @Param("password") password: String): User?
}