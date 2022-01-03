package io.github.therealmone.kotlin.spring.example.mapper

import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import io.github.therealmone.kotlin.spring.example.entity.Resource
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ResourceMapper {

    fun toDto(resource: Resource) : ResourceDto

    fun toEntity(createResourceRequest: CreateResourceRequest): Resource

}