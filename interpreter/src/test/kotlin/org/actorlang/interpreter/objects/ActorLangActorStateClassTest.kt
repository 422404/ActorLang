package org.actorlang.interpreter.objects

import org.actorlang.interpreter.exception.WrongActorStateArityException
import org.mockito.kotlin.mock
import kotlin.test.Test
import kotlin.test.assertFailsWith

class ActorLangActorStateClassTest {

    @Test
    fun `An actor state cannot be instantiated if there is a mismatch in the state variables count`() {
        // There is 3 state variables declared
        val stateVarsNames = arrayOf("a", "b", "c")
        val actorStateClass = ActorLangActorStateClass("TestState", stateVarsNames, mock())

        assertFailsWith<WrongActorStateArityException> {
            // Only 2 state variable values are supplied versus the 3 expected
            actorStateClass.create(arrayOf(1, "hello"), mock())
        }
    }
}
