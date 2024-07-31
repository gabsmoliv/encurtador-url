package com.gabsmoliv.shorterurl.application.adapters.`in`.shorter

import com.gabsmoliv.shorterurl.adapter.output.kafka.client.KafkaClient
import com.gabsmoliv.shorterurl.application.converters.toDomain
import com.gabsmoliv.shorterurl.application.ports.`in`.shorten.ShorterUrlUseCase
import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort
import com.gabsmoliv.shorterurl.config.exception.exceptions.BadRequestException
import com.gabsmoliv.shorterurl.domain.ShortenedUrl
import com.gabsmoliv.shorterurl.domain.UrlToShort
import com.gabsmoliv.shorterurl.domain.converter.toShortenedUrl
import com.gabsmoliv.shorterurl.idgen.`in`.UniqueIdGen
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.stereotype.Service

@Service
class ShorterUrlService(
        private val shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort,
        private val uniqueIdGen: UniqueIdGen,
        private val kafkaClient: KafkaClient
) : ShorterUrlUseCase, Loggable {
    override fun shortUrl(urlToBeShortened: UrlToShort): ShortenedUrl {
        if(urlToBeShortened.customId.isNotBlank()) {
            shortenedUrlRepositoryPort.findIfUrlExistsWithUniqueId(urlToBeShortened.customId)
                    ?.let { id -> throw BadRequestException("Already exists a custom id given with $id")}
        } else {
            urlToBeShortened.generateUniqueIdForUrl(uniqueIdGen, shortenedUrlRepositoryPort)
        }

        return urlToBeShortened.toDomain().saveUrl(shortenedUrlRepositoryPort)
                .also { kafkaClient.sendCreationUrlEvent(it)  }
                .also { logger.info("Successfully created a new url with $it") }
                .toShortenedUrl()
    }
}