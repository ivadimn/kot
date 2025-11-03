package dogs

class Administrator {

    private val repository = DogsRepository.getInstance("qwerty")

    private fun addDog() {
        print("Введите кличку: ")
        val dogName = readln().trim()
        print("Введите породу: ")
        val breedName = readln().trim()
        print("Введите вес: ")
        val weight = readln().toInt()
        DogInvoker.addCommand(AdministratorCommand.Add(repository, dogName, breedName, weight))

    }

    private fun deleteDog() {
        print("Введите ID: ")
        val id = readln().toInt()
        DogInvoker.addCommand(AdministratorCommand.Delete(repository, id))
    }

    fun work() {
        val operations = Operation.entries
        while (true) {
            print("Выберите операцию: ")
            for ((index, operation) in operations.withIndex()) {
                print("$index - ${operation.title}")
                if (index < operations.lastIndex)
                    print(", ")
            }
            print(": ")
            val operationIndex = readln().toInt()
            val operation = operations[operationIndex]
            when (operation) {
                Operation.EXIT -> {
                    DogInvoker.addCommand(AdministratorCommand.Save(repository))
                    break
                }
                Operation.ADD_DOG -> addDog()
                Operation.DELETE_DOG -> deleteDog()
            }
        }
    }
}