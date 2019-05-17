package com.example.spring.mapper

import com.example.spring.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface UserJpa : JpaRepository<User, Int>, JpaSpecificationExecutor<User> {

  @Query(value = "select t from User t  where t.name = :name and t.password = :password")
  fun find(@Param("name") name: String, @Param("password") password: String): User?

}