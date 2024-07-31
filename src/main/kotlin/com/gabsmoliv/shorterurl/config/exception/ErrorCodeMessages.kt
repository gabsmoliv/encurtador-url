package com.gabsmoliv.shorterurl.config.exception

enum class ErrorCodeMessages(val message: String) {
    // Http Error 400
    BAD_REQUEST_MESSAGE("Invalid request was sent to server!"),

    // Http Error 404
    NOT_FOUND_MESSAGE("Resource not found!")
}