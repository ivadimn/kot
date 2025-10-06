package shop


fun main() {
    val products = ProductRepository.items

    var filtered = filter(products, {product: ProductCard -> product.price > 500})

    filtered = filter(filtered, {product: ProductCard -> product.rating > 4})

    filtered = filter(filtered) { product: ProductCard -> product.category == ProductCategory.SPORTS }

    for (product in filtered)
        //cats.add(product.category)
        println(product)

//    for (cat in cats)
//        println(cat)

}
fun filter(products: List<ProductCard>, isSuitable: (ProductCard) -> Boolean) : List<ProductCard>{
    val list = mutableListOf<ProductCard>()
    for (product in products) {
        if (isSuitable(product))
            list.add(product)
    }
    return list
}