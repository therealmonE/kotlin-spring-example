package io.github.therealmone.kotlin.spring.example.service.impl

import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import io.github.therealmone.kotlin.spring.example.mapper.ResourceMapper
import io.github.therealmone.kotlin.spring.example.repository.ResourceRepository
import io.github.therealmone.kotlin.spring.example.service.ResourceService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

private val log = KotlinLogging.logger {}

@Service
class ResourceServiceImpl(
    @Autowired val resourceRepository: ResourceRepository,
    @Autowired val resourceMapper: ResourceMapper
) : ResourceService {

    override fun getResourceById(id: UUID): ResourceDto {
        log.info { "Get resource by id: $id" }

        val resource = resourceRepository.findById(id).orElseThrow()

        return resourceMapper.toDto(resource)
    }

    override fun getResources(): List<ResourceDto> {
        log.info { "Get resources" }

        return resourceRepository.findAll()
            .map(resourceMapper::toDto)
            .toList()
    }

    override fun createResource(createResourceRequest: CreateResourceRequest): ResourceDto {
        log.info { "Create resource: ${createResourceRequest.data}" }

        var resource = resourceMapper.toEntity(createResourceRequest)

        resource = resourceRepository.save(resource)

        return resourceMapper.toDto(resource)
    }

}