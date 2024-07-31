package com.gabsmoliv.shorterurl.idgen.`in`

import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort

interface UniqueIdGen {
    fun generateUniqueIdForUrl(shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort): String
}