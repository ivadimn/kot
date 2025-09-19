class ProductCard {
    var name: String = ""
    var brand: String = ""
    var size: Float = 0f
    var price: Int = 0

    fun printInfo() {
        println("Наименование: ${this.name}, Брэнд: ${this.brand}, Размер: ${this.size}, Цена: ${this.price}")
    }

}