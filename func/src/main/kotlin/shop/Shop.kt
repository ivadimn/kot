package shop

import extensions.myAlso
import extensions.transform

fun main() {
    ProductRepository.items.myAlso {
        println("Filter by price > 500")
    }.filter {product: ProductCard -> product.price > 500}.also {
        println("Filter by category")

    }.filter {product: ProductCard -> product.category == ProductCategory.CLOTHING}.also {
        println("Filter by rating")
    }.filter {product: ProductCard -> product.rating > 4  }.also {
        println("Map to product with price * 2")
    }.map { it.copy(price = it.price * 2) }.also {
        println("Map to string")
    }.map { "${it.id} - ${it.name} - ${it.price}" }.also {
        println("Print info")
    }.forEach { println(it) }

}



