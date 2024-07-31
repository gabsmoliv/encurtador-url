package com.gabsmoliv.shorterurl.adapter.output.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "Redirects")
interface RedirectApiClient {
    @GetMapping("/{shortenedUrl}")
    fun redirectToUrl(@PathVariable shortenedUrl: String)
}