package com.gabsmoliv.shorterurl.domain

import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort

class Url(val originalUrl: String, val shorterUrl: String) {
    fun saveUrl(shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort) : Url{
        return shortenedUrlRepositoryPort.saveShortenUrl(this)
    }
}