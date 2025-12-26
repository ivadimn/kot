package calculator

fun main() {
    val calc = SimpleCalculator()
    val result  = calc.sum(10, 5)
    println(result)
    val result2  = calc.sum(100, 50)
    println(result2)
}