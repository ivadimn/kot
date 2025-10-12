package profile

import extensions.myForEach


fun main() {
    val persons = PersonRepository.items
    showEmail(persons)
}

fun showEmail(persons: List<Person>) {
    print("Введите id пользователя: ")
    val id = readln().toInt()
    val person = persons.find { it.id == id }
    person?.let { println(it.email) } ?: println("Пользователь не найден")
}