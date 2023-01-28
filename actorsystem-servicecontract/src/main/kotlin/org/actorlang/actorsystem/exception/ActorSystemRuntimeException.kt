package org.actorlang.actorsystem.exception

/**
 * A generic exception thrown by the actor system.
 */
open class ActorSystemRuntimeException : Exception {
    constructor() : super()
    constructor(msg: String) : super(msg)
}
