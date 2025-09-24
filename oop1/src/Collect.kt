fun main() {
    val listUser = listOf<String>("User0", "User1", "User2", "User3", "User4",
                                  "User5", "User6", "User7", "User8", "User9")
    val users = mutableListOf<String>()
    users.addAll(listUser)
    val command = readln()
    when(command) {
        "SHOW" -> {
            for (user in users)
                println(user)
        }
        "ADD" -> {
            val newUser = readln()
            users.add(newUser)
            for (user in users)
                println(user)
        }
        "REMOVE" -> {
            val user = readln()
            if (users.contains(user))
                users.remove(user)
            for (user in users)
                println(user)
        }
        "REMOVE_AT" -> {
            val index = readln().toInt()
            if (index < users.size)
                users.removeAt(index)
            for (user in users)
                println(user)
        }
        else -> println("Некорректное значение")
    }
}