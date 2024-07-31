package com.gabsmoliv.shorterurl.integration.config

import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class RestTemplateCommand(private val testRestTemplate: TestRestTemplate) {

    fun requestGET(uri: String, httpHeaders: HttpHeaders) : ResponseEntity<String> {
        return defaultExchangeRequest(uri, null, HttpMethod.GET, httpHeaders)
    }

    fun requestPOST(uri: String, requestObject: Any?, httpHeaders: HttpHeaders) : ResponseEntity<String> {
        return defaultExchangeRequest(uri, requestObject, HttpMethod.POST, httpHeaders)
    }

    private fun defaultExchangeRequest(uri: String, requestObject: Any?,  httpMethod: HttpMethod, httpHeaders: HttpHeaders) : ResponseEntity<String> {
        try {
            httpHeaders.putIfAbsent(HttpHeaders.CONTENT_TYPE, listOf(MediaType.APPLICATION_JSON.toString()))
            val requestEntity = HttpEntity(requestObject, httpHeaders)
            return testRestTemplate.exchange(uri, httpMethod, requestEntity, String::class.java)
        } catch (ex: Exception) {
            throw ex
        }
    }
}