package com.gabsmoliv.shorterurl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(scanBasePackages = ["com.gabsmoliv.shorterurl"])
@EnableMongoRepositories
@EnableFeignClients
class ShorterUrlApplication

fun main(args: Array<String>) {
	runApplication<ShorterUrlApplication>(*args)
}
