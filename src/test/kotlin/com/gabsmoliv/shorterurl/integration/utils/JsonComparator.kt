package com.gabsmoliv.shorterurl.integration.utils

import org.junit.jupiter.api.Assertions
import kotlin.RuntimeException

object JsonComparator {
    fun compareJsons(expected: String, actual: String?, vararg ignore: String) {
        if(!actual.isNullOrBlank()) {
            if(expected.length != actual.length) {
                throw RuntimeException("Objects lengths differs, they aren't equals")
            }

            val jeizoOne = makeThisAJson(expected)
            val jeizoTwo = makeThisAJson(actual)

            for(key in jeizoOne.keys) {
               if(!ignore.contains(key)) {
                   val expectedValue = jeizoOne[key]
                   val actualValue = jeizoTwo[key]
                   Assertions.assertEquals(expectedValue, actualValue)
               }
            }
        }
    }

    /**
     * Should have this pattern to work properly
     * {
     *     "key":"value",
     *     "key:"value"
     * }
     */
    private fun makeThisAJson(json: String) : Map<String, String> {
        val realJson = mutableMapOf<String, String>()
        var newJson = json
        /**
         * TODO: Create a regex to replace {} and "\"
         */
        newJson = newJson.replace("{", "")
        newJson = newJson.replace("}", "")
        newJson = newJson.replace("\"", "")
        newJson.split(",").forEach { value ->
            val splitString = value.split(":")
            if(splitString.size == 2) {
                realJson += Pair(splitString[0], splitString[1])
            }
        }
        return realJson
    }
}