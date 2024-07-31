package com.gabsmoliv.shorterurl.adapter.input.web.controller

import com.gabsmoliv.shorterurl.adapter.input.web.ShorterApi
import com.gabsmoliv.shorterurl.adapter.input.web.converter.toResponse
import com.gabsmoliv.shorterurl.adapter.input.web.requests.ShorterUrlRequest
import com.gabsmoliv.shorterurl.adapter.input.web.responses.ShorterUrlResponse
import com.gabsmoliv.shorterurl.application.ports.`in`.shorten.ShorterUrlUseCase
import com.gabsmoliv.shorterurl.domain.UrlToShort

import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.web.bind.annotation.RestController

@RestController
class ShorterController(private val shorterUrlUseCase: ShorterUrlUseCase) : ShorterApi, Loggable {
    override fun shortGivenUrl(shorterUrlRequest: ShorterUrlRequest) : ShorterUrlResponse {
        logger.info("Upcoming request to shorter url: {}", shorterUrlRequest.originalUrl)

        return shorterUrlUseCase.shortUrl(UrlToShort(
                originalUrl = shorterUrlRequest.originalUrl,
                customId = shorterUrlRequest.customUniqueId
                ))
                .also {
                    logger.info("Request finished with shortened ${it.originalUrl} and shorter url as ${it.shorterUrl}")
                } . toResponse()
    }
}