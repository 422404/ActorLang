package org.actorlang.ast.visitor

import org.actorlang.ast.AssignNode
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BinaryOpNode
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.CreateNode
import org.actorlang.ast.DisplayNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IfNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.RootNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode

interface AstVisitor {
    fun visit(node: AssignNode)
    fun visit(node: BecomeNode)
    fun visit(node: BehaviorNode)
    fun visit(node: BinaryOpNode)
    fun visit(node: BooleanLiteralNode)
    fun visit(node: CreateNode)
    fun visit(node: DisplayNode)
    fun visit(node: IdentifierNode)
    fun visit(node: IfNode)
    fun visit(node: IntegerLiteralNode)
    fun visit(node: RootNode)
    fun visit(node: SelfLiteralNode)
    fun visit(node: SendNode)
    fun visit(node: StringLiteralNode)
    fun visit(node: UnaryOpNode)
}
