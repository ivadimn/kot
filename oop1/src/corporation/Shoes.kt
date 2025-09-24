package corporation

class Shoes(
    name: String,
    brand: String,
    price: Int,
    val size : Float
) : ProductCard(name, brand, price, ProductType.SHOE){


    override fun toString(): String {
        return "Тип продукта: ${productType.name}, Наименование: ${this.name}, Брэнд: ${this.brand}, " +
                "Цена: ${this.price}, Размер: ${this.size}"
    }
}