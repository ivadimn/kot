package calculator

class SimpleCalculator : Calculator {
    override fun sum(a: Int, b: Int) : Int = a + b

    override fun sub(a: Int, b: Int) : Int = a - b

    override fun mul(a: Int, b: Int) : Int = a * b

    override fun div(a: Int, b: Int) : Double = a.toDouble() / b

}