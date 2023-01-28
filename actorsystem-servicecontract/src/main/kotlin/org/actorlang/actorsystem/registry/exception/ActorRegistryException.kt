package org.actorlang.actorsystem.registry.exception

import org.actorlang.actorsystem.exception.ActorSystemRuntimeException

open class ActorRegistryException : ActorSystemRuntimeException {
    constructor() : super()
    constructor(msg: String) : super(msg)
}
