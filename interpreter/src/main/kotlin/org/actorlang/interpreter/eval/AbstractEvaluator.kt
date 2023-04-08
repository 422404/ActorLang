package org.actorlang.interpreter.eval

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.actorsystem.messaging.ActorRef
import org.actorlang.ast.AssignNode
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BinaryOpNode
import org.actorlang.ast.BinaryOpType
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.CallNode
import org.actorlang.ast.CreateNode
import org.actorlang.ast.DisplayNode
import org.actorlang.ast.ExpressionNode
import org.actorlang.ast.ForNode
import org.actorlang.ast.FunctionCallNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IfNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.PutNode
import org.actorlang.ast.ReturnNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode
import org.actorlang.ast.UnaryOpType
import org.actorlang.ast.visitor.BaseAstVisitor
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exception.ActorLangRuntimeException
import org.actorlang.interpreter.exception.FunctionReturnException
import org.actorlang.interpreter.exception.UnknownFunctionException
import org.actorlang.interpreter.exception.WrongActorStateNameException
import org.actorlang.interpreter.objects.impl.ActorLangMessage
import org.actorlang.parser.Position
import java.util.LinkedList

abstract class AbstractEvaluator(
    protected val context: Context,
    protected val actorSystem: ActorSystem
) : BaseAstVisitor() {
    protected var result: Any? = null

    protected val activeScopes = LinkedList<Scope>()
    protected val currentScope
        get() = activeScopes.last!!

    protected fun throwWithPosition(position: Position, msg: String): Nothing {
        throw ActorLangRuntimeException(msg, position)
    }

    protected fun visitExpression(node: ExpressionNode): Any {
        visit(node)
        return result!!
    }

    private fun or(a: Any, b: Any, position: Position): Boolean {
        if (a is Boolean && b is Boolean) {
            return a || b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot apply 'or' to ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun and(a: Any, b: Any, position: Position): Boolean {
        if (a is Boolean && b is Boolean) {
            return a && b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot apply 'and' to ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun eq(a: Any, b: Any, position: Position): Boolean {
        if (a::class == b::class) {
            return a == b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot check equality of ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun neq(a: Any, b: Any, position: Position): Boolean {
        if (a::class == b::class) {
            return a != b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot check inequality of ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun lower(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a < b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun leq(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a <= b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun greater(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a > b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun geq(a: Any, b: Any, position: Position): Boolean {
        if (a is Int && b is Int) {
            return a >= b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compare ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun add(a: Any, b: Any, position: Position): Any {
        return if (a is Int && b is Int) {
            a + b
        } else if (a is String || b is String) {
            "$a$b"
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot add ${a::class.simpleName} to ${b::class.simpleName}"
            )
        }
    }

    private fun sub(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a - b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot sub ${a::class.simpleName} to ${b::class.simpleName}"
            )
        }
    }

    private fun mul(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a * b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot mul ${a::class.simpleName} by ${b::class.simpleName}"
            )
        }
    }

    private fun div(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a / b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot div by ${a::class.simpleName} by ${b::class.simpleName}"
            )
        }
    }

    private fun mod(a: Any, b: Any, position: Position): Int {
        if (a is Int && b is Int) {
            return a % b
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compute modulo of ${a::class.simpleName} and ${b::class.simpleName}"
            )
        }
    }

    private fun plus(a: Any, position: Position): Int {
        if (a is Int) {
            return +a
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot make ${a::class.simpleName} positive"
            )
        }
    }

    private fun minus(a: Any, position: Position): Int {
        if (a is Int) {
            return -a
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot make ${a::class.simpleName} negative"
            )
        }
    }

    private fun not(a: Any, position: Position): Boolean {
        if (a is Boolean) {
            return !a
        } else {
            throwWithPosition(
                position,
                "Type mismatch, cannot compute 'not' on ${a::class.simpleName}"
            )
        }
    }

    protected fun returnFromFunction(expression: ExpressionNode) {
        throw FunctionReturnException(visitExpression(expression))
    }

    abstract override fun visit(node: BecomeNode)
    abstract override fun visit(node: BehaviorNode)
    abstract override fun visit(node: SelfLiteralNode)
    abstract override fun visit(node: FunctionDefNode)

    override fun visit(node: AssignNode) {
        currentScope.set(node.variable.name, visitExpression(node.value), node.startPosition)
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
        val actorStateClass = context.actorStateClasses[node.behaviorName.name]
            ?: throw WrongActorStateNameException(node.behaviorName.name, node.startPosition)

        if (node.stateValues.size != actorStateClass.stateVarsNames.size) {
            throwWithPosition(
                node.startPosition,
                "Wrong arity in actor type. Previously declared " +
                    "'${actorStateClass.stateName}' has an arity of " +
                    "${actorStateClass.stateVarsNames.size} instead of " +
                    "${node.stateValues.size}"
            )
        }
        val stateValues = node.stateValues.map(this::visitExpression).toTypedArray()
        val actor = actorSystem.createActorWithState(actorStateClass.create(stateValues, node.startPosition))
        result = actor.ref
    }

    override fun visit(node: DisplayNode) {
        context.stdout.println(visitExpression(node.value))
    }

    override fun visit(node: ForNode) {
        activeScopes.add(BaseScope(currentScope))
        val scope = currentScope
        val begin = visitExpression(node.range.first)
        val end = visitExpression(node.range.second)
        if (begin is Int && end is Int) {
            val range = if (begin <= end) begin..end else begin downTo end
            range.forEach { i ->
                scope.set(node.variable.name, i, node.startPosition)
                node.statements.forEach { visit(it) }
            }
        } else {
            throwWithPosition(
                node.startPosition,
                "A 'for' range must be composed of two integers"
            )
        }
    }

    override fun visit(node: ReturnNode) {
        returnFromFunction(node.expression)
    }

    override fun visit(node: FunctionCallNode) {
        val functionName = node.functionName.name
        val function = context.functions[functionName]
            ?: throw UnknownFunctionException(functionName, node.startPosition)
        result = function.call(
            node.args.map { visitExpression(it) }.toTypedArray(),
            context
        )
    }

    override fun visit(node: CallNode) {
        visit(node.functionCall)
        result = Unit
    }

    override fun visit(node: IdentifierNode) {
        // Only visited while reading a variable
        result = currentScope.get(node.name, node.startPosition)
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
            throwWithPosition(
                node.startPosition,
                "Conditions in 'if' must be of boolean type"
            )
        }
    }

    override fun visit(node: IntegerLiteralNode) {
        result = node.value
    }

    override fun visit(node: PutNode) {
        context.stdout.print(visitExpression(node.value))
    }

    override fun visit(node: SendNode) {
        val items = node.messageItems.map(this::visitExpression).toTypedArray()
        val targetActor = visitExpression(node.target)

        if (targetActor is ActorRef) {
            val message = ActorLangMessage(targetActor, items)
            actorSystem.messagingServer.sendMessage(message)
        } else {
            throwWithPosition(
                node.startPosition,
                "Cannot send a message to an object that is not an actor reference"
            )
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
