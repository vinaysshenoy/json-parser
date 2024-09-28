package com.vinaysshenoy.json_parser.ast

sealed class AstNode {
    // Root objects
    data class JsonObject(
        val children: List<ChildNode<*>>
    ): AstNode()
    class JsonArray(): AstNode()

    // Child objects
    sealed class ChildNode<T>(): AstNode() {
        abstract val name: String
        abstract val value: T
        abstract val type: NodeType

        data class IntegerNode(
            override val name: String,
            override val value: Int
        ): ChildNode<Int>() {
            override val type: NodeType = NodeType.Int
        }
    }
}