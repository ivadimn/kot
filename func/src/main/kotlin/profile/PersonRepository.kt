package profile

import kotlinx.serialization.json.Json
import shop.ProductCard
import java.io.File

object PersonRepository {
    val db = File("profiles.json")
    private val _items = loadAllItems()
    val items : List<Person>
        get() = _items.toList()

    private fun loadAllItems() : MutableList<Person> {
        val content = db.readText().trim()
        return Json.decodeFromString<MutableList<Person>>(content)
    }

    fun writeAllItems() {
        val content = Json.encodeToString(items)
        db.writeText(content)
    }
}