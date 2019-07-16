package com.example.spring.jpa

import com.example.spring.entity.Space
import org.springframework.stereotype.Repository

@Repository
interface SpaceJpa : AbstractRepository<Space, Int> {

  fun findBySpaceId(spaceId: Int): Space?

}