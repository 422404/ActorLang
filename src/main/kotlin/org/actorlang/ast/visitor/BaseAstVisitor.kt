package org.actorlang.ast.visitor

import org.actorlang.ast.AssignNode
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BinaryOpNode
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.CallNode
import org.actorlang.ast.CreateNode
import org.actorlang.ast.DisplayNode
import org.actorlang.ast.ForNode
import org.actorlang.ast.FunctionCallNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IfNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.MessagePatternItem
import org.actorlang.ast.Node
import org.actorlang.ast.PutNode
import org.actorlang.ast.ReturnNode
import org.actorlang.ast.RootNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode

open class BaseAstVisitor : AstVisitor {
    fun visit(node: Node) = when (node) {
        is AssignNode -> visit(node)
        is BecomeNode -> visit(node)
        is BehaviorNode -> visit(node)
        is BinaryOpNode -> visit(node)
        is BooleanLiteralNode -> visit(node)
        is CreateNode -> visit(node)
        is DisplayNode -> visit(node)
        is ForNode -> visit(node)
        is ReturnNode -> visit(node)
        is FunctionCallNode -> visit(node)
        is FunctionDefNode -> visit(node)
        is CallNode -> visit(node)
        is IdentifierNode -> visit(node)
        is IfNode -> visit(node)
        is IntegerLiteralNode -> visit(node)
        is PutNode -> visit(node)
        is RootNode -> visit(node)
        is SelfLiteralNode -> visit(node)
        is SendNode -> visit(node)
        is StringLiteralNode -> visit(node)
        is UnaryOpNode -> visit(node)
        else -> throw IllegalStateException("BaseAstVisitor: Unknown AST node")
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

    override fun visit(node: ForNode) {
        visit(node.variable)
        node.statements.forEach { visit(it) }
    }

    override fun visit(node: ReturnNode) {
        visit(node.expression)
    }

    override fun visit(node: FunctionCallNode) {
        visit(node.functionName)
        node.args.forEach {
            visit(it)
        }
    }

    override fun visit(node: FunctionDefNode) {
        visit(node.functionName)
        node.argsNames.forEach {
            visit(it)
        }
        node.returnExpression?.let {
            visit(it)
        }
        node.statements?.forEach {
            visit(it)
        }
    }

    override fun visit(node: CallNode) {
        visit(node.functionCall)
    }

    override fun visit(node: IdentifierNode) {
    }

    override fun visit(node: IfNode) {
        visit(node.condition)
        node.thenStatements.forEach {
            visit(it)
        }
        node.elseStatements.forEach {
            visit(it)
        }
    }

    override fun visit(node: IntegerLiteralNode) {
    }

    override fun visit(node: PutNode) {
        visit(node.value)
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
