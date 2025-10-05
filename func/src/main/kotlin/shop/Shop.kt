package shop


fun main() {
    val products = ProductRepository.items

    var filtered = filter(products, object : Condition {
       override fun isSuitable(product: ProductCard): Boolean {
            return product.price > 500
        }
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(product: ProductCard): Boolean {
            return product.rating > 4
        }
    })

    filtered = filter(filtered, object : Condition {
        override fun isSuitable(product: ProductCard): Boolean {
            return product.category == ProductCategory.SPORTS
        }
    })

    for (product in filtered)
        //cats.add(product.category)
        println(product)

//    for (cat in cats)
//        println(cat)

}
fun filter(products: List<ProductCard>, condition: Condition) : List<ProductCard>{
    val list = mutableListOf<ProductCard>()
    for (product in products) {
        if (condition.isSuitable(product))
            list.add(product)
    }
    return list
}