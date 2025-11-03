package par613

data class Product(
    val name: String,
    val price: Double,
    val manufacturer: String,
    val months: Int
) {
    class Builder {

        var name: String = "Smartphone"
        var price: Double = 999.99
        var manufacturer: String = "TechCorp"
        var months: Int = 24

        fun name(name: String): Builder {
            this.name = name
            return this
        }
        fun price(price: Double): Builder {
            this.price = price
            return this
        }
        fun manufacturer(manufacturer: String): Builder {
            this.manufacturer = manufacturer
            return this
        }
        fun warranty(months: Int): Builder {
            this.months = months
            return this
        }
        fun build(): Product {
            return Product(name, price, manufacturer, months)
        }
    }
}
fun task() : Product {
    val product = Product.Builder()
        .name("Smartphone")
        .price(999.99)
        .manufacturer("TechCorp")
        .warranty(24)
        .build()

    return product
}