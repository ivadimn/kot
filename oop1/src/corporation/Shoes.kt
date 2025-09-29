package corporation

data class Shoes(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size : Float
) : ProductCard(name, brand, price, ProductType.SHOE){

}