package par613

import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

class RemoteControl : Invoker<Command> {
    override val commands = LinkedBlockingDeque<Command>()

    init {
        thread {
            while (true) {
                val command = commands.take()
                command.execute()
            }
        }
    }

    override fun executeCommand(command: Command) {
        commands.add(command)
    }
}