package shop

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {
    // напишите здесь ваше решение
    val localOrders = mutableListOf<Order>()
    val forDelete = mutableListOf<Order>()
    localOrders.addAll(orders)
    for(order in localOrders) {
        val (id, status, type) = order
        if(typeToRemove == type && status == "completed")
            forDelete.add(order)
    }
    localOrders.removeAll(forDelete)
    return localOrders.toList()
}

fun main() {

}