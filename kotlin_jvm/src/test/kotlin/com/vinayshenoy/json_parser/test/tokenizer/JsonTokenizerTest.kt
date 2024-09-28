package com.vinayshenoy.json_parser.test.tokenizer

import com.vinaysshenoy.json_parser.ast.JsonToken
import com.vinaysshenoy.json_parser.ast.JsonToken.*
import com.vinaysshenoy.json_parser.ast.JsonTokenizer
import strikt.api.expectThat
import strikt.assertions.containsExactly
import kotlin.test.Test

class JsonTokenizerTest {
    private val tokenizer: JsonTokenizer = JsonTokenizer()

    private fun tokenize(json: String): List<JsonToken> {
        return tokenizer.tokenize(json)
    }

    @Test
    fun `it should tokenize an empty json object`() {
        // given
        val json = """
            {
            }
        """.trimIndent()

        // when
        val tokens = tokenize(json)

        // then
        expectThat(tokens).containsExactly(BeginObject, EndObject)
    }

    @Test
    fun `it should tokenize an integer property`() {
        // given
        val json = """
            {
                "count": 123
            }
        """.trimIndent()

        // when
        val tokens = tokenize(json)

        // then
        expectThat(tokens).containsExactly(
            BeginObject,
            PropertyName("count"),
            LongValue(123),
            EndObject
        )
    }

    @Test
    fun `it should tokenize a single digit integer property`() {
        // given
        val json = """
            {
                "count": 1
            }
        """.trimIndent()

        // when
        val tokens = tokenize(json)

        // then
        expectThat(tokens).containsExactly(
            BeginObject,
            PropertyName("count"),
            LongValue(1),
            EndObject
        )
    }

    @Test
    fun `it should be able to tokenize multiple integer properties`() {
        // given
        val json = """
            {
                "breakfast": 0830,
                "secondBreakfast": 10,
                "elevenses": 1130
            }
        """.trimIndent()

        // when
        val tokens = tokenize(json)

        // then
        expectThat(tokens).containsExactly(
            BeginObject,
            PropertyName("breakfast"),
            LongValue(830),
            PropertyName("secondBreakfast"),
            LongValue(10),
            PropertyName("elevenses"),
            LongValue(1130),
            EndObject
        )
    }
}