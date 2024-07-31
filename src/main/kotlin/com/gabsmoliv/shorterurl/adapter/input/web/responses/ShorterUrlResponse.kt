package com.gabsmoliv.shorterurl.adapter.input.web.responses

import kotlinx.serialization.Serializable

@Serializable
class ShorterUrlResponse(val shortedUrl : String, val originalUrl : String)
