package shop

import extensions.transform

fun main() {
    val products = ProductRepository.items.filter {product: ProductCard -> product.price > 500}
        .filter {product: ProductCard -> product.category == ProductCategory.CLOTHING}
        .filter {product: ProductCard -> product.rating > 4  }
        .map { it.copy(price = it.price * 2) }
        .map { "${it.id} - ${it.name} - ${it.price}" }
        .forEach { println(it) }

}



