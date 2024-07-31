package com.gabsmoliv.shorterurl.adapter.output.kafka

import com.gabsmoliv.shorterurl.adapter.output.kafka.client.KafkaClient
import com.gabsmoliv.shorterurl.domain.Url
import com.gabsmoliv.shorterurl.utility.Loggable
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

private const val TOPIC_SEND_NAME = "creation.url.event"

@Service
class KafkaClientService(
        private val kafkaTemplate: KafkaTemplate<String, String>
) : KafkaClient, Loggable {
    override fun sendCreationUrlEvent(url: Url) {
        logger.info("Starting to send a event to kafka with {}", url)
        kafkaTemplate.send(TOPIC_SEND_NAME, createEvent(url))
    }

    private fun createEvent(url: Url): String {
        return """
           {
                "id": ${UUID.randomUUID()},
                "timeStamp": ${LocalDateTime.now()}
                "event": {
                    "originalUrl": ${url.originalUrl},
                    "shorterUrl": ${url.shorterUrl}
                }
           }  
        """
    }
}