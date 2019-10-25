package com.example.spring.jpa

import com.example.spring.entity.SpaceEntity
import org.springframework.stereotype.Repository

@Repository
interface SpaceJpa : AbstractRepository<SpaceEntity, Int> {

  fun findBySpaceId(spaceId: Int): SpaceEntity?

}