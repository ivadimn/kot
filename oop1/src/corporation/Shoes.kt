package corporation

class Shoes(
    name: String,
    brand: String,
    price: Int,
    val size : Float
) : ProductCard(name, brand, price){

    override fun printInfo() {
        super.printInfo()
        println("Размер: ${this.size}")
    }
}