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
}