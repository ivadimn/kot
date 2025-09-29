package corporation

data class Household(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val power : Int
) : ProductCard(name, brand, price, ProductType.HOUSEHOLD){

}