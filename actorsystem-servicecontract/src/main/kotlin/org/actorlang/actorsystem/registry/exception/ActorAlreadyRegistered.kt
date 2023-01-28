package org.actorlang.actorsystem.registry.exception

class ActorAlreadyRegistered(actorName: String) : ActorRegistryException("Actor '$actorName' already registered")
