package com.gabsmoliv.shorterurl.integration.provider

import com.gabsmoliv.shorterurl.adapter.input.web.responses.ShorterUrlResponse
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val DEFAULT_ORIGIN = "www.google.com"

object ShorterUrlResponseProvider {
    fun toResponse() = toResponseWithOriginalUrl(DEFAULT_ORIGIN)

    fun toResponseWithOriginalUrl(originalUrl: String) = ShorterUrlResponse(
            shortedUrl = "abcdefg",
            originalUrl = originalUrl
    )

    fun toResponseWithShortedUrl(shortedUrl: String) = toResponseWithOriginalAndShortedUrl(
            shortedUrl = shortedUrl,
            originalUrl = DEFAULT_ORIGIN
    )

    fun toResponseWithOriginalAndShortedUrl(shortedUrl: String, originalUrl: String, ) = ShorterUrlResponse(
            shortedUrl = shortedUrl,
            originalUrl = originalUrl
    )

    fun ShorterUrlResponse.toJson() : String {
        return Json.encodeToString(this)
    }

}