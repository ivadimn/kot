package corporation

class FoodProducts (
    name: String,
    brand: String,
    price: Int,
    val energyValue : Int
) : ProductCard(name, brand, price, ProductType.FOOD){

    override fun printInfo() {
        print("Тип продукта: ${productType.name}, Наименование: ${this.name}, Брэнд: ${this.brand}, Цена: ${this.price}")
        println("Энергетическая ценность: ${this.energyValue}")
    }
}