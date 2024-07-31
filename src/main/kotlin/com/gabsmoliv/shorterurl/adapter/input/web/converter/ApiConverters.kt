package com.gabsmoliv.shorterurl.adapter.input.web.converter

import com.gabsmoliv.shorterurl.adapter.input.web.responses.ShorterUrlResponse
import com.gabsmoliv.shorterurl.domain.ShortenedUrl
import com.gabsmoliv.shorterurl.domain.Url

fun ShortenedUrl.toResponse() = ShorterUrlResponse(
        originalUrl = this.originalUrl,
        shortedUrl = this.shorterUrl
)