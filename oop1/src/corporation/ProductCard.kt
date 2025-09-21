package corporation

class ProductCard(
    val name: String,
    val brand: String,
    val size: Float,
    val price: Int
) {
    fun printInfo() {
        println("Наименование: ${this.name}, Брэнд: ${this.brand}, Размер: ${this.size}, Цена: ${this.price}")
    }

}