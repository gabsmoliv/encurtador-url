package com.gabsmoliv.shorterurl.idgen.adapter.`in`

import com.gabsmoliv.shorterurl.application.ports.out.ShortenedUrlRepositoryPort
import com.gabsmoliv.shorterurl.idgen.`in`.UniqueIdGen
import org.springframework.stereotype.Component

private const val MAX_LENGTH_ID = 7
private val ALLOWED_CHARS = ('A'..'Z') + ('a'..'z') + ('0'..'9')

@Component
object UniqueIdGenerator : UniqueIdGen {

    override fun generateUniqueIdForUrl(shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort): String {
        val randomUniqueId = (1..MAX_LENGTH_ID).map { ALLOWED_CHARS.random() }
                .joinToString(separator = "")
        return findIfAlreadyExistsNonCustomId(randomUniqueId, shortenedUrlRepositoryPort)
    }

    private fun findIfAlreadyExistsNonCustomId(randomId: String, shortenedUrlRepositoryPort: ShortenedUrlRepositoryPort) : String {
        var isUnique = true
        var toReturnUniqueId = ""
        while(isUnique) {
            val findUnique = shortenedUrlRepositoryPort.findIfUrlExistsWithUniqueId(randomId)

            if(findUnique == null) {
                isUnique = false
                toReturnUniqueId = randomId
            }
        }
        return toReturnUniqueId
    }
}