package com.gabsmoliv.shorterurl.application.ports.out

import com.gabsmoliv.shorterurl.domain.Url

interface ShortenedUrlRepositoryPort {
    fun saveShortenUrl(url: Url) : Url
    fun findIfUrlExistsWithUniqueId(uniqueId: String) : String?
}