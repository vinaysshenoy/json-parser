package com.vinaysshenoy.json_parser.ast

class JsonAstParser() {
    fun parse(text: String): JsonAst {
        return JsonAst(AstNode.JsonObject())
    }
}