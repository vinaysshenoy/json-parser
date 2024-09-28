package com.vinaysshenoy.json_parser.ast

class JsonAstParser() {
    fun parse(text: String): JsonAst {
        val root: AstNode = when (text[0]) {
            '{' -> parseJsonObject(text)
            '[' -> parseJsonArray(text)
            else -> throw RuntimeException("Could not parse:\n$text")
        }

        return JsonAst(root)
    }

    private fun parseJsonObject(json: String): AstNode {
        return AstNode.JsonObject()
    }

    private fun parseJsonArray(json: String): AstNode {
        return AstNode.JsonArray()
    }
}