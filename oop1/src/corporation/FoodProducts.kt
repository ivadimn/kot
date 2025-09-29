package corporation

data class FoodProducts (
    override val name: String,
    override val brand: String,
    override val price: Int,
    val energyValue : Int
) : ProductCard(name, brand, price, ProductType.FOOD){

}