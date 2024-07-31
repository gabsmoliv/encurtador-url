package com.gabsmoliv.shorterurl.config

import com.gabsmoliv.shorterurl.config.exception.ErrorCodeMessages
import com.gabsmoliv.shorterurl.config.exception.exceptions.BadRequestException
import com.gabsmoliv.shorterurl.config.exception.exceptions.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, request: WebRequest?) : ResponseEntity<Any>? {
        return handleDefaultException(
                exception,
                exception.message?.let { ErrorCodeMessages.valueOf(it) } ?: ErrorCodeMessages.NOT_FOUND_MESSAGE,
                HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request!!)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: NotFoundException, request: WebRequest?) : ResponseEntity<Any>? {
        return handleDefaultException(
                exception,
                exception.message?.let { ErrorCodeMessages.valueOf(it) } ?: ErrorCodeMessages.NOT_FOUND_MESSAGE,
                HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request!!)
    }

    fun handleDefaultException(
            exception: Exception,
            body: Any?,
            httpHeaders: HttpHeaders,
            httpStatusCode: HttpStatusCode,
            webRequest: WebRequest
    ) : ResponseEntity<Any>? {
        return handleExceptionInternal(exception, body, httpHeaders, httpStatusCode, webRequest)
    }
}