fun main() {
    val expression = readln()
    val ops = expression.split(" ")
    val number1 = ops[0].toDouble()
    val number2 = ops[2].toDouble()

    val result = when(ops[1])
    {
        "+" -> println("Результат вычислений: ${number1 + number2}")
        "-" -> println("Результат вычислений: ${number1 - number2}")
        "*" -> println("Результат вычислений: ${number1 * number2}")
        "/" -> println("Результат вычислений: ${number1 / number2}")
        else -> println("Не правильняа операция")
    }
}