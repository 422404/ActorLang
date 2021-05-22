package org.actorlang.ast.visitor

import org.actorlang.ast.*

interface AstVisitor {
    fun visit(node: AssignNode)
    fun visit(node: BecomeNode)
    fun visit(node: BehaviorNode)
    fun visit(node: BinaryOpNode)
    fun visit(node: BooleanLiteralNode)
    fun visit(node: CreateNode)
    fun visit(node: DisplayNode)
    fun visit(node: IdentifierNode)
    fun visit(node: IntegerLiteralNode)
    fun visit(node: RootNode)
    fun visit(node: SelfLiteralNode)
    fun visit(node: SendNode)
    fun visit(node: StringLiteralNode)
    fun visit(node: UnaryOpNode)
}
