package dogs

import command.Command

sealed interface AdministratorCommand: Command {
    data class Add(
        val repository: DogsRepository,
        val dogName: String,
        val breedName: String,
        val weight: Int
    ) : AdministratorCommand {
        override fun execute() {
            repository.add(dogName, breedName, weight)
        }
    }

    data class Delete(
        val repository: DogsRepository,
        val id: Int
    ) : AdministratorCommand {
        override fun execute() {
            repository.delete(id)
        }
    }

    data class Save(
        val repository: DogsRepository
    ) : AdministratorCommand {
        override fun execute() {
            repository.save()
        }
    }
}

