package com.vinaysshenoy.json_parser.ast

sealed class AstNode {
    class JsonObject(): AstNode()
    class JsonArray(): AstNode()
}