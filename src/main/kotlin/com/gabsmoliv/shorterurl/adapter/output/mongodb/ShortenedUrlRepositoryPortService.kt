package com.gabsmoliv.shorterurl.adapter.output.mongodb

import com.gabsmoliv.shorterurl.adapter.output.mongodb.converters.toDomain
import com.gabsmoliv.shorterurl.adapter.output.mongodb.converters.toEntity
import com.gabsmoliv.shorterurl.adapter.output.mongodb.converters.toUniqueId
import com.gabsmoliv.shorterurl.adapter.output.mongodb.repositories.ShorterMongoRepository
import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort
import com.gabsmoliv.shorterurl.domain.Url
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.stereotype.Service

@Service
class ShortenedUrlRepositoryPortService(
        private val shorterMongoRepository: ShorterMongoRepository
) : ShortenedUrlRepositoryPort, Loggable {

    override fun saveShortenUrl(url: Url) : Url {
        return shorterMongoRepository.save(url.toEntity())
                .also { logger.info("Save entity it success {}", it) }
                .toDomain()
    }

    override fun findIfUrlExistsWithUniqueId(uniqueId: String): String? {
        return shorterMongoRepository.findByUniqueID(uniqueId)
                ?.let { entityUrl ->
                    logger.info("find entity with $uniqueId")
                    entityUrl.toUniqueId()
                }
    }
}