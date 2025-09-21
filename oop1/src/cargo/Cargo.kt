package cargo

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,
    val grossWeight: Double
) {
    fun printInfo() {
        println("Длина: $length")
        println("Ширина: $width")
        println("Высота: $height")
        println("Тип упаковки: $typePackaging")
        println("Вес нетто: $netWeight")
        println("Вес брутто: $grossWeight")
    }
}