package org.actorlang.ast.printer

import org.actorlang.ast.*
import org.actorlang.ast.visitor.BaseAstVisitor

class AstPrettyPrinter(
    val node: Node,
    indentSize: Int
): BaseAstVisitor() {
    private val printer = PrettyPrinter(indentSize)

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

    override fun visit(node: IdentifierNode) {
        printer.print(node.name)
    }

    override fun visit(node: IntegerLiteralNode) {
        printer.print(node.value)
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
