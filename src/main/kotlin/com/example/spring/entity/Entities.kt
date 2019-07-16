package com.example.spring.entity

import javax.persistence.*

@Entity
@Table(name = "users")
@NamedQueries(
    NamedQuery(name = "User.getX", query = "from User where id =:id"),
    NamedQuery(name = "User.findX", query = "delete from User where id =:id")
)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

@Entity
@Table(name = "space")
data class Space(

    @Id
    @Column(name = "user_id")
    val userId: Int,

    @Column(name = "space_id")
    val spaceId: Int,

    @Column(name = "context", columnDefinition = "blob")
    val context: ByteArray
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Space) return false

    if (userId != other.userId) return false
    if (spaceId != other.spaceId) return false
    if (!context.contentEquals(other.context)) return false

    return true
  }

  override fun hashCode(): Int {
    var result = userId
    result = 31 * result + spaceId
    result = 31 * result + context.contentHashCode()
    return result
  }


}