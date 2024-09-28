package com.vinayshenoy.json_parser.test.ast

import com.vinaysshenoy.json_parser.ast.AstNode.*
import com.vinaysshenoy.json_parser.ast.JsonAst
import com.vinaysshenoy.json_parser.ast.JsonAstParser
import strikt.api.expectThat
import strikt.assertions.isA
import kotlin.test.Test

private fun parse(json: String): JsonAst {
    val astParser = JsonAstParser()

    return astParser.parse(json)
}

class AstParserTest {

    @Test
    fun `it should parse an empty json object`() {
        // given
        val json = "{}"

        // when
        val ast = parse(json)

        // then
        expectThat(ast.root).isA<JsonObject>()
    }

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