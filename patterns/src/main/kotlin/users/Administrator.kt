package users

class Administrator {

    private val repository = UserRepository.getInstance("qwerty")

    private fun addUser() {
        print("Введите имя: ")
        val firstName = readln().trim()
        print("Введите фамилию: ")
        val secondName = readln().trim()
        print("Введите возраст: ")
        val age = readln().toInt()
        UserInvoker.addCommand(AdministratorCommand.Add(repository, firstName, secondName, age))
    }

    private fun deleteUser()  {
        print("Введите ID: ")
        val id = readln().toInt()
        UserInvoker.addCommand(AdministratorCommand.Delete(repository, id))

    }

    fun work() {
        val lock = Any()
        while (true) {
            val operations = Operation.entries
            print("Введите операцию: ")
            for ((index, operation) in operations.withIndex()) {
                print("$index - ${operation.title}")
                if (index < operations.lastIndex)
                    print(", ")
            }
            print(": ")
            val operationIndex = readln().toInt()
            val operation = operations[operationIndex]

            when(operation) {
                Operation.EXIT -> {
                    UserInvoker.addCommand(AdministratorCommand.Save(repository))
                    break
                }
                Operation.ADD_USER -> addUser()
                Operation.DELETE_USER -> deleteUser()
            }
        }
        repository.save()
    }
}