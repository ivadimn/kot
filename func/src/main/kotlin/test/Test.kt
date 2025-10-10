package test

//Исключит из списка продукты, у которых цена меньше 100.
//Оставит только продукты из категорий "Electronics" или "Books".
//Отсортирует оставшиеся продукты по цене в порядке возрастания.
//Преобразует каждый продукт в строку формата:
//"Product ID: <id> | Name: <name> | Price: $<price>".
//Вернёт итоговый список строк, который будет отображён в пользовательском интерфейсе.

fun main() {
    val products = listOf(
        Product(1, "Laptop", 999.99, "Electronics"),
        Product(2, "Notebook", 12.99, "Books"),
        Product(3, "Tablet", 299.99, "Electronics"),
        Product(4, "Novel", 15.49, "Books"),
        Product(5, "Pen", 2.99, "Stationery")
    )
    processProductsForUI(products).forEach { println(it) }
}

fun processProductsForUI(products: List<Product>): List<String> {
    // Реализуйте логику здесь
    return products.filter { it.price >= 100 }
        .filter { it.category == "Electronics" || it.category == "Books" }
        .sortedBy { it.price }
        .map { "Product ID: ${it.id} | Name: ${it.name} | Price: $${it.price}" }

}


