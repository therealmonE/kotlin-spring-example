package io.github.therealmone.kotlin.spring.example.service.impl

import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import io.github.therealmone.kotlin.spring.example.mapper.ResourceMapper
import io.github.therealmone.kotlin.spring.example.repository.ResourceRepository
import io.github.therealmone.kotlin.spring.example.service.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ResourceServiceImpl(
    @Autowired val resourceRepository: ResourceRepository,
    @Autowired val resourceMapper: ResourceMapper
) : ResourceService {

    override fun getResourceById(id: UUID): ResourceDto {
        val resource = resourceRepository.findById(id).orElseThrow()

        return resourceMapper.toDto(resource)
    }

    override fun getResources(): List<ResourceDto> {
        return resourceRepository.findAll()
            .map(resourceMapper::toDto)
            .toList()
    }

    override fun createResource(createResourceRequest: CreateResourceRequest): ResourceDto {
        var resource = resourceMapper.toEntity(createResourceRequest)

        resource = resourceRepository.save(resource)

        return resourceMapper.toDto(resource)
    }

}