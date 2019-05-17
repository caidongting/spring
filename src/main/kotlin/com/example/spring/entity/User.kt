package com.example.spring.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
   @Id
   @Column(name = "id")
   val id: Int,
   @Column(name = "name")
   val name: String,
   @Column(name = "password")
   val password: String
)