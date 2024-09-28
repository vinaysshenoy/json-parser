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
                currentChar == ':' -> {
                    val (integerString, totalCharactersParsed) = extractIntString(json, currentCharIndex + 1)

                    tokens.add(LongValue(integerString.toLong()))

                    currentCharIndex += totalCharactersParsed
                }
                currentChar == '"' -> {
                    val name = extractPropertyName(json, currentCharIndex + 1)
                    tokens.add(PropertyName(name))

                    currentCharIndex += name.length + 1
                }
                currentChar == '}' -> tokens.add(EndObject)
            }

            currentCharIndex++
        }

        return tokens.toList()
    }

    private fun extractPropertyName(
        json: String,
        startFromIndex: Int
    ): String {
        var currentCharIndex = startFromIndex
        var currentChar = json[startFromIndex]

        while (currentChar != '"') {
            currentCharIndex++
            currentChar = json[currentCharIndex]
        }

        return json.substring(startFromIndex, currentCharIndex)
    }

    private fun extractIntString(
        json: String,
        startFromIndex: Int
    ): Pair<String, Int> {
        var totalCharactersParsed = 0

        var digitStartFromIndex = -1
        var digitEndAtIndex = -1

        var currentCharIndex = startFromIndex
        var currentChar = json[currentCharIndex]

        while (currentChar.isWhitespace()) {
            totalCharactersParsed++
            currentChar = json[++currentCharIndex]
        }

        if (currentChar.isDigit()) {
            digitStartFromIndex = currentCharIndex
            digitEndAtIndex = currentCharIndex

            while (currentChar.isDigit()) {
                digitEndAtIndex++
                currentChar = json[++currentCharIndex]
            }
        }

        totalCharactersParsed += digitEndAtIndex - digitStartFromIndex

        return json.substring(digitStartFromIndex, digitEndAtIndex) to totalCharactersParsed
    }
}