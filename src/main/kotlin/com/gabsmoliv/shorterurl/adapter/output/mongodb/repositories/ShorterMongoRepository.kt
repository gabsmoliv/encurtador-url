package com.gabsmoliv.shorterurl.adapter.output.mongodb.repositories

import com.gabsmoliv.shorterurl.adapter.output.mongodb.entities.UrlEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShorterMongoRepository : MongoRepository<UrlEntity, String> {
    fun findByUniqueID(uniqueId: String) : UrlEntity?
}