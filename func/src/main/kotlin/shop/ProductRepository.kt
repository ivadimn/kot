package shop

import kotlinx.serialization.json.Json
import java.io.File

object ProductRepository {
    val db = File("products.json")
    private val _items = loadAllItems()
    val items : List<ProductCard>
        get() = _items.toList()

    private fun loadAllItems() : MutableList<ProductCard> {
        val content = db.readText().trim()
        return Json.decodeFromString<MutableList<ProductCard>>(content)
    }

    fun writeAllItems() {
        val content = Json.encodeToString(items)
        db.writeText(content)
    }
}