package command

import java.util.concurrent.LinkedBlockingDeque

interface Invoker<T : Command> {
    val commands : LinkedBlockingDeque<Command>

    fun addCommand(command: T)
}