package com.gabsmoliv.shorterurl.application.adapters.`in`.redirect

import com.gabsmoliv.shorterurl.application.ports.`in`.redirect.RedirectUrlUseCase
import com.gabsmoliv.shorterurl.application.ports.out.RedirectUrlPort
import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort
import com.gabsmoliv.shorterurl.config.exception.exceptions.BadRequestException
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RedirectUrlService(
        private val redirectUrlPort: RedirectUrlPort,
        private val shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort,
) : RedirectUrlUseCase, Loggable {
    override fun redirectToUrl(shortenedUrl: String) {
        val url = getUrlOrThrow(shortenedUrl)

        redirectUrlPort.redirectTo(url)
    }

    @Cacheable(value = ["UrlEntity"])
    fun getUrlOrThrow(urlUniqueId: String): String {
        return shortenedUrlRepositoryPort.findIfUrlExistsWithUniqueId(urlUniqueId)
                ?: throw BadRequestException("Couldn't find a url with given $urlUniqueId")
    }
}