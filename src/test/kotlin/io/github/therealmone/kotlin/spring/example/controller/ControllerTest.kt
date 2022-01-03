package io.github.therealmone.kotlin.spring.example.controller

import io.github.therealmone.kotlin.spring.example.AbstractIT
import io.github.therealmone.kotlin.spring.example.dto.CreateResourceRequest
import io.github.therealmone.kotlin.spring.example.dto.ResourceDto
import io.github.therealmone.kotlin.spring.example.repository.ResourceRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity

internal class ControllerTest(
    @Autowired val restTemplate: TestRestTemplate,
    @Autowired val resourceRepository: ResourceRepository
) : AbstractIT() {

    @Test
    fun `Assert resource created`() {
        val request = CreateResourceRequest("some resource")
        val resource = restTemplate.postForEntity<ResourceDto>("/api/v1/resources", request).body!!

        assertNotNull(resource.id)
        assertEquals("some resource", resource.data)
        assertEquals(1, resourceRepository.count())
        assertNotNull(resourceRepository.findById(resource.id))
    }

}