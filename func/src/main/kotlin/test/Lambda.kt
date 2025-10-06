package test

fun main() {
    startProcessing()
}

fun processNumber(numbers: List<Int>, filter: (Int) -> Boolean, transform: (Int) -> Int) : List<Int> {
    val filtered = mutableListOf<Int>()
    for (number in numbers) {
        if (filter(number))
            filtered.add(number)
    }
    for ((i, number) in filtered.withIndex())
        filtered[i] = transform(number)
    return filtered
}

fun startProcessing() {
    println("Введите числа, разделенные пробелами:")
    val strNumbers = readln().split(" ")
    var numbers = strNumbers.map { it.toInt() }
    numbers = processNumber(numbers, {number : Int -> number > 10}, {number: Int -> number * 3})
    println("Результат обработки: $numbers")

}