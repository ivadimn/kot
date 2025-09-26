package corporation

import java.io.File

object ProductRepository {

    val file = File("product_cards.txt")
    private val _items = loadAllItems()
    val items : List<ProductCard>
        get() = _items.toList()

    fun loadAllItems() : MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
        if (!file.exists())
            return cards
        val lines = file.readLines()
        for (line in lines) {
            val properties = line.split("%")
            val productType = ProductType.valueOf(properties[properties.size - 1])
            val product = when(productType) {
                ProductType.FOOD -> {
                    FoodProducts(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toInt())
                }
                ProductType.HOUSEHOLD -> {
                    Household(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toInt())
                }
                ProductType.SHOE -> {
                    Shoes(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toFloat())
                }
            }
            cards.add(product)
        }
        return cards
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (item in items) {
            content.append("${item.name}%${item.brand}%${item.price}")
            when (item) {
                is FoodProducts -> content.append("%${item.energyValue}")
                is Household -> content.append("%${item.power}")
                is Shoes -> content.append("%${item.size}")
            }
            content.append("%${item.productType}\n")
        }
        file.writeText(content.toString())
    }

    fun saveItem(item: ProductCard) {
        _items.add(item)
    }

    fun removeItem(name : String) {
        for ((index, item) in _items.withIndex()) {
            if (name == item.name) {
                _items.removeAt(index)
                break
            }
        }
    }
}