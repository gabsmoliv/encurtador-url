package com.gabsmoliv.shorterurl.integration.template

import com.gabsmoliv.shorterurl.integration.config.RestTemplateCommand
import com.gabsmoliv.shorterurl.integration.init.TestContainersInitializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(locations = ["/application-test.properties"])
@AutoConfigureDataMongo
@ActiveProfiles("test")
class IntegrationTemplate {

    @Autowired
    lateinit var restTemplateCommand: RestTemplateCommand

    fun defaultRequestHeaders() : HttpHeaders {
        val headers = HttpHeaders()
        headers[HttpHeaders.CONTENT_TYPE] = mutableListOf((MediaType.APPLICATION_JSON.toString()))
        return headers
    }

    companion object {
        init {
            TestContainersInitializer
        }
    }
}