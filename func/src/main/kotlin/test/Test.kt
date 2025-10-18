package test

import extensions.myWidth
import extensions.transformValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("age") val age: Int,
    @SerialName("is_active") val isActive: Boolean,
    @SerialName("address") val address: String,
    @SerialName("phone") val phone: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("role") val role: String
)

fun main() {

    myWidth(mutableListOf<Int>()) {
        while (true) {
            print("Enter number or 0 to exit: ")
            val number = readln().toInt().takeIf { it != 0 } ?: break
            add(number)
        }
        println("Max: ${max()}")
        println("Min: ${min()}")
        this
    }.forEach { println(it) }

}



fun usersToMap(users: List<User>): Map<Int, User> {
    // Реализуйте функцию здесь
    return users.associate { it.id to it }
}

fun showContacts(contacts : Map<String, String>) {
    while (true) {
        print("Введите имя: ")
        val name = readln()
        if (name == "0") break
        contacts[name]?.let { println(it)} ?: println("Контакт не найден")
    }
}

fun processProductsForUI(products: List<Product>): List<String> {
    // Реализуйте логику здесь
    return products.filter { it.price >= 100 }
        .filter { it.category == "Electronics" || it.category == "Books" }
        .sortedBy { it.price }
        .map { "Product ID: ${it.id} | Name: ${it.name} | Price: $${it.price}" }

}

fun processStrings(strings: List<String>): List<String> {
    return strings.also {println("Исходный список: $it") }
        .filter { it.isNotBlank() }
        .also { println("Этап 1: Осталось ${it.size} непустых строк")}
        .map { it.trim() }                        // Убираем лишние пробелы
        .filter { it.length > 3 }
        .also {  println("Этап 2: Строки длиной более 3 символов: $it") }
        .sortedBy { it.length }  // Сортируем по длине
        .also { println("Этап 3: Первые 3 строки после сортировки: ${it.take(3)}") }
        .map { it.uppercase() }       // Преобразуем в верхний регистр
        .also { println("Этап 4: Все строки в верхнем регистре: $it") }
        .distinct()                               // Убираем дубликаты
        .take(5)                              // Берём первые 5 строк
        .also { println("Этап 5: Итоговый результат: $it") }
}

