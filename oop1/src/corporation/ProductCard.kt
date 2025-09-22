package corporation

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int
) {
    open fun printInfo() {
        print("Наименование: ${this.name}, Брэнд: ${this.brand}, Цена: ${this.price} ")
    }

}