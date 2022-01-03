package io.github.therealmone.kotlin.spring.example.service

import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import java.util.UUID

interface ResourceService {

    fun getResourceById(id: UUID): ResourceDto

    fun getResources(): List<ResourceDto>

    fun createResource(createResourceRequest: CreateResourceRequest): ResourceDto

}