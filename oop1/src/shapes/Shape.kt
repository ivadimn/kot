package shapes

import kotlin.math.round

abstract class Shape(
    val name: String
) {
    abstract fun area() : Double
    abstract fun perimeter() : Double

    protected fun roundToTwoDecimals(value: Double): Double {
        var tmp = value * 100
        tmp = round(tmp)
        return tmp / 100
    }

}