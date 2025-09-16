fun main() {
    print("Введите первое число: ")
    val number1 = readln().toDouble()
    print("Введите операцию: ")
    val operation = readln()
    print("Введите второе число: ")
    val number2 = readln().toDouble()
//    val result  = when (operation) {
//        "+" -> number1 + number2
//        "-" -> number1 - number2
//        "*" -> number1 * number2
//        "/" if number2.toInt() != 0 -> number1 / number2
//        else -> println("Не правильная операция")
//    }
//    println("Результат вычислений: $result")


    if (operation == "+")
        println("Результат вычислений: ${number1 + number2}")
    else if (operation == "-")
        println("Результат вычислений: ${number1 - number2}")
    else if (operation == "*")
        println("Результат вычислений: ${number1 * number2}")
    else if (operation == "/")
        println("Результат вычислений: ${number1 / number2}")
    else
        println("Не правильняа операция")
}