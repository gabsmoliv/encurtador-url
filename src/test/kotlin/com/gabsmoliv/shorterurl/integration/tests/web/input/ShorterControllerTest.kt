package com.gabsmoliv.shorterurl.integration.tests.web.input

import com.gabsmoliv.shorterurl.integration.asserter.ResponseAsserter
import com.gabsmoliv.shorterurl.integration.provider.ShorterUrlRequestProvider
import com.gabsmoliv.shorterurl.integration.provider.ShorterUrlResponseProvider
import com.gabsmoliv.shorterurl.integration.provider.ShorterUrlResponseProvider.toJson
import com.gabsmoliv.shorterurl.integration.template.IntegrationTemplate
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.http.HttpStatus

private const val SHORTER_API_URL : String = "/v1/shorter-url"

class ShorterControllerTest : IntegrationTemplate() {

    @Test
    @DisplayName("Should POST a new shortened url with response status 200")
    fun shouldCreatedShortenedUrlWithSuccess() {
        val request = ShorterUrlRequestProvider.toUrlRequestProvider()
        val expectedResponse = ShorterUrlResponseProvider.toResponse().toJson()

        val response = restTemplateCommand.requestPOST(SHORTER_API_URL, request, defaultRequestHeaders())

        ResponseAsserter(response)
                .isNonNull()
                .hasStatusEquals(HttpStatus.CREATED)
                .hasEqualBodyContentExcept(expectedResponse, "shortedUrl")
    }

    @ParameterizedTest
    @ValueSource(strings = ["www.google.com", "www.terra.com.br", "www.youtube.com", "www.gmail.com", "www.github.com",
            "www.excalidraw.com", "www.figma.com", "www.linkedin.com", "www.instagram.com", "www.facebook.com"])
    @DisplayName("Should POST a ten new shortened url with response status 200")
    fun shouldCreated10ShortenedUrlWithSuccess(originalUrl:  String) {
        val request = ShorterUrlRequestProvider.toUrlRequestProviderWithOriginalUrl(originalUrl)
        val expectedResponse = ShorterUrlResponseProvider.toResponseWithOriginalUrl(originalUrl).toJson()

        val response = restTemplateCommand.requestPOST(SHORTER_API_URL, request, defaultRequestHeaders())

        ResponseAsserter(response)
                .isNonNull()
                .hasStatusEquals(HttpStatus.CREATED)
                .hasEqualBodyContentExcept(expectedResponse, "shortedUrl")
    }

    @Test
    @DisplayName("Should POST a new shortened url with custom unique id and response status 200")
    fun shouldCreatedShortenedUrlCustomWithSuccess() {
        val customId = "X8mV19Fx"

        val request = ShorterUrlRequestProvider.toUrlRequestProviderWithCustomId(customId)
        val expectedResponse = ShorterUrlResponseProvider.toResponseWithShortedUrl(customId).toJson()

        val response = restTemplateCommand.requestPOST(SHORTER_API_URL, request, defaultRequestHeaders())

        ResponseAsserter(response)
                .isNonNull()
                .hasStatusEquals(HttpStatus.CREATED)
                .hasEqualBodyContent(expectedResponse)
    }

    @ParameterizedTest
    @MethodSource("getUrlWithCustomShorted")
    @DisplayName("Should POST a ten new shortened url with response status 200")
    fun shouldCreated10ShortenedUrlWithCustomIdSuccess(originalUrl:  String, customId: String) {
        val request = ShorterUrlRequestProvider.toUrlRequestProviderWithOriginalUrlAndCustomId(originalUrl, customId)
        val expectedResponse = ShorterUrlResponseProvider.toResponseWithOriginalAndShortedUrl(customId, originalUrl, ).toJson()

        val response = restTemplateCommand.requestPOST(SHORTER_API_URL, request, defaultRequestHeaders())

        ResponseAsserter(response)
                .isNonNull()
                .hasStatusEquals(HttpStatus.CREATED)
                .hasEqualBodyContent(expectedResponse)
    }

    /**
     *
     * TODO: Should fail to create a shortened url when unique id already exists in database
     *
     * */

    companion object {
        @JvmStatic
        fun getUrlWithCustomShorted() = listOf(
                Arguments.of("www.google.com", "FLTo6OYT"),
                Arguments.of("www.terra.com.br", "jCzGbpk0"),
                Arguments.of("www.youtube.com", "aBKLlqrb"),
                Arguments.of("www.gmail.com", "rQqF8tPg"),
                Arguments.of("www.github.com", "Pzvm6NEf"),
                Arguments.of("www.excalidraw.com", "1H41COP2"),
                Arguments.of("www.figma.com", "h4WVGsYI"),
                Arguments.of("www.linkedin.com", "54Lj76WG"),
                Arguments.of("www.instagram.com", "kfJko9dL"),
                Arguments.of("www.facebook.com", "XsrXt9dZ"),
        )
    }
}