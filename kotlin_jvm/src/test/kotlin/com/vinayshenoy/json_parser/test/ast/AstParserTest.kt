package com.vinayshenoy.json_parser.test.ast

import com.vinaysshenoy.json_parser.ast.AstNode.*
import com.vinaysshenoy.json_parser.ast.JsonAst
import com.vinaysshenoy.json_parser.ast.JsonAstParser
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import strikt.api.expectThat
import strikt.assertions.isA
import kotlin.test.Test

private fun parse(json: String): JsonAst {
    val astParser = JsonAstParser()

    return astParser.parse(json)
}

class AstParserTest {

    @Nested
    @DisplayName("Parse JSON objects")
    inner class JsonObjectTests {

        @Test
        fun `it should parse an empty json object`() {
            // given
            val json = "{}"

            // when
            val ast = parse(json)

            // then
            expectThat(ast.root).isA<JsonObject>()
        }
    }

    @Nested
    @DisplayName("Parse JSON arrays")
    inner class JsonArrayTests {

        @Test
        fun `it should parse an empty json array`() {
            // given
            val json = "[]"

            // when
            val ast = parse(json)

            // then
            expectThat(ast.root).isA<JsonArray>()
        }
    }
}