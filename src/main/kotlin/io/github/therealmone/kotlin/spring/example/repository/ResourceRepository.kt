package io.github.therealmone.kotlin.spring.example.repository

import io.github.therealmone.kotlin.spring.example.entity.Resource
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ResourceRepository : CrudRepository<Resource, UUID>