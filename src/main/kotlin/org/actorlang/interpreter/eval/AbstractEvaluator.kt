package org.actorlang.interpreter.eval

import org.actorlang.ast.AssignNode
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BinaryOpNode
import org.actorlang.ast.BinaryOpType
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.CreateNode
import org.actorlang.ast.DisplayNode
import org.actorlang.ast.ExpressionNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IfNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode
import org.actorlang.ast.UnaryOpType
import org.actorlang.ast.visitor.BaseAstVisitor
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.objects.Actor
import org.actorlang.parser.Position
import java.util.LinkedList

abstract class AbstractEvaluator(
    protected val context: Context
): BaseAstVisitor() {
    protected var result: Any? = null

    protected val activeScopes = LinkedList<Scope>()
    protected val currentScope
        get() = activeScopes.last!!

    protected fun throwWithPosition(position: Position, msg: String): Nothing {
        val newMsg = "Exception at ${position.sourceName}:${position.line}:${position.column}: $msg"
        throw ActorLangRuntimeException(newMsg)
    }

    protected fun rethrowWithPosition(position: Position, e: ActorLangRuntimeException): Nothing {
        throwWithPosition(position, e.message!!)
    }

    protected fun visitExpression(node: ExpressionNode): Any {
        visit(node)
        return result!!
    }

    private fun or(a: Any, b: Any, position: Position): Boolean {
        if (a is Boolean && b is Boolean) {
            return a || b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot apply 'or' to ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun and(a: Any, b: Any, position: Position): Boolean {
        if (a is Boolean && b is Boolean) {
            return a && b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot apply 'and' to ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun eq(a: Any, b: Any, position: Position): Boolean {
        if (a::class == b::class) {
            return a == b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot check equality of ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun neq(a: Any, b: Any, position: Position): Boolean {
        if (a::class == b::class) {
            return a != b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot check inequality of ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun lower(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a < b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun leq(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a <= b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun greater(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a > b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun geq(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a >= b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun add(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a + b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot add ${a::class.simpleName} to ${b::class.simpleName}")
        }
    }

    private fun sub(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a - b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot sub ${a::class.simpleName} to ${b::class.simpleName}")
        }
    }

    private fun mul(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a * b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot mul ${a::class.simpleName} by ${b::class.simpleName}")
        }
    }

    private fun div(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a / b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot div by ${a::class.simpleName} by ${b::class.simpleName}")
        }
    }

    private fun mod(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a % b
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compute modulo of ${a::class.simpleName} and ${b::class.simpleName}")
        }
    }

    private fun plus(a: Any, position: Position): Int {
        if (a is Int) {
            return +a
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot make ${a::class.simpleName} positive")
        }
    }

    private fun minus(a: Any, position: Position): Int {
        if (a is Int) {
            return -a
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot make ${a::class.simpleName} negative")
        }
    }

    private fun not(a: Any, position: Position): Boolean {
        if (a is Boolean) {
            return !a
        } else {
            throwWithPosition(position,
                "Type mismatch, cannot compute 'not' on ${a::class.simpleName}")
        }
    }

    abstract override fun visit(node: BecomeNode)
    abstract override fun visit(node: BehaviorNode)
    abstract override fun visit(node: SelfLiteralNode)

    override fun visit(node: AssignNode) {
        currentScope[node.variable.name] = visitExpression(node.value)
    }

    override fun visit(node: BinaryOpNode) {
        val left = visitExpression(node.left)
        val right = visitExpression(node.right!!)

        result = when (node.type) {
            BinaryOpType.OR -> or(left, right, node.startPosition)
            BinaryOpType.AND -> and(left, right, node.startPosition)
            BinaryOpType.EQ -> eq(left, right, node.startPosition)
            BinaryOpType.NEQ -> neq(left, right, node.startPosition)
            BinaryOpType.LOWER -> lower(left, right, node.startPosition)
            BinaryOpType.LEQ -> leq(left, right, node.startPosition)
            BinaryOpType.GREATER -> greater(left, right, node.startPosition)
            BinaryOpType.GEQ -> geq(left, right, node.startPosition)
            BinaryOpType.ADD -> add(left, right, node.startPosition)
            BinaryOpType.SUB -> sub(left, right, node.startPosition)
            BinaryOpType.MUL -> mul(left, right, node.startPosition)
            BinaryOpType.DIV -> div(left, right, node.startPosition)
            BinaryOpType.MOD -> mod(left, right, node.startPosition)
        }
    }

    override fun visit(node: BooleanLiteralNode) {
        result = node.value
    }

    override fun visit(node: CreateNode) {
        val actorType = context.actorTypes[node.behaviorName.name]

        if (actorType == null) {
            throwWithPosition(node.startPosition,
                "Actor type '${node.behaviorName.name}' not declared")
        } else {
            if (node.stateValues.size != actorType.stateVarNames.size) {
                throwWithPosition(node.startPosition,
                    "Wrong arity in actor type. Previously declared " +
                            "'${actorType.name}' has an arity of " +
                            "${actorType.stateVarNames.size} instead of " +
                            "${node.stateValues.size}")
            }
            val stateValues = node.stateValues.map(this::visitExpression).toTypedArray()
            val actor = Actor(actorType, stateValues, context)
            result = actor
            actor.run()
        }
    }

    override fun visit(node: DisplayNode) {
        context.out.println(visitExpression(node.value))
    }

    override fun visit(node: IdentifierNode) {
        // Only visited while reading a variable
        result = currentScope[node.name]
    }

    override fun visit(node: IfNode) {
        val condition = visitExpression(node.condition)
        if (condition is Boolean) {
            if (condition) {
                node.thenStatements.forEach { visit(it) }
            } else {
                node.elseStatements.forEach { visit(it) }
            }
        } else {
            throwWithPosition(node.startPosition,
                "Conditions in 'if' must be of boolean type")
        }
    }

    override fun visit(node: IntegerLiteralNode) {
        result = node.value
    }

    override fun visit(node: SendNode) {
        val items = node.messageItems.map(this::visitExpression).toTypedArray()
        val targetActor = visitExpression(node.target)

        if (targetActor is Actor) {
            val message = Message(items)
            context.communicationsManager.send(message, targetActor)
        } else {
            throwWithPosition(node.startPosition,
                "Cannot send a message to an object that is not an actor")
        }
    }

    override fun visit(node: StringLiteralNode) {
        result = node.text
    }

    override fun visit(node: UnaryOpNode) {
        val operand = visitExpression(node.operand)

        result = when (node.type) {
            UnaryOpType.PLUS -> plus(operand, node.startPosition)
            UnaryOpType.MINUS -> minus(operand, node.startPosition)
            UnaryOpType.NOT -> not(operand, node.startPosition)
        }
    }
}
