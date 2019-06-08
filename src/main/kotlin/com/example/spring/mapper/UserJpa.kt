package com.example.spring.mapper

import com.example.spring.entity.User
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserJpa : AbstractRepository<User, Int>, JpaSpecificationExecutor<User> {

  @Query(value = "select u from User u  where u.name = :name and u.password = :password")
  fun find(@Param("name") name: String, @Param("password") password: String): User?

}

//interface AbstractDao2<T, ID>
//
//abstract class AbstractDaoImpl<T, ID> : AbstractDao2<T, ID>, HibernateDaoSupport() {
//
//  fun getSession(): Session = sessionFactory.currentSession
//}
//
//interface XDao : AbstractDao2<User, Int> {
//
//  fun getX(): User
//}
//
//@Repository
//class XDaoImpl : AbstractDaoImpl<User, Int>(), XDao {
//
//  override fun getX(): User {
//    return getSession().getNamedQuery("getX").setParameter("id", 1).uniqueResult() as User
//  }
//}