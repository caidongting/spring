package com.example.spring.entity

import com.example.spring.annotation.NoArg
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "users")
@NamedQueries(
    NamedQuery(name = "UserEntity.getX", query = "from UserEntity where id =:id"),
    NamedQuery(name = "UserEntity.findX", query = "delete from UserEntity where id =:id")
)
data class UserEntity(
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
data class PlayerEntity(
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String
)

@NoArg
data class SpaceEntityPK(
    @Id
    @Column(name = "user_id")
    val userId: Int,

    @Id
    @Column(name = "space_id")
    val spaceId: Int
) : Serializable

@Entity
@IdClass(SpaceEntityPK::class)
@Table(name = "space")
data class SpaceEntity(

    @Id
    @Column(name = "user_id")
    val userId: Int,

    @Id
    @Column(name = "space_id")
    val spaceId: Int,

    @Column(name = "context", columnDefinition = "blob")
    val context: ByteArray?
) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is SpaceEntity) return false

    if (userId != other.userId) return false
    if (spaceId != other.spaceId) return false
    if (context != null) {
      if (other.context == null) return false
      if (!context.contentEquals(other.context)) return false
    } else if (other.context != null) return false

    return true
  }

  override fun hashCode(): Int {
    var result = userId
    result = 31 * result + spaceId
    result = 31 * result + (context?.contentHashCode() ?: 0)
    return result
  }

}