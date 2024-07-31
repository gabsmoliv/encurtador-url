package com.gabsmoliv.shorterurl.integration.provider

import com.gabsmoliv.shorterurl.adapter.input.web.requests.ShorterUrlRequest

object ShorterUrlRequestProvider {

    fun toUrlRequestProvider() = toUrlRequestProviderWithOriginalUrl(
            "www.google.com")

    fun toUrlRequestProviderWithOriginalUrl(originalUrl: String) = ShorterUrlRequest(
            originalUrl = originalUrl,
            customUniqueId = ""
    )

    fun toUrlRequestProviderWithCustomId(customId: String) = ShorterUrlRequest(
            originalUrl = "www.google.com",
            customUniqueId = customId
    )

    fun toUrlRequestProviderWithOriginalUrlAndCustomId(originalUrl: String, customId: String) = ShorterUrlRequest(
            originalUrl = originalUrl,
            customUniqueId = customId
    )
}