package com.gabsmoliv.shorterurl.adapter.input.web.controller

import com.gabsmoliv.shorterurl.adapter.input.web.RedirectApi
import com.gabsmoliv.shorterurl.application.ports.`in`.redirect.RedirectUrlUseCase
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.web.bind.annotation.RestController

@RestController
class RedirectController(
        private val redirectUrlUseCase: RedirectUrlUseCase
) : RedirectApi, Loggable {
    override fun redirectToUrl(shortenedUrl: String) {
        logger.info("Starting to redirect to given url {}", shortenedUrl)
        redirectUrlUseCase.redirectToUrl(shortenedUrl = shortenedUrl)
    }
}