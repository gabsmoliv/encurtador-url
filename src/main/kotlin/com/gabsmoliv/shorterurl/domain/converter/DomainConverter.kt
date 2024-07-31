package com.gabsmoliv.shorterurl.domain.converter

import com.gabsmoliv.shorterurl.domain.ShortenedUrl
import com.gabsmoliv.shorterurl.domain.Url

fun Url.toShortenedUrl() = ShortenedUrl(
        originalUrl = originalUrl,
        shorterUrl = shorterUrl
)