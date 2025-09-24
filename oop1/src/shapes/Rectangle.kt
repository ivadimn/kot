package shapes

class Rectangle(
    name: String,
    val width: Double,
    val height: Double
) : Shape(name) {

    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return  2 * (width + height)
    }
}