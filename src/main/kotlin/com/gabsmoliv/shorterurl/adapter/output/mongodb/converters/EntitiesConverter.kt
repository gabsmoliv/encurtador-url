package com.gabsmoliv.shorterurl.adapter.output.mongodb.converters

import com.gabsmoliv.shorterurl.adapter.output.mongodb.entities.UrlEntity
import com.gabsmoliv.shorterurl.domain.Url
import java.util.UUID

fun Url.toEntity() = UrlEntity(
        id = "",
        externalId = UUID.randomUUID(),
        uniqueID = this.shorterUrl,
        originalUrl = this.originalUrl
)

fun UrlEntity.toDomain() = Url(
        originalUrl = this.originalUrl,
        shorterUrl = this.uniqueID,
)

fun UrlEntity.toUniqueId() = this.uniqueID