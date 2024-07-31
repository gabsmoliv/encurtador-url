package com.gabsmoliv.shorterurl.application.converters

import com.gabsmoliv.shorterurl.domain.Url
import com.gabsmoliv.shorterurl.domain.UrlToShort

fun UrlToShort.toDomain() = Url(
        originalUrl = this.originalUrl,
        shorterUrl = this.customId
)

