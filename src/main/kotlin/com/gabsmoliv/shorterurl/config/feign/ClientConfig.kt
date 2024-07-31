package com.gabsmoliv.shorterurl.config.feign

import com.fasterxml.jackson.databind.ObjectMapper
import com.gabsmoliv.shorterurl.adapter.output.feign.client.RedirectApiClient
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfig(
        private val mapper: ObjectMapper
) {
    @Bean
    fun redirectApiClient(
            @Value("\${redirect-api.url}") url: String
    ): RedirectApiClient {
        return Feign.builder()
                .contract(SpringMvcContract())
                .encoder(JacksonEncoder(mapper))
                .decoder(JacksonDecoder(mapper))
                .logger(Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(RedirectApiClient::class.java, url)
    }
}