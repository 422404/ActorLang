package org.actorlang

import org.actorlang.ast.printer.AstPrettyPrinter
import org.actorlang.config.Configuration
import org.actorlang.interpreter.InterpreterImpl
import org.actorlang.interpreter.comms.CommunicationsManager
import org.actorlang.interpreter.scheduler.SchedulerImpl
import org.actorlang.parser.impl.AntlrParser

fun main() {
    /* val code = """
        Ca () ["init", V] = become Cb (V);
        
        Cb (V) [X] = become Cb (V + X);
        Cb (V) ["inc"] = become Cb (V + 1);
        Cb (V) ["show"] = display V;
        
        Ctest (X, A) ["hello"] = { X = X + 1;
                                   send [X] to A };
        CbinOp () ["test"] = display true || !false;
        CbinOp () ["nice"] = display 2 * (8 / 1337);
        CbinOp () ["wow"] = A = create Cb (1337);
    """.trimIndent() */

    val code = """
        Cinc (X) ["inc"] = become Cinc (X + 1);
        Cinc (X) ["show"] = display X;

        Inc = create Cinc (25);
        send ["inc"] to Inc;
        send ["show"] to Inc;
    """.trimIndent()

    AstPrettyPrinter(AntlrParser("<test>").parse(code), 2).printAst()
    println()

    val config = Configuration().apply {
        debug = true
        messageDuplicates = false
        outOfOrderMessages = false
    }
    val communicationsManager = CommunicationsManager()
    val scheduler = SchedulerImpl()
    val interpreter = InterpreterImpl(
        config,
        System.out,
        communicationsManager,
        communicationsManager,
        scheduler
    )

    println("---- start system ----")
    interpreter.run(code, "<test>")
    println("---- stop system -----")
}
