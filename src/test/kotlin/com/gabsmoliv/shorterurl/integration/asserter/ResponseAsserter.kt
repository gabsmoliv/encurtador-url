package com.gabsmoliv.shorterurl.integration.asserter

import com.gabsmoliv.shorterurl.integration.utils.JsonComparator
import org.junit.jupiter.api.Assertions
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseAsserter(private val response: ResponseEntity<String>) {

    fun isNonNull(): ResponseAsserter {
        Assertions.assertNotNull(this.response)
        return this
    }

    fun hasStatusEquals(expectedStatus: HttpStatus): ResponseAsserter {
        Assertions.assertEquals(expectedStatus, this.response.statusCode)
        return this
    }

    fun hasEqualBodyContent(expectedBody: String): ResponseAsserter {
        Assertions.assertEquals(expectedBody, this.response.body)
        return this
    }

    fun hasEqualBodyContentExcept(expectedBody: String, vararg ignore: String): ResponseAsserter {
        JsonComparator.compareJsons(expectedBody, this.response.body, *ignore)
        return this
    }
}