package org.actorlang.ast.printer

import org.actorlang.parser.impl.AntlrParserFactory
import org.junit.jupiter.api.Test

class AstPrettyPrinterTest {
    @Test
    fun `Can pretty print AST`() {
        val parser = AntlrParserFactory().createParser()
        val ast = parser.parse(
            """
            fun F(x, y) = x + 2 * y;
            
            Computation (Printer) [x, y] = {
                send [F(x, y)] to Printer
            };
            
            ComputationLauncher (Printer) [x, y] = {
                computation = create Computation(Printer);
                send [x, y] to computation
            };
            
            Printer () [value] = display value;
            
            printer = create Printer();
            launcher = create ComputationLauncher(printer);
            
            send [20, 11] to launcher
            """.trimIndent(),
            "<test>"
        )

        val prettyPrinter = AstPrettyPrinter(ast, 2)
        prettyPrinter.printAst()
    }
}
