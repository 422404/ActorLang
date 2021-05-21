package org.actorlang

import org.actorlang.parser.impl.AntlrParser

fun main(args: Array<String>) {
    println("Hello World!")
    val parser = AntlrParser("<test>")
    val ast = parser.parse("""
        Ca () ["init", V] = become Cb (V);
        Cb (V) [X] = become Cb (V + X);
        Cb (V) ["show"] = display V;
    """.trimIndent())
    println(ast)
}
