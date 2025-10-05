package test

import kotlinx.serialization.json.Json
import shop.ProductCard
import java.io.File

object Repository {
    val db = File("prods.json")
    private val _items = loadAllItems()
    val items : List<Product>
        get() = _items.toList()

    private fun loadAllItems() : MutableList<Product> {
        val content = db.readText().trim()
        return Json.decodeFromString<MutableList<Product>>(content)
    }

    fun writeAllItems() {
        val content = Json.encodeToString(items)
        db.writeText(content)
    }
}