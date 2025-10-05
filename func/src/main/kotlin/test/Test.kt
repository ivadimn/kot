package test

import kotlinx.serialization.json.Json
import shop.ProductRepository
import java.io.File

fun main() {
    val products = Repository.items
    val cats = mutableSetOf<String>()
    for (product in products)
        //cats.add(product.productCategory)
        println(product)

    //for (cat in cats)
    //    println(cat)
}


