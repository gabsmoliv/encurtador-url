package com.gabsmoliv.shorterurl.adapter.output.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.ZonedDateTime
import java.util.UUID

@RedisHash("UrlEntity")
class UrlEntity(@Id val id: String, val externalId: UUID, val uniqueID: String, val originalUrl: String, val creationDate: String = ZonedDateTime.now().toString())