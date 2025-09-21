package cargo

fun main() {
    val objectParam = readln().split(" ")
    val deliveryObject = DeliveryObject(
        objectParam[0].toInt(),
        objectParam[1].toInt(),
        objectParam[2].toInt(),
        objectParam[3].toDouble()
    )

    val warehouse = Warehouse()
    val pack = warehouse.packCargo(deliveryObject)
    pack.printInfo()
}