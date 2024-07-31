package com.gabsmoliv.shorterurl.adapter.output.mongodb.entities

import org.springframework.data.annotation.Id
import java.util.UUID

class User(@Id val id: String, val externalId: UUID, val email: String)