package com.vinaysshenoy.json_parser.ast

sealed class JsonToken {
    object BeginObject: JsonToken()
    object EndObject: JsonToken()
}