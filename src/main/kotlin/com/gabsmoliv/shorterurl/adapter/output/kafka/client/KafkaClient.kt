package com.gabsmoliv.shorterurl.adapter.output.kafka.client

import com.gabsmoliv.shorterurl.domain.Url

interface KafkaClient {
    fun sendCreationUrlEvent(url: Url)
}