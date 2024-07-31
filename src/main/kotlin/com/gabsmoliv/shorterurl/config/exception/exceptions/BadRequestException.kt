package com.gabsmoliv.shorterurl.config.exception.exceptions

import com.gabsmoliv.shorterurl.config.exception.ErrorCodeMessages

class BadRequestException(errorCodeMessages: ErrorCodeMessages, detailsError: String) : RuntimeException(errorCodeMessages.name) {
    constructor(detailsError: String) : this(ErrorCodeMessages.BAD_REQUEST_MESSAGE, detailsError)
}