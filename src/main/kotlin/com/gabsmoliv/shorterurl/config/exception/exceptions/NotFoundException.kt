package com.gabsmoliv.shorterurl.config.exception.exceptions

import com.gabsmoliv.shorterurl.config.exception.ErrorCodeMessages

class NotFoundException(errorCodeMessages: ErrorCodeMessages) : RuntimeException(errorCodeMessages.name) {
}