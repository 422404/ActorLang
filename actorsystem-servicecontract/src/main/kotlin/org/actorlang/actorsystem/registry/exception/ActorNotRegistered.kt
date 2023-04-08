package org.actorlang.actorsystem.registry.exception

class ActorNotRegistered(actorName: String) : ActorRegistryException("Actor '$actorName' is not registered")
