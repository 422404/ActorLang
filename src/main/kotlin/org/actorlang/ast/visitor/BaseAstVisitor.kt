package org.actorlang.ast.visitor

import org.actorlang.ast.*

open class BaseAstVisitor: AstVisitor {
    fun visit(node: Node) = when (node) {
        is AssignNode -> visit(node)
        is BecomeNode -> visit(node)
        is BehaviorNode -> visit(node)
        is BinaryOpNode -> visit(node)
        is BooleanLiteralNode -> visit(node)
        is CreateNode -> visit(node)
        is DisplayNode -> visit(node)
        is IdentifierNode -> visit(node)
        is IntegerLiteralNode -> visit(node)
        is RootNode -> visit(node)
        is SelfLiteralNode -> visit(node)
        is SendNode -> visit(node)
        is StringLiteralNode -> visit(node)
        is UnaryOpNode -> visit(node)
        else -> throw IllegalStateException()
    }

    fun visit(node: MessagePatternItem) = when (node) {
        is BooleanLiteralNode -> visit(node)
        is IdentifierNode -> visit(node)
        is IntegerLiteralNode -> visit(node)
        is StringLiteralNode -> visit(node)
        else -> throw IllegalStateException()
    }

    override fun visit(node: AssignNode) {
        visit(node.variable)
        visit(node.value)
    }

    override fun visit(node: BecomeNode) {
        visit(node.behaviorName)
        node.stateValues.forEach {
            visit(it)
        }
    }

    override fun visit(node: BehaviorNode) {
        visit(node.name)
        node.stateVars.forEach {
            visit(it)
        }
        node.messagePatternItems.forEach {
            visit(it)
        }
        node.statements.forEach {
            visit(it)
        }
    }

    override fun visit(node: BinaryOpNode) {
        visit(node.left)
        if (node.right != null) {
            visit(node.right)
        }
    }

    override fun visit(node: BooleanLiteralNode) {
    }

    override fun visit(node: CreateNode) {
        visit(node.behaviorName)
        node.stateValues.forEach {
            visit(it)
        }
    }

    override fun visit(node: DisplayNode) {
        visit(node.value)
    }

    override fun visit(node: IdentifierNode) {
    }

    override fun visit(node: IntegerLiteralNode) {
    }

    override fun visit(node: RootNode) {
        node.toplevelStatements.forEach {
            visit(it)
        }
    }

    override fun visit(node: SelfLiteralNode) {
    }

    override fun visit(node: SendNode) {
        node.messageItems.forEach {
            visit(it)
        }
        visit(node.target)
    }

    override fun visit(node: StringLiteralNode) {
    }

    override fun visit(node: UnaryOpNode) {
        visit(node.operand)
    }
}