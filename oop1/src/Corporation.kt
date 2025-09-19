fun main() {
    val prodCard = ProductCard()
    prodCard.name = readln()
    prodCard.brand = readln()
    prodCard.size = readln().toFloat()
    prodCard.price = readln().toInt()

    prodCard.printInfo()
}