package com.gabsmoliv.shorterurl.adapter.input.web.requests

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(description = "Url object request")
class ShorterUrlRequest(
        @Schema(description = "The original URL to be shortened")
        @NotBlank val originalUrl : String,
        @Schema(description = "A custom unique ID for shortened URL")
        val customUniqueId: String
)