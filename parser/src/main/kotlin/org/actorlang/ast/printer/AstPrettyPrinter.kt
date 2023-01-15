package org.actorlang.ast.printer

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
import org.actorlang.ast.Node
import org.actorlang.ast.PutNode
import org.actorlang.ast.ReturnNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode
import org.actorlang.ast.visitor.BaseAstVisitor

class AstPrettyPrinter(
    val node: org.actorlang.ast.Node,
    indentSize: Int
) : BaseAstVisitor() {
    private val printer = org.actorlang.ast.printer.PrettyPrinter(indentSize)

    fun printAst() {
        visit(node)
    }

    override fun visit(node: AssignNode) {
        printer.apply {
            println("AssignNode {")
            indent {
                print(node.variable.name)
                print(" = ")
                visit(node.value)
                println()
            }
            println("}")
        }
    }

    override fun visit(node: BecomeNode) {
        printer.apply {
            println("BecomeNode {")
            indent {
                println("behavior = ${node.behaviorName.name}")
                println("state = (")
                indent {
                    node.stateValues.forEach {
                        visit(it)
                        println()
                    }
                }
                println(")")
            }
            println("}")
        }
    }

    override fun visit(node: BehaviorNode) {
        printer.apply {
            println("BehaviorNode {")
            indent {
                println("name = ${node.name.name}")
                print("state = (")
                node.stateVars.forEachIndexed { i, variable ->
                    print(variable.name)
                    if (i < node.stateVars.size - 1) {
                        print(", ")
                    }
                }
                println(")")
                print("message pattern = [")
                node.messagePatternItems.forEachIndexed { i, item ->
                    visit(item)
                    if (i < node.messagePatternItems.size - 1) {
                        print(", ")
                    }
                }
                println("]")
                println("statements = {")
                indent {
                    node.statements.forEach {
                        visit(it)
                    }
                }
                println("}")
            }
            println("}")
        }
    }

    override fun visit(node: BinaryOpNode) {
        printer.apply {
            println("BinaryOpNode {")
            indent {
                println("type = ${node.type.name}")
                print("left = ")
                visit(node.left)
                println()
                if (node.right != null) {
                    print("right = ")
                    visit(node.right)
                    println()
                }
            }
            println("}")
        }
    }

    override fun visit(node: BooleanLiteralNode) {
        printer.print(if (node.value) "true" else "false")
    }

    override fun visit(node: CreateNode) {
        printer.apply {
            println("CreateNode {")
            indent {
                println("behavior = ${node.behaviorName.name}")
                println("state = (")
                indent {
                    node.stateValues.forEach {
                        visit(it)
                        println()
                    }
                }
                println(")")
            }
            println("}")
        }
    }

    override fun visit(node: DisplayNode) {
        printer.apply {
            println("DisplayNode {")
            indent {
                visit(node.value)
                println()
            }
            println("}")
        }
    }

    override fun visit(node: ForNode) {
        printer.apply {
            println("ForNode {")
            indent {
                println("variable = ${node.variable.name}")
                print("range = ")
                visit(node.range.first)
                print("..")
                visit(node.range.second)
                println()
                println("statements = {")
                indent {
                    node.statements.forEach { visit(it) }
                }
                println("}")
            }
            println("}")
        }
    }

    override fun visit(node: ReturnNode) {
        printer.apply {
            println("ReturnNode {")
            indent {
                visit(node.expression)
                println()
            }
            println("}")
        }
    }

    override fun visit(node: FunctionCallNode) {
        printer.apply {
            println("FunctionCallNode {")
            indent {
                println("functionName = ${node.functionName.name}")
                println("args = {")
                indent {
                    node.args.forEach { visit(it) }
                }
                println("}")
            }
            println("}")
        }
    }

    override fun visit(node: FunctionDefNode) {
        printer.apply {
            println("FunctionDefNode {")
            indent {
                println("functionName = ${node.functionName.name}")
                println("args = {")
                indent {
                    node.argsNames.forEachIndexed { i, argName ->
                        print(argName.name)
                        if (i < node.argsNames.size - 1) {
                            print(", ")
                        }
                    }
                }
                println()
                println("}")
                println("statements = {")
                indent {
                    if (node.returnExpression != null) {
                        visit(node.returnExpression)
                    } else {
                        node.statements?.forEach { visit(it) }
                    }
                }
                println("}")
            }
            println("}")
        }
    }

    override fun visit(node: CallNode) {
        printer.apply {
            println("CallNode {")
            indent {
                visit(node.functionCall)
            }
            println("}")
        }
    }

    override fun visit(node: IdentifierNode) {
        printer.print(node.name)
    }

    override fun visit(node: IfNode) {
        printer.apply {
            println("IfNode {")
            indent {
                print("if = ")
                visit(node.condition)
                println()
                println("then {")
                indent {
                    node.thenStatements.forEach {
                        visit(it)
                    }
                }
                if (node.elseStatements.isEmpty()) {
                    println("}")
                } else {
                    println("} else {")
                    indent {
                        node.elseStatements.forEach {
                            visit(it)
                        }
                    }
                    println("}")
                }
            }
            println("}")
        }
    }

    override fun visit(node: IntegerLiteralNode) {
        printer.print(node.value)
    }

    override fun visit(node: PutNode) {
        printer.apply {
            println("PutNode {")
            indent {
                visit(node.value)
                println()
            }
            println("}")
        }
    }

    override fun visit(node: SelfLiteralNode) {
        printer.print("self")
    }

    override fun visit(node: SendNode) {
        printer.apply {
            println("SendNode {")
            indent {
                println("message = [")
                indent {
                    node.messageItems.forEach {
                        visit(it)
                        println()
                    }
                }
                println("]")
                println("target = ${node.target.name}")
            }
            println("}")
        }
    }

    override fun visit(node: StringLiteralNode) {
        printer.print("\"${node.text}\"")
    }

    override fun visit(node: UnaryOpNode) {
        printer.apply {
            println("UnaryOpNode {")
            indent {
                println("type = ${node.type.name}")
                print("operand = ")
                visit(node.operand)
                println()
            }
            println("}")
        }
    }
}
