package collections

fun main() {
    val numbers = mutableListOf<Int>()
    while (true) {
        val number = readln().toInt()
        if (number == 0)
            break
        numbers.add(number)
    }
    numbers.forEach(::println)
}