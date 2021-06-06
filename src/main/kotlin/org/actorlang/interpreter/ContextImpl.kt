package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.objects.ActorType
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.interpreter.scheduler.SchedulerSynchronization
import java.io.PrintStream

class ContextImpl(
    override val configuration: Configuration,
    override val out: PrintStream,
    override val communicationsManager: CommunicationsSender,
    override val communicationsBinder: CommunicationsBinder,
    override val scheduler: Scheduler,
    override val schedulerSynchronization: SchedulerSynchronization
) : Context {
    override val actorTypes = mutableMapOf<String, ActorType>()
}
