package com.gabsmoliv.shorterurl.integration.init

import com.redis.testcontainers.RedisContainer
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName



class TestContainersInitializer {
    companion object {
        const val MONGODB_TEST_DATABASE = "test"
        const val USERNAME_TEST_DATABASE = "root"
        const val PASSWORD_TEST_DATABASE = "root"

        @JvmStatic
        val MONGO_DB_CONTAINER: MongoDBContainer = MongoDBContainer(DockerImageName.parse("mongo:4.0.10"))
                .withEnv("MONGO_INITDB_DATABASE", MONGODB_TEST_DATABASE)
                .withEnv("MONGO_INIT_ROOT_USERNAME",USERNAME_TEST_DATABASE)
                .withEnv("MONGO_INIT_ROOT_PASSWORD",PASSWORD_TEST_DATABASE).withReuse(true)
        @JvmStatic
        val REDIS_CONTAINER: RedisContainer = RedisContainer(DockerImageName.parse("redis:6.2.6"))
                .withReuse(true)

        init {
            MONGO_DB_CONTAINER.start()
            REDIS_CONTAINER.start()
        }
    }
}