package org.actorlang.actorsystem.events

interface EventListener {
    /**
     * Invoked each time an event is dispatched.
     * @param event The dispatched event
     */
    fun onEvent(event: Event)
}
