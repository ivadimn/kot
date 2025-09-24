package corporation

class Shoes(
    name: String,
    brand: String,
    price: Int,
    val size : Float
) : ProductCard(name, brand, price, ProductType.SHOE){

    override fun printInfo() {
        print("Тип продукта: ${productType.name}, Наименование: ${this.name}, Брэнд: ${this.brand}, Цена: ${this.price}")
        println("Размер: ${this.size}")
    }
}