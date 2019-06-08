package com.example.spring.entity

import javax.persistence.*

@Entity
@Table(name = "users")
@NamedQueries(
   NamedQuery(name = "getX", query = "from User where id =:id"),
   NamedQuery(name = "findX", query = "delete from User where id =:id")
)
data class User(
   @Id
   @Column(name = "id")
   val id: Int,
   @Column(name = "name")
   val name: String,
   @Column(name = "password")
   val password: String
)

@Entity
@Table(name = "player")
data class Player(
   @Id
   @Column(name = "id")
   val id: Int,
   @Column(name = "name")
   val name: String
)