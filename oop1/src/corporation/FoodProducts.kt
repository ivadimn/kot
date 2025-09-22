package corporation

class FoodProducts (
    name: String,
    brand: String,
    price: Int,
    val energyValue : Int
) : ProductCard(name, brand, price){

    override fun printInfo() {
        super.printInfo()
        println("Энергетическая ценность: ${this.energyValue}")
    }
}