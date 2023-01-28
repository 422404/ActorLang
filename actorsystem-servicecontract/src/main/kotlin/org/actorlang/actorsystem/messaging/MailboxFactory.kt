package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.Actor
import org.actorlang.actorsystem.ActorSystem

interface MailboxFactory {
    fun createMailbox(actorSystem: ActorSystem, actor: Actor): Mailbox
}
