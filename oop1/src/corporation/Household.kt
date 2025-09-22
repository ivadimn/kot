package corporation

class Household(
    name: String,
    brand: String,
    price: Int,
    val power : Int
) : ProductCard(name, brand, price){

    override fun printInfo() {
        super.printInfo()
        println("Мощность: ${this.power}")
    }
}