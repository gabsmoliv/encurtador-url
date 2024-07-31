package com.gabsmoliv.shorterurl.application.ports.`in`.shorten

import com.gabsmoliv.shorterurl.domain.ShortenedUrl

import com.gabsmoliv.shorterurl.domain.UrlToShort

interface ShorterUrlUseCase {
    fun shortUrl(urlToBeShortened: UrlToShort) : ShortenedUrl
}