package com.vinaysshenoy.json_parser.ast

sealed class JsonToken {
    object BeginObject: JsonToken()
    object EndObject: JsonToken()
    data class PropertyName(val name: String): JsonToken()
    data class LongValue(val value: Long): JsonToken()
}