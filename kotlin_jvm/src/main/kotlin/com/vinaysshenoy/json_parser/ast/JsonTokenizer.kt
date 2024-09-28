package com.vinaysshenoy.json_parser.ast

import com.vinaysshenoy.json_parser.ast.JsonToken.*

class JsonTokenizer {
    fun tokenize(json: String): List<JsonToken> {
        val tokens = mutableListOf<JsonToken>()

        var currentCharIndex = 0
        var lastIndex = json.lastIndex
        var currentChar: Char

        while (currentCharIndex <= lastIndex) {
            currentChar = json[currentCharIndex]

            when {
                currentChar == '{' -> tokens.add(BeginObject)
                currentChar.isWhitespace() -> {}
                currentChar == '}' -> tokens.add(EndObject)
            }

            currentCharIndex++
        }

        return tokens.toList()
    }
}