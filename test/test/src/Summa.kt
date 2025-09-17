fun main() {
    val numbers = readln().split(" ")
    var summa = 0
    for (number in numbers)
    {
        summa += number.toInt()
    }
    println(summa)
}