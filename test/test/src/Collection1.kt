fun main() {
    val daysInMonth = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    print("Введите номер месяца (от 1 до 12): ")
    val  number = readln().toInt()
    println("В месяце $number ${daysInMonth[number - 1]} дней.")
}