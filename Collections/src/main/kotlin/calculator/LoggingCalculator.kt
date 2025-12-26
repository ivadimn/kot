package calculator

class LoggingCalculator : Calculator {
    override fun sum(a: Int, b: Int) : Int {
        val result  = a + b
        println("Operation: sum($a,$b), Result: $result")
        return result
    }

    override fun sub(a: Int, b: Int) : Int {
        val result  = a - b
        println("Operation: sub($a,$b), Result: $result")
        return result
    }

    override fun mul(a: Int, b: Int) : Int {
        val result  = a * b
        println("Operation: mul($a,$b), Result: $result")
        return result
    }

    override fun div(a: Int, b: Int) : Double {
        val result  = a.toDouble() / b
        println("Operation: div($a,$b), Result: $result")
        return result
    }

}