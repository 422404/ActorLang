package org.actorlang.ast.printer

class PrettyPrinter(
    val indentSize: Int
) {
    private var indentLevel = 0
    private var newline = true

    fun indent() {
        indentLevel++
    }

    fun dedent() {
        if (indentLevel > 0) {
            indentLevel--
        }
    }

    fun indent(action: ()->Unit) {
        indent()
        action()
        dedent()
    }

    fun print(s: String) {
        printIndentIfNewline()
        kotlin.io.print(s)
    }

    fun print(i: Int) {
        printIndentIfNewline()
        kotlin.io.print(i)
    }

    fun print(o: Any) {
        printIndentIfNewline()
        kotlin.io.print(o.toString())
    }

    fun println(s: String) {
        printIndentIfNewline()
        kotlin.io.println(s)
        newline = true
    }

    fun println(i: Int) {
        printIndentIfNewline()
        kotlin.io.println(i)
        newline = true
    }

    fun println(o: Any) {
        printIndentIfNewline()
        kotlin.io.println(o.toString())
        newline = true
    }

    fun println() {
        kotlin.io.println()
        newline = true
    }

    private fun printIndentIfNewline() {
        if (newline) {
            newline = false
            for (i in 0 until indentLevel) {
                for (j in 0 until indentSize) {
                    print(' ')
                }
            }
        }
    }
}
