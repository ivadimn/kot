package users

import command.Command
import command.Invoker
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

object UserInvoker : Invoker<AdministratorCommand> {
    override val commands = LinkedBlockingDeque<Command>()

    init {
        thread {
            while (true) {
                val command = commands.take()
                command.execute()
            }
        }
    }

    override fun addCommand(command: AdministratorCommand) {
        commands.add(command)
    }
}