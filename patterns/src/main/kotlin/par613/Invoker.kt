package par613

import java.util.concurrent.LinkedBlockingDeque

interface Invoker<T : Command> {
    val commands : LinkedBlockingDeque<Command>

    fun executeCommand(command: T)
}