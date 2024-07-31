package com.gabsmoliv.shorterurl.domain

import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort
import com.gabsmoliv.shorterurl.idgen.`in`.UniqueIdGen

class UrlToShort(val originalUrl: String, var customId: String) {
    fun generateUniqueIdForUrl(uniqueIdGen: UniqueIdGen, shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort) {
        this.customId = uniqueIdGen.generateUniqueIdForUrl(shortenedUrlRepositoryPort)
    }
}