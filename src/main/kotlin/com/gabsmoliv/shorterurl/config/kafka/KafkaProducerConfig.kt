package com.gabsmoliv.shorterurl.config.kafka

import com.gabsmoliv.shorterurl.utility.Loggable
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.config.SaslConfigs
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig(
        @Value("\${kafka.broke.servers}") private val servers: String,
        @Value("\${kafka.scram.user}") private val user: String,
        @Value("\${kafka.scram.password}") private val password: String,
) : Loggable {

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val props = HashMap<String, Any>()
        logger.info("EventBus producer factory configuration")

        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = servers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        props[ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG] = "true"
        props[ProducerConfig.ACKS_CONFIG] = "all"
        props[ProducerConfig.RETRIES_CONFIG] = Int.MAX_VALUE.toString()

        props[ProducerConfig.LINGER_MS_CONFIG] = "20"
        props[ProducerConfig.BATCH_SIZE_CONFIG] = (32 * 1024).toString()
        props[ProducerConfig.COMPRESSION_TYPE_CONFIG] = "snappy"
        props["ssl.endpoint.identification.algorithm"] = ""

        props[CommonClientConfigs.SECURITY_PROTOCOL_CONFIG] = "SASL_SSL"
        props[SaslConfigs.SASL_MECHANISM] = "SCRAM-SHA-512"
        val ref = "org.apache.kafka.common.security.scram.ScramLoginModule"
        props[SaslConfigs.SASL_JAAS_CONFIG] = "$ref required username='$user' password='$password';"

        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }
}