package shapes

class Circle(
    name: String,
    val radius: Double
) : Shape(name){
    override fun area() : Double {
        return radius * radius * 3.141592653589793
    }

    override fun perimeter() : Double {
        return 2 * radius * 3.141592653589793
    }
}