package com.gabsmoliv.shorterurl.adapter.output.feign

import com.gabsmoliv.shorterurl.adapter.output.feign.client.RedirectApiClient
import com.gabsmoliv.shorterurl.application.ports.out.RedirectUrlPort
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.stereotype.Service

@Service
class RedirectApiService(
        private val redirectApiClient: RedirectApiClient
) : RedirectUrlPort, Loggable {
    override fun redirectTo(url: String) {
        logger.info("Redirect to url: {}", url)
        redirectApiClient.redirectToUrl(url)
    }
}