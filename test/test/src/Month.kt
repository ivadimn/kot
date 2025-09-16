fun main() {
    val months = listOf<String>("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
                                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
    val number  = readln().toInt()
    if (number !in 1..12)
        println("Некорректное значение: $number")
    else
        println(months[number - 1])
}