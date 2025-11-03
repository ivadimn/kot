package users

import command.Command
import java.net.IDN

sealed interface AdministratorCommand: Command {
     data class Add(
         val repository: UserRepository,
         val firstName: String,
         val secondName: String,
         val age: Int
     ) : AdministratorCommand {
         override fun execute() {
             repository.add(firstName, secondName, age)
         }
     }

     data class Delete(
         val repository: UserRepository,
         val id: Int
     ) : AdministratorCommand {
         override fun execute() {
             repository.delete(id)
         }
     }

    data class Save(
        val repository: UserRepository
    ) : AdministratorCommand {
        override fun execute() {
            repository.save()
        }
    }
 }

