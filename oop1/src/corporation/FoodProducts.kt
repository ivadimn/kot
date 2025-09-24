package corporation

class FoodProducts (
    name: String,
    brand: String,
    price: Int,
    val energyValue : Int
) : ProductCard(name, brand, price, ProductType.FOOD){

    override fun toString(): String {
        return "Тип продукта: ${productType.name}, Наименование: ${this.name}, " +
                "Брэнд: ${this.brand}, Цена: ${this.price}, Энергетическая ценность: ${this.energyValue}"
    }
}