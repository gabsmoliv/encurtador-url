package com.gabsmoliv.shorterurl.adapter.input.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1/{shortenedUrl}")
interface RedirectApi {
    @Operation
    @ApiResponse(
            description = "The given URL it was not found.",
            responseCode = "404"
    )
    @ApiResponse(
            description = "An unexpected error on server side occurred.",
            responseCode = "500"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.SEE_OTHER)
    fun redirectToUrl(@PathVariable("shortenedUrl") shortenedUrl: String)
}