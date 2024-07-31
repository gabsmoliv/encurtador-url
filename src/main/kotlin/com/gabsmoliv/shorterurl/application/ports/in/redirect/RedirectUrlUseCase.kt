package com.gabsmoliv.shorterurl.application.ports.`in`.redirect

interface RedirectUrlUseCase {
    fun redirectToUrl(shortenedUrl: String)
}