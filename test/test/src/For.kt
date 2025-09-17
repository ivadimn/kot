fun main() {
    val brands = listOf<String>("Mazda", "Nissan", "Toyota", "Kia" )
    val brandName = readln()
    var founded = false
    for (brand in brands) {
        if (brand == brandName) {
            founded = true
            break
        }
    }
    println(founded)
}