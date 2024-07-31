package com.gabsmoliv.shorterurl.application.ports.out

interface RedirectUrlPort {
    fun redirectTo(url: String)
}