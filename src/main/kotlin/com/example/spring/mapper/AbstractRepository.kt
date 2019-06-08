package com.example.spring.mapper

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractRepository<T, ID> : JpaRepository<T, ID>