package io.github.therealmone.kotlin.spring.example.controller

import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import io.github.therealmone.kotlin.spring.example.service.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1")
class Controller(
    @Autowired val resourceService: ResourceService
) {

    @GetMapping("/resources/{id}")
    fun getResourceById(@PathVariable id: UUID): ResourceDto {
        return resourceService.getResourceById(id)
    }

    @GetMapping("/resources")
    fun getResources(): List<ResourceDto> {
        return resourceService.getResources()
    }

    @PostMapping("/resources")
    fun createResource(@RequestBody createResourceRequest: CreateResourceRequest): ResourceDto {
        return resourceService.createResource(createResourceRequest)
    }

}