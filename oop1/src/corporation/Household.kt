package corporation

class Household(
    name: String,
    brand: String,
    price: Int,
    val power : Int
) : ProductCard(name, brand, price, ProductType.HOUSEHOLD){

    override fun printInfo() {
        print("Тип продукта: ${productType.name}, Наименование: ${this.name}, Брэнд: ${this.brand}, Цена: ${this.price}")
        println("Мощность: ${this.power}")
    }
}