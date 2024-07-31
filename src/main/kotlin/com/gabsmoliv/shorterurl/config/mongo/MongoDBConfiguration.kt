package com.gabsmoliv.shorterurl.config.mongo

import com.gabsmoliv.shorterurl.utility.Loggable
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoDBConfiguration(
        @Value("\${spring.data.mongodb.host}") private val host: String,
        @Value("\${spring.data.mongodb.port}") private val port: String,
        @Value("\${spring.data.mongodb.database}") private val db: String,
        @Value("\${spring.data.mongodb.username}") private val username: String,
        @Value("\${spring.data.mongodb.password}") private val password: String,
) : AbstractMongoClientConfiguration(), Loggable {

    override fun getDatabaseName(): String {
        return db
    }

    override fun configureClientSettings(builder: MongoClientSettings.Builder) {
        builder.credential(MongoCredential.createCredential(username, this.databaseName, password.toCharArray()))
                .applyToClusterSettings { settings -> settings.hosts(listOf(ServerAddress(host, port.toInt())))}
    }

}