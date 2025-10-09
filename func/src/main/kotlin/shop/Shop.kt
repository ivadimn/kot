package shop

fun main() {
    val products = ProductRepository.items

    //var filtered = filter(products, {product: ProductCard -> product.price > 500})

    //filtered = filter(filtered, {product: ProductCard -> product.rating > 4})

    var filtered = filter(products) { product: ProductCard -> product.category == ProductCategory.CLOTHING }
    filtered = transform(filtered) {it.copy(price = it.price * 2)}

    val strings = transform(filtered) { "${it.id} - ${it.name} - ${it.price}" }
    for (string in strings)
        //cats.add(product.category)
        println(string)

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

//fun  <R> transform(products: List<ProductCard>, operation: (ProductCard) -> R ): List<R> {
//    val result = mutableListOf<R>()
//    for (product in products) {
//        result.add(operation(product))
//    }
//    return result
//}

fun  <T, R> transform(items: List<T>, operation: (T) -> R ): List<R> {
    val result = mutableListOf<R>()
    for (item in items) {
        result.add(operation(item))
    }
    return result
}