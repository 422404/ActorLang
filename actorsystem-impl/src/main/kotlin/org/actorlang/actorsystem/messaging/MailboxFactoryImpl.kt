package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.Actor
import org.actorlang.actorsystem.ActorSystem

class MailboxFactoryImpl : MailboxFactory {
    override fun createMailbox(actorSystem: ActorSystem, actor: Actor): Mailbox {
        return MailboxImpl(actorSystem, actor)
    }
}
