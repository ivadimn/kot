package collections


fun main() {
    val numbers = MyArrayList<Int>()
    repeat(50) {
        numbers.add(it)
    }

    for (number in numbers) {
        println(number)
        //numbers.add(100)
    }
}