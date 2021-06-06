package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.objects.ActorType
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.interpreter.scheduler.SchedulerSynchronization
import java.io.PrintStream

interface Context {
    val configuration: Configuration
    val out: PrintStream
    val communicationsManager: CommunicationsSender
    val communicationsBinder: CommunicationsBinder
    val scheduler: Scheduler
    val schedulerSynchronization: SchedulerSynchronization
    val actorTypes: MutableMap<String, ActorType>
}
