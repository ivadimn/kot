package db

class UserViewModel(private val repository: Repository) {

    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String> {
        // Реализуйте логику здесь
        val listUsers = mutableListOf<String>()
        val users = repository.getUsers().toMutableList()
        for(user in users) {
            if(user != null) {
                val description = "Name: ${user.name ?: "Unknown Name"}, Email: ${user.email ?: "Unknown Email"}, " +
                        "Age: ${user.age ?: 0}"
                listUsers.add(description)
            }
        }
        users.removeIf { it == null }
        return listUsers
    }
}