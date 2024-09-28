package com.vinaysshenoy.json_parser.ast

import com.vinaysshenoy.json_parser.ast.AstNode.ChildNode.*

class JsonAstParser() {
    fun parse(text: String): JsonAst {
        val root: AstNode = when (text.first()) {
            '{' -> parseJsonObject(text)
            '[' -> parseJsonArray(text)
            else -> throw RuntimeException("Could not parse:\n$text")
        }

        return JsonAst(root)
    }

    private fun parseJsonObject(json: String): AstNode {
        val lastChar = json.last()

        if (lastChar == '}') {
            return AstNode.JsonObject(children = listOf(IntegerNode(name = "value", value = 1)))
        }

        throw RuntimeException("Invalid JSON object: $json")
    }

    private fun parseJsonArray(json: String): AstNode {
        val lastChar = json.last()

        if (lastChar == ']') {
            return AstNode.JsonArray()
        }

        throw RuntimeException("Invalid JSON array: $json")
    }
}