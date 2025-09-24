package cats

class Leon(
    val countInPride: Int
): CatsFamily() {
    override fun eat() {
        println("Кушаю антилопу")
    }
}