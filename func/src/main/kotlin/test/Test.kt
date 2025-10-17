package test

//Исключит из списка продукты, у которых цена меньше 100.
//Оставит только продукты из категорий "Electronics" или "Books".
//Отсортирует оставшиеся продукты по цене в порядке возрастания.
//Преобразует каждый продукт в строку формата:
//"Product ID: <id> | Name: <name> | Price: $<price>".
//Вернёт итоговый список строк, который будет отображён в пользовательском интерфейсе.

fun main() {
    val contacts = mutableMapOf<String, String>(
        Pair("vadim", "+79992125549"),
        Pair("anna", "+7165482443"),
        Pair("pavel", "+79031572353"),
        Pair("semen", "+79312076390")
        )
    print("Введите имя: ")
    val name = readln()
    print("Введите телефон: ")
    val phone = readln()
    contacts[name] = phone
    showContacts(contacts)
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

