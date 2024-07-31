package com.gabsmoliv.shorterurl.adapter.input.web

import com.gabsmoliv.shorterurl.adapter.input.web.requests.ShorterUrlRequest
import com.gabsmoliv.shorterurl.adapter.input.web.responses.ShorterUrlResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1/shorter-url")
interface ShorterApi {
    @Operation
    @ApiResponse(
            description = "The given URL should not be null.",
            responseCode = "400"
    )
    @ApiResponse(
            description = "An unexpected error occurred.",
            responseCode = "500"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun shortGivenUrl(@RequestBody @Validated shorterUrlRequest: ShorterUrlRequest) : ShorterUrlResponse
}